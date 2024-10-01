package com.example.tpsb.Models;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults (level = AccessLevel.PRIVATE)

public class Customer  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String address;
    String city;
}
