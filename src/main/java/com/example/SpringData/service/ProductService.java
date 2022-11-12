package com.example.SpringData.service;

import com.example.SpringData.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Product add(Product product);
    Optional<Product> info(Long id);
    void delete(Long id);

    List<Product> findProductByTakeToYear(int year);
    List<Product> findProductByPrice(double price);
    List<Product> allProducts();
    void update(Long id,Product product);
    List<Product> getExpirationDate(int yearOfManufacture, int takeToYear);


}
