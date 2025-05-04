package com.codeid.eshopper.service;

import java.util.List;
import java.util.Optional;

import com.codeid.eshopper.entities.Category;
import com.codeid.eshopper.entities.Region;

public interface CategoryService  {
    
    //'select * from hr.regions'
    List<Category> findAllCategory();

    Category addCategory(Category category);

    Optional<Category> findCategoryById(Long categoryId);

    void deleteCategoryById(Long categoryId);
    
}
