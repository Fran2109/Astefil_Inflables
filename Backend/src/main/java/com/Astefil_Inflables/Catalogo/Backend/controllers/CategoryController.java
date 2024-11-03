package com.Astefil_Inflables.Catalogo.Backend.controllers;

import com.Astefil_Inflables.Catalogo.Backend.dto.Category.CategoryDTO;
import com.Astefil_Inflables.Catalogo.Backend.models.Category;
import com.Astefil_Inflables.Catalogo.Backend.services.interfaces.ICategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value =  "/api/category")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping(path="")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping(path="/{id}")
    public Category getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping(path = "")
    public Category createCategory(@Valid @RequestBody @NotNull CategoryDTO category) {
        return this.categoryService.createCategory(category.getName());
    }

    @PutMapping(path = "/{id}")
    public Category updateCategory(@PathVariable Long id, @Valid @RequestBody @NotNull CategoryDTO category) {
        return this.categoryService.updateCategory(id, category.getName());
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        this.categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{id}/incrementOrderNumber")
    public Category incrementOrderNumber(@PathVariable Long id) {
        return this.categoryService.incrementOrderNumber(id);
    }

    @PutMapping(path = "/{id}/decrementOrderNumber")
    public Category decrementOrderNumber(@PathVariable Long id) {
        return this.categoryService.decrementOrderNumber(id);
    }

    @GetMapping(path = "/order")
    public List<Category> getAllCategoriesOrdered() {
        return this.categoryService.getCategoriesOrderedByOrderNumber();
    }
}
