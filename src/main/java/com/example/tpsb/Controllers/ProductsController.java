package com.example.tpsb.Controllers;

import com.example.tpsb.Models.Products;
import com.example.tpsb.Models.Provider;
import com.example.tpsb.Models.SubCategory;
import com.example.tpsb.Services.Impl.ProviderServiceImpl;
import com.example.tpsb.Services.ProductsService;
import com.example.tpsb.Services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;
    @Autowired
    private ProviderServiceImpl providerService;
    @Autowired
    private SubCategoryService subCategoryService;


    @GetMapping
    public String getAllProducts(Model model) {
        List<Products> products = productsService.getAllProducts();
        model.addAttribute("products", products);
        return "product/products";
    }


    @GetMapping("/{id}")
    public String getProductById(@PathVariable Long id, Model model) {
        Optional<Products> product = productsService.getProductById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "product/product";
        } else {
            model.addAttribute("message", "Product not found with ID: " + id);
            return "product/product-not-found";
        }
    }





    @GetMapping("/name/{name}")
    public String getProductByName(@PathVariable String name, Model model) {
        Optional<Products> product = productsService.getProductByName(name);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "product/product";
        } else {
            return "product/product-not-found";
        }
    }


    @GetMapping("/subcategory/{subcategoryId}")
    public String getProductsBySubcategoryId(@PathVariable int subcategoryId, Model model) {
        List<Products> products = productsService.getProductsBySubcategoryId(subcategoryId);
        model.addAttribute("products", products);
        return "product/subcategory-products";
    }

    @GetMapping("/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Products());
        model.addAttribute("providers", providerService.getAllProviders());
        model.addAttribute("subcategories", subCategoryService.getAllSubCategories());
        return "product/add-product";
    }

    @PostMapping("/add")
    public String createProduct(@ModelAttribute("product") Products product) {
        productsService.saveProduct(product);
        return "redirect:/products";
    }


    @PostMapping("/delete/{id}")
    public String deleteProductById(@PathVariable Long id) {
        productsService.deleteProductById(id);
        return "redirect:/products";
    }


    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable Long id, Model model) {
        Optional<Products> product = productsService.getProductById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());

            // Fetch providers and subcategories for the dropdowns
            List<Provider> providers = providerService.getAllProviders(); // Assume you have a ProviderService
            List<SubCategory> subcategories = subCategoryService.getAllSubCategories(); // Assume you have a SubcategoryService

            model.addAttribute("providers", providers);
            model.addAttribute("subcategories", subcategories);

            return "product/edit-product";
        } else {
            return "product/product-not-found"; // Custom error page
        }
    }

    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute("product") Products product) {
        product.setId(id);
        productsService.saveProduct(product);
        return "redirect:/products";
    }


}
