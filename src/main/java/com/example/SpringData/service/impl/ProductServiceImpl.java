package com.example.SpringData.service.impl;

import com.example.SpringData.entity.Product;
import com.example.SpringData.repository.ProductRepository;
import com.example.SpringData.service.ProductService;
import com.example.SpringData.service.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private  final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> info(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        if (!productRepository.existsById(id)){
            throw new ProductNotFoundException("User with id " + id + "not found");
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findProductByTakeToYear(int year) {
        return productRepository.findProductByTakeToYearLessThanEqual(year);
    }

    @Override
    public List<Product> findProductByPrice(double price) {
        return productRepository.findProductByPriceLessThan(price);
    }


    @Override
    public List<Product> allProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public void update(Long id, Product product) {
        productRepository.update(id,product.getName(),product.getPrice(),product.getDescription(),product.getCountry(),product.getYearOfManufacture(),product.getTakeToYear());
    }

    @Override
    public List<Product> getExpirationDate(int yearOfManufacture, int takeToYear) {
        return productRepository.findProductExpirationDate(yearOfManufacture,takeToYear);
    }
}
