package com.Astefil_Inflables.Catalogo.Backend.services.interfaces;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import com.Astefil_Inflables.Catalogo.Backend.models.Article;
import com.Astefil_Inflables.Catalogo.Backend.models.Image;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IImageService {
    void init();
    Image save(MultipartFile file);
    Image save(MultipartFile file, Article article);
    List<Image> save(MultipartFile[] files);
    List<Image> save(MultipartFile[] files, Article article);
    List<Image> save(File[] files, Article article);
    Resource load(String filename);
    void deleteAll();
    Stream<Path> loadAll();
}
