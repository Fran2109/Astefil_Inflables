package com.Astefil_Inflables.Catalogo.Backend.services;

import com.Astefil_Inflables.Catalogo.Backend.exceptions.ItemNotFoundException;
import com.Astefil_Inflables.Catalogo.Backend.models.Article;
import com.Astefil_Inflables.Catalogo.Backend.models.Category;
import com.Astefil_Inflables.Catalogo.Backend.models.Image;
import com.Astefil_Inflables.Catalogo.Backend.repositories.ArticleRepository;
import com.Astefil_Inflables.Catalogo.Backend.services.interfaces.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private ImageServiceImpl imageService;

    @Override
    @Transactional
    public Article createArticle(String name, String description, Float height, Float width, Float lenght, Long idCategory) {
        Category category = this.categoryService.getCategoryById(idCategory);
        return this.createArticle(name, description, height, width, lenght, category);
    }

    @Override
    @Transactional
    public Article createArticle(String name, String description, Float height, Float width, Float lenght, Category category) {
        Article article = new Article(name, description, height, width, lenght, category);
        return this.articleRepository.save(article);
    }

    @Override
    @Transactional
    public Article createArticle(String name, String description, Float height, Float width, Float lenght, Category category, MultipartFile[] images) {
        Article article = new Article(name, description, height, width, lenght, category);
        article = this.articleRepository.save(article);
        List<Image> imagesList = this.imageService.save(images, article);
        article.setImages(imagesList);
        return article;
    }

    @Override
    @Transactional
    public Article createArticle(String name, String description, Float height, Float width, Float lenght, Long idCategory, MultipartFile[] images) {
        Category category = this.categoryService.getCategoryById(idCategory);
        return this.createArticle(name, description, height, width, lenght, category, images);
    }

    @Override
    @Transactional
    public Article createArticle(String name, String description, Float height, Float width, Float lenght, Category category, File[] images){
        Article article = new Article(name, description, height, width, lenght, category);
        article = this.articleRepository.save(article);
        List<Image> imagesList = this.imageService.save(images, article);
        article.setImages(imagesList);
        return article;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Article> getAllArticles() {
        return (List<Article>) this.articleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Article getArticleById(Long id){
        return this.articleRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Article with id: '"+ id +"'not found"));
    }

    @Override
    @Transactional
    public Article updateArticle(Long id, String name, String description, Float height, Float width, Float lenght) {
        Article article = this.getArticleById(id);
        article.setName(name);
        article.setDescription(description);
        article.setHeight(height);
        article.setWidth(width);
        article.setLength(lenght);
        return this.articleRepository.save(article);
    }

    @Override
    @Transactional
    public Article updateArticle(Long id, String name, String description, Float height, Float width, Float length, Long idCategory) {
        Category category = this.categoryService.getCategoryById(idCategory);
        Article article = this.getArticleById(id);
        article.setName(name);
        article.setDescription(description);
        article.setHeight(height);
        article.setWidth(width);
        article.setLength(length);
        article.setCategory(category);
        return this.articleRepository.save(article);
    }

    @Override
    @Transactional
    public void deleteArticle(Long id) {
        this.getArticleById(id);
        this.articleRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Article> getArticlesByCategory(Long id) {
        Category category = this.categoryService.getCategoryById(id);
        return this.articleRepository.findByCategory(category);
    }
}
