package com.example.multi_mongodb_project.model2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "model_2")
public class Model2 {

    @Id
    private String id;
    private String name;
    private int age;
    private Double salary;
}

