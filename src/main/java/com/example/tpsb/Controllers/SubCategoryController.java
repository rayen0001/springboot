package com.example.tpsb.Controllers;

import com.example.tpsb.Models.SubCategory;
import com.example.tpsb.Services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "/api")
@RestController
@RequestMapping("/subcategories")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping
    public ResponseEntity<List<SubCategory>> getAllSubCategories() {
        List<SubCategory> subCategories = subCategoryService.getAllSubCategories();
        return ResponseEntity.ok(subCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCategory> getSubCategoryById(@PathVariable Long id) {
        Optional<SubCategory> subCategory = subCategoryService.getSubCategoryById(id);
        return subCategory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<SubCategory> getSubCategoryByTitle(@PathVariable String title) {
        Optional<SubCategory> subCategory = subCategoryService.getSubCategoryByTitle(title);
        return subCategory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<SubCategory> createSubCategory(@RequestBody SubCategory subCategory) {
        SubCategory newSubCategory = subCategoryService.saveSubCategory(subCategory);
        return ResponseEntity.ok(newSubCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubCategoryById(@PathVariable Long id) {
        subCategoryService.deleteSubCategoryById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/title/{title}")
    public ResponseEntity<Void> deleteSubCategoryByTitle(@PathVariable String title) {
        subCategoryService.deleteSubCategoryByTitle(title);
        return ResponseEntity.noContent().build();
    }
}
