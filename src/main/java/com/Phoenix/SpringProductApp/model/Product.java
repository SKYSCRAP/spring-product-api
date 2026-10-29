package com.Phoenix.SpringProductApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //for unique IDs
    private Long id;

    @Column(unique = true) // Unique product names in a particular column
    @NotBlank(message = "Product Name is required")
    private String name;

    private String description;

    private BigDecimal price;

    private int quantity;


}
