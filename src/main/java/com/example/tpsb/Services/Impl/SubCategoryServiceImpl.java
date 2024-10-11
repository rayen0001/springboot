package com.example.tpsb.Services.Impl;

import com.example.tpsb.Models.SubCategory;
import com.example.tpsb.Services.SubCategoryService;
import com.example.tpsb.repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    @Override
    public Optional<SubCategory> getSubCategoryById(Long id) {
        return subCategoryRepository.findById(id);
    }

    @Override
    public Optional<SubCategory> getSubCategoryByTitle(String title) {
        return Optional.ofNullable(subCategoryRepository.getSubCategoryByTitle(title));
    }

    @Override
    public SubCategory saveSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    @Override
    public void deleteSubCategoryById(Long id) {
        subCategoryRepository.deleteById(id);
    }

    @Override
    public void deleteSubCategoryByTitle(String title) {
        subCategoryRepository.deleteSubCategoryByTitle(title);
    }
}
