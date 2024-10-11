package com.example.tpsb.repositories;

import com.example.tpsb.Models.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    SubCategory getSubCategoryByTitle(String tiltle);
    void deleteSubCategoryByTitle(String tiltle);
}
