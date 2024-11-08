package com.Astefil_Inflables.Catalogo.Backend.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import com.Astefil_Inflables.Catalogo.Backend.models.Article;
import com.Astefil_Inflables.Catalogo.Backend.models.Image;
import com.Astefil_Inflables.Catalogo.Backend.repositories.ImageRepository;
import com.Astefil_Inflables.Catalogo.Backend.services.interfaces.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements IImageService {

    @Autowired
    private ImageRepository imageRepository;

    private final Path root = Paths.get("uploads");

    @Override
    public void init() {
        try {
            Files.createDirectory(root);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize folder for upload!");
        }
    }

    @Override
    @Transactional
    public Image save(MultipartFile file) {
        try {
            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            Image image = this.imageRepository.save(new Image(filename, file.getContentType()));
            Files.copy(file.getInputStream(), this.root.resolve(image.getId() + "_" + file.getOriginalFilename()));
            return image;
        } catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Image> save(MultipartFile[] files) {
        return Stream.of(files).map(this::save).toList();
    }

    @Override
    @Transactional
    public Image save(MultipartFile file, Article article) {
        try{
            File articleFolder = new File("uploads/" + article.getId());
            if (!articleFolder.exists()) {
                articleFolder.mkdirs();
            }
            Files.copy(file.getInputStream(), this.root.resolve(article.getId() +"/" + Objects.requireNonNull(file.getOriginalFilename())));
            Image image = this.imageRepository.save(new Image(file.getOriginalFilename(), file.getContentType()));
            image.setArticle(article);
            return this.imageRepository.save(image);
        }catch (Exception e) {
            throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Image> save(MultipartFile[] files, Article article) {
        return Stream.of(files).map(file -> this.save(file, article)).toList();
    }

    @Override
    @Transactional
    public List<Image> save(File[] files, Article article) {
        return Stream.of(files).map(file -> {
            try {
                Image image = this.imageRepository.save(new Image(file.getName(), Files.probeContentType(file.toPath())));
                File articleFolder = new File("uploads/" + article.getId());
                String fileName = article.getId() +"/" + image.getId() + "_" + file.getName();
                if (!articleFolder.exists()) {
                    articleFolder.mkdirs();
                }
                if (Files.exists(this.root.resolve(fileName))) {
                    Files.delete(this.root.resolve(fileName));
                }
                Files.copy(file.toPath(), this.root.resolve(fileName));
                image.setArticle(article);
                return this.imageRepository.save(image);
            } catch (IOException e) {
                throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
            }
        }).toList();
    }

    @Override
    public Resource load(String filename) {
        try {
            Path file = root.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(root.toFile());
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.root, 2).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }

}
