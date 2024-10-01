package com.example.tpsb.Models;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE)

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String ref;
    float price;
    Date date;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    Customer customer;
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "orders" ,cascade = CascadeType.ALL)
    List<Products> products = new ArrayList<>();
}
