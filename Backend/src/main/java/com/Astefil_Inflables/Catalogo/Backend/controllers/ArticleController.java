package com.Astefil_Inflables.Catalogo.Backend.controllers;

import com.Astefil_Inflables.Catalogo.Backend.dto.Article.CreateArticleDTO;
import com.Astefil_Inflables.Catalogo.Backend.dto.Article.UpdateArticleDTO;
import com.Astefil_Inflables.Catalogo.Backend.models.Article;
import com.Astefil_Inflables.Catalogo.Backend.services.interfaces.IArticleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/article")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ArticleController {
    @Autowired
    private IArticleService articleService;

    @GetMapping(path = "")
    public List<Article> getAllArticles() {
        return this.articleService.getAllArticles();
    }

    @GetMapping(path = "/{id}")
    public Article getArticleById(@PathVariable Long id){
        return this.articleService.getArticleById(id);
    }

    @PostMapping(path = "")
    public Article createArticle(@ModelAttribute @Valid @NotNull CreateArticleDTO article) {
        return this.articleService.createArticle(article.getName(), article.getDescription(), article.getHeight(), article.getWidth(), article.getLength(), article.getIdCategory(), article.getImages());
    }

    @PutMapping(path = "/{id}")
    public Article updateArticle(@PathVariable Long id, @Valid @RequestBody @NotNull UpdateArticleDTO article) {
        return this.articleService.updateArticle(id, article.getName(), article.getDescription(), article.getHeight(), article.getWidth(), article.getLength());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable Long id) {
        this.articleService.deleteArticle(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/category/{id}")
    public List<Article> getArticlesByCategory(@PathVariable Long id) {
        return this.articleService.getArticlesByCategory(id);
    }
}
