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
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String description;
    float price;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    SubCategory subcategory;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Provider provider;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Order_detail", joinColumns = @JoinColumn(name = "Products_id"), inverseJoinColumns = @JoinColumn(name = "Orders_id"))
    List<Orders> orders = new ArrayList<>();
}
