package com.org.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.inventory.model.Product;
import com.org.inventory.repository.ProductRepository;

/**
 * Service class that provides business logic for managing product entities.
 */
@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    /**
     * Retrieves a list of all products.
     * @return a List of all {@link Product} entities.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Retrieves a product by its ID.
     * @param id the ID of the product to retrieve.
     * @return the Product entity if found.
     * @throws RuntimeException if the product with the specified ID is not found.
     */
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    /**
     * Creates a new product.
     * @param product the Product entity to be created.
     * @return the created Product entity.
     */
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Updates an existing product with new details.
     * 
     * @param id the ID of the product to update.
     * @param updatedProduct the Product entity containing the updated information.
     * @return the updated Product entity.
     * @throws RuntimeException if the product with the specified ID is not found.
     */
    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = getProductById(id);
        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setQuantity(updatedProduct.getQuantity());
        return productRepository.save(product);
    }

    /**
     * Deletes a product by its ID.
     * @param id the ID of the product to delete.
     */
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}