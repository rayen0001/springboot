package com.example.tpsb.Models;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

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
}
