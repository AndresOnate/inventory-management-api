package com.org.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.org.inventory.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    
}