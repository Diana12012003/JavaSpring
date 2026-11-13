package org.example.Homework11.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cars")

public class Car {
    @Id
    private String id;
    private String model;
    private String producer;
    private int power;
    private String photoPath;
}


