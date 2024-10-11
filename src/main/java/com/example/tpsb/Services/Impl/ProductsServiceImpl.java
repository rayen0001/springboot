package com.example.tpsb.Services.Impl;

import com.example.tpsb.Models.Products;
import com.example.tpsb.Services.ProductsService;
import com.example.tpsb.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsRepository productsRepository;


    @Override
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }


    @Override
    public Optional<Products> getProductById(Long id) {
        return productsRepository.findById(id);
    }


    @Override
    public Optional<Products> getProductByName(String name) {
        return Optional.ofNullable(productsRepository.getProductsByName(name));
    }


    @Override
    public List<Products> getProductsBySubcategoryId(int subcategoryId) {
        return productsRepository.getProductsBySubcategoryId(subcategoryId);
    }


    @Override
    public Products saveProduct(Products product) {
        return productsRepository.save(product);
    }


    @Override
    public void deleteProductById(Long id) {
        productsRepository.deleteById(id);
    }


    @Override
    public void deleteProductByName(String name) {
        productsRepository.deleteProductByName(name);
    }
}
