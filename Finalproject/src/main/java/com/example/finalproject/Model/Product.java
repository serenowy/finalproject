package com.example.finalproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id//P key
    private Integer code;
    @NotEmpty(message= " name can not empty")
    @Size(min = 5, message="Length more than 5")

    private String name;
    private Integer number;
    @NotNull(message= " price can not null")
    private double price;
    @NotNull(message= " age can not null")
    private Integer age;
}
