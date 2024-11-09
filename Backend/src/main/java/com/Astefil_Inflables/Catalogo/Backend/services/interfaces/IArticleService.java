package com.Astefil_Inflables.Catalogo.Backend.services.interfaces;

import com.Astefil_Inflables.Catalogo.Backend.models.Article;
import com.Astefil_Inflables.Catalogo.Backend.models.Category;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

public interface IArticleService {
    Article createArticle(String name, String description, Float height, Float width, Float lenght, Long idCategory);
    Article createArticle(String name, String description, Float height, Float width, Float lenght, Category category);
    Article createArticle(String name, String description, Float height, Float width, Float lenght, Category category, MultipartFile[] images);
    Article createArticle(String name, String description, Float height, Float width, Float lenght, Long idCategory, MultipartFile[] images);
    Article createArticle(String name, String description, Float height, Float width, Float lenght, Category category, File[] images);
    List<Article> getAllArticles();
    Article getArticleById(Long id);
    Article updateArticle(Long id, String name, String description, Float height, Float width, Float lenght);
    Article updateArticle(Long id, String name, String description, Float height, Float width, Float lenght, Long idCategory);
    void deleteArticle(Long id);
    List<Article> getArticlesByCategory(Long id);
    List<Article> getRelatedArticles(Long id);
}
