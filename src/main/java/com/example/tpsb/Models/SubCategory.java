package com.example.tpsb.Models;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE)

public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String title;
    String description;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    Category category;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subcategory", cascade = CascadeType.ALL)
    List<Products> Products = new ArrayList<>();
}
