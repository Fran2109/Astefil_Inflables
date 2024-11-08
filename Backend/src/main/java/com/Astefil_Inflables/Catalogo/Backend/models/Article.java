package com.Astefil_Inflables.Catalogo.Backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_article")
    private Long id;

    @Column(nullable = false, length = 50)
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Description cannot be null")
    @NotBlank(message = "Description cannot be blank")
    private String description;

    @Column(nullable = false)
    @NotNull(message = "Height cannot be null")
    @Min(value = 0, message = "Height must be positive")
    private Float height;

    @Column(nullable = false)
    @NotNull(message = "Width cannot be null")
    @Min(value = 0, message = "Width must be positive")
    private Float width;

    @Column(nullable = false)
    @NotNull(message = "Lenght cannot be null")
    @Min(value = 0, message = "Length must be positive")
    private Float length;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    @NotNull(message = "Category cannot be null")
    @JsonBackReference
    private Category category;

    @OneToMany(mappedBy = "article")
    @JsonManagedReference
    private List<Image> images;

    public Article(){

    }

    public Article(String name, String description, Float height, Float width, Float length, Category category){
        this.name = name;
        this.description = description;
        this.height = height;
        this.width = width;
        this.length = length;
        this.category = category;
    }

    public Article(String name, String description, Float height, Float width, Float length, Category category, List<Image> images){
        this.name = name;
        this.description = description;
        this.height = height;
        this.width = width;
        this.length = length;
        this.category = category;
        this.images = images;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description) {this.description = description;}
    public Float getHeight(){
        return height;
    }
    public void setHeight(Float height) {this.height = height;}
    public Float getWidth(){
        return width;
    }
    public void setWidth(Float width) {this.width = width;}
    public Float getLength(){
        return length;
    }
    public void setLength(Float length) {this.length = length;}
    public Category getCategory(){
        return category;
    }
    public void setCategory(Category category){
        this.category = category;
    }
    public List<Image> getImages(){
        return images;
    }
    public void setImages(List<Image> images){
        this.images = images;
    }
}
