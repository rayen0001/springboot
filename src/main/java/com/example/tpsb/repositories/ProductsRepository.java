package com.example.tpsb.repositories;


import com.example.tpsb.Models.Products;
import com.example.tpsb.Models.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface      ProductsRepository extends JpaRepository<Products, Long> {
    Products getProductsByName(String name);
    List<Products> getProductsBySubcategoryId( int subcategory_id);
    void deleteProductByName(String name);
}
