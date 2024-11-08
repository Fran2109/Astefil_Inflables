package com.Astefil_Inflables.Catalogo.Backend.dto.Article;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

public class CreateArticleDTO extends ArticleDTOAbs{
    @NotNull(message = "Category cannot be null")
    private Long idCategory;

    @NotNull(message = "Images cannot be null")
    @Size(min = 1, message = "Images must have at least one element")
    private MultipartFile[] images;

    public CreateArticleDTO() {
    }
    public Long getIdCategory(){
        return idCategory;
    }
    public void setIdCategory(Long idCategory){
        this.idCategory = idCategory;
    }
    public MultipartFile[] getImages(){
        return images;
    }
    public void setImages(MultipartFile[] images){
        this.images = images;
    }
}
