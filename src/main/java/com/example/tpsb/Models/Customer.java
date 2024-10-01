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

public class Customer extends User {

    String address;
    String city;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "customer" , cascade = CascadeType.ALL)
    List<Orders> orders = new ArrayList<>();
}
