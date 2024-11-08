package com.Astefil_Inflables.Catalogo.Backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_image")
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Type cannot be null")
    @NotBlank(message = "Type cannot be blank")
    private String type;

    @ManyToOne
    @JoinColumn(name = "id_article")
    @JsonBackReference
    private Article article;

    public Image() {
    }

    public Image(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Image(String name, String type, Article article) {
        this.name = name;
        this.type = type;
        this.article = article;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Article getArticle() {
        return this.article;
    }
    public void setArticle(Article article) {
        this.article = article;
    }
}
