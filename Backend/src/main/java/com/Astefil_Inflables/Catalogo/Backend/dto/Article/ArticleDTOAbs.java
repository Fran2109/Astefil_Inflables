package com.Astefil_Inflables.Catalogo.Backend.dto.Article;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

abstract class ArticleDTOAbs {
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Description cannot be null")
    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotNull(message = "Height cannot be null")
    @Min(value = 0, message = "Height must be positive")
    private Float height;

    @NotNull(message = "Width cannot be null")
    @Min(value = 0, message = "Width must be positive")
    private Float width;

    @NotNull(message = "Length cannot be null")
    @Min(value = 0, message = "Length must be positive")
    private Float length;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Float getHeight(){
        return height;
    }
    public void setHeight(Float height){
        this.height = height;
    }
    public Float getWidth(){
        return width;
    }
    public void setWidth(Float width){
        this.width = width;
    }
    public Float getLength(){
        return length;
    }
    public void setLength(Float length){
        this.length = length;
    }
}
