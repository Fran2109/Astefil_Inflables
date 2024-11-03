package com.Astefil_Inflables.Catalogo.Backend.dto.Article;

import jakarta.validation.constraints.NotNull;

public class CreateArticleDTO extends ArticleDTOAbs{
    @NotNull(message = "Category cannot be null")
    private Long idCategory;

    public CreateArticleDTO() {
    }
    public Long getIdCategory(){
        return idCategory;
    }
    public void setIdCategory(Long idCategory){
        this.idCategory = idCategory;
    }
}
