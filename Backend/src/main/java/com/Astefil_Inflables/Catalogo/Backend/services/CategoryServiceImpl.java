package com.Astefil_Inflables.Catalogo.Backend.services;

import com.Astefil_Inflables.Catalogo.Backend.exceptions.ItemNotFoundException;
import com.Astefil_Inflables.Catalogo.Backend.exceptions.NotAllowedException;
import com.Astefil_Inflables.Catalogo.Backend.models.Category;
import com.Astefil_Inflables.Catalogo.Backend.repositories.CategoryRepository;
import com.Astefil_Inflables.Catalogo.Backend.services.interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Category> getAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Category getCategoryById(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Category with id: '"+ id +"'not found"));
    }

    @Override
    @Transactional
    public Category createCategory(String name) {
        List<Category> categories = this.getAllCategories();
        for(Category category : categories){
            if(category.getName().equals(name)){
                throw new NotAllowedException("Category with name: '"+ name +"' already exists");
            }
        }
        Integer orderNumber = categories.size() + 1;
        Category newCategory = new Category(name, orderNumber);
        return this.categoryRepository.save(newCategory);
    }

    @Override
    @Transactional
    public Category updateCategory(Long id, String name) {
        Category category = this.getCategoryById(id);
        category.setName(name);
        return this.categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        Category category = this.getCategoryById(id);
        this.categoryRepository.delete(category);
        if(this.getAllCategories().size() == 0){
            return;
        }
        if(category.getOrderNumber() < this.categoryRepository.getMaxOrderNumber()){
            for(Category category1 : this.getAllCategories()){
                if(category1.getOrderNumber() > category.getOrderNumber()){
                    category1.setOrderNumber(category1.getOrderNumber() - 1);
                    this.categoryRepository.save(category1);
                }
            }
        }
    }

    @Override
    @Transactional
    public Category incrementOrderNumber(Long id){
        Category category = this.getCategoryById(id);
        Integer maxOrderNumber = this.categoryRepository.getMaxOrderNumber();
        if(category.getOrderNumber().equals(maxOrderNumber)){
            throw new NotAllowedException("Category with id: '"+ id +"' already has the highest order number");
        }
        Category nextCategory = this.categoryRepository.findByOrderNumber(category.getOrderNumber() + 1);
        nextCategory.setOrderNumber(maxOrderNumber + 1);
        this.categoryRepository.save(nextCategory);
        category.setOrderNumber(category.getOrderNumber() + 1);
        this.categoryRepository.save(category);
        nextCategory.setOrderNumber(category.getOrderNumber() - 1);
        this.categoryRepository.save(nextCategory);
        return category;
    }

    @Override
    @Transactional
    public Category decrementOrderNumber(Long id){
        Category category = this.getCategoryById(id);
        if(category.getOrderNumber().equals(1)){
            throw new NotAllowedException("Category with id: '"+ id +"' already has the lowest order number");
        }
        Category previousCategory = this.categoryRepository.findByOrderNumber(category.getOrderNumber() - 1);
        previousCategory.setOrderNumber(this.categoryRepository.getMaxOrderNumber() + 1);
        this.categoryRepository.save(previousCategory);
        category.setOrderNumber(category.getOrderNumber() - 1);
        this.categoryRepository.save(category);
        previousCategory.setOrderNumber(category.getOrderNumber() + 1);
        this.categoryRepository.save(previousCategory);
        return category;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> getCategoriesOrderedByOrderNumber(){
        return this.categoryRepository.findAllByOrderByOrderNumberAsc();
    }
}