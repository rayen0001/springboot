package com.example.tpsb.repositories;

import com.example.tpsb.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<Category, Long> {
    Category getCategoryByTitle(String tiltle);
    void deleteCategoryByTitle(String tiltle);
}
