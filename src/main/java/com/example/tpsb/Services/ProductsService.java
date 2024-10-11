package com.example.tpsb.Services;

import com.example.tpsb.Models.Products;

import java.util.List;
import java.util.Optional;

public interface ProductsService {

    List<Products> getAllProducts();

    Optional<Products> getProductById(Long id);

    Optional<Products> getProductByName(String name);

    List<Products> getProductsBySubcategoryId(int subcategoryId);

    Products saveProduct(Products product);

    void deleteProductById(Long id);

    void deleteProductByName(String name);
}
