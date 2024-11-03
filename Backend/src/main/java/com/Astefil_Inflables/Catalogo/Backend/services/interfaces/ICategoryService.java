package com.Astefil_Inflables.Catalogo.Backend.services.interfaces;

import com.Astefil_Inflables.Catalogo.Backend.models.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category createCategory(String name);
    Category updateCategory(Long id, String name);
    void deleteCategory(Long id);
    Category incrementOrderNumber(Long id);
    Category decrementOrderNumber(Long id);
    List<Category> getCategoriesOrderedByOrderNumber();
}
