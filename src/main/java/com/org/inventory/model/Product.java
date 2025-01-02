package com.org.inventory.model;

import jakarta.persistence.*;
import lombok.*;


/**
 * Entity class representing a product in the inventory.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
}