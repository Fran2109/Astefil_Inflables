package com.Astefil_Inflables.Catalogo.Backend.dto.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CategoryDTO {
    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;

    public CategoryDTO() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
