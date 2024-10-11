package com.example.tpsb.RestControllers;

import com.example.tpsb.Models.Products;
import com.example.tpsb.Services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "/api")
@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping
    public ResponseEntity<List<Products>> getAllProducts() {
        List<Products> products = productsService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Long id) {
        Optional<Products> product = productsService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Products> getProductByName(@PathVariable String name) {
        Optional<Products> product = productsService.getProductByName(name);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/subcategory/{subcategoryId}")
    public ResponseEntity<List<Products>> getProductsBySubcategoryId(@PathVariable int subcategoryId) {
        List<Products> products = productsService.getProductsBySubcategoryId(subcategoryId);
        return ResponseEntity.ok(products);
    }

    @PostMapping("/add")
    public ResponseEntity<Products> createProduct(@RequestBody Products product) {
        Products newProduct = productsService.saveProduct(product);
        return ResponseEntity.ok(newProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        productsService.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/name/{name}")
    public ResponseEntity<Void> deleteProductByName(@PathVariable String name) {
        productsService.deleteProductByName(name);
        return ResponseEntity.noContent().build();
    }
}
