package com.example.tpsb.Services;

import com.example.tpsb.Models.SubCategory;

import java.util.List;
import java.util.Optional;

public interface SubCategoryService {

    List<SubCategory> getAllSubCategories();

    Optional<SubCategory> getSubCategoryById(Long id);

    Optional<SubCategory> getSubCategoryByTitle(String title);

    SubCategory saveSubCategory(SubCategory subCategory);

    void deleteSubCategoryById(Long id);

    void deleteSubCategoryByTitle(String title);
}
