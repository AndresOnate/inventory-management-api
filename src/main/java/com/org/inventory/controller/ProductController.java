package com.org.inventory.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.org.inventory.model.Product;
import com.org.inventory.service.ProductService;

/**
 * REST controller for managing product-related operations.
 * This controller handles HTTP requests for creating, reading, updating, and deleting product records.
 * It communicates with the `ProductService` to perform business logic and data handling for products.
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    /**
     * Handles HTTP GET requests to fetch all products.
     * This method retrieves a list of all products from the service and returns it as a response.
     * @return A list of all products.
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * Handles HTTP GET requests to fetch a specific product by its ID.
     * This method retrieves a single product based on the provided `id` and returns it.
     * @param id The ID of the product to be retrieved.
     * @return The product with the specified ID.
     */
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    /**
     * Handles HTTP POST requests to create a new product.
     * This method accepts a `Product` object in the request body, processes it, and returns the created product.
     * @param product The product data to be created.
     * @return The created product.
     */
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    /**
     * Handles HTTP PUT requests to update an existing product by its ID. 
     * This method accepts a `Product` object in the request body and updates the corresponding product 
     * with the provided ID, returning the updated product.
     * @param id The ID of the product to be updated.
     * @param product The updated product data.
     * @return The updated product.
     */
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    /**
     * Handles HTTP DELETE requests to delete a product by its ID.
     * This method deletes the product with the specified ID from the system.
     * @param id The ID of the product to be deleted.
     */
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}