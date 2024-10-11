package com.example.tpsb.Services;

import com.example.tpsb.Models.Category;

import java.util.List;

public interface CategoryService {

    Category findCategoryByTitle(String title);

    Category saveCategory(Category category);

    List<Category> getAllCategories();

    void deleteCategoryByTitle(String title);

    Category findCategoryById(Long id);

    void deleteCategoryById(Long id);
}
