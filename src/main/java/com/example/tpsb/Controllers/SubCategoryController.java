package com.example.tpsb.Controllers;

import com.example.tpsb.Models.Category;
import com.example.tpsb.Models.SubCategory;
import com.example.tpsb.Services.CategoryService;
import com.example.tpsb.Services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/subcategories")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listSubCategories(Model model) {
        List<SubCategory> subCategories = subCategoryService.getAllSubCategories();
        model.addAttribute("subCategories", subCategories);
        return "subcategories/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("subCategory", new SubCategory());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "subcategories/create";
    }

    @PostMapping
    public String createSubCategory(@ModelAttribute("subCategory") SubCategory subCategory) {
        subCategoryService.saveSubCategory(subCategory);
        return "redirect:/subcategories";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<SubCategory> subCategory = subCategoryService.getSubCategoryById(id);
        if (subCategory.isPresent()) {
            model.addAttribute("subCategory", subCategory.get());
            model.addAttribute("categories", categoryService.getAllCategories());
            return "subcategories/edit";
        } else {
            return "redirect:/error";
        }
    }

    @PostMapping("/update/{id}")
    public String updateSubCategory(@PathVariable Long id, @ModelAttribute("subCategory") SubCategory subCategory) {
        subCategory.setId(id);
        subCategoryService.saveSubCategory(subCategory);
        return "redirect:/subcategories";
    }
}
