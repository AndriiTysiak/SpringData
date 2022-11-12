package com.example.SpringData.web;

import com.example.SpringData.entity.Product;
import com.example.SpringData.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/products/")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(value = "/product")
    @ResponseStatus(HttpStatus.CREATED)
    public Product add(@RequestBody Product product) {
        return productService.add(product);
    }
    @DeleteMapping(value = "product")
    public void delete(@RequestParam Long id){
        productService.delete(id);
    }
    @GetMapping(value = "/product/not")
    public List<Product> getByTakeToYear(@RequestParam int year){
        return productService.findProductByTakeToYear(year);
    }
    @GetMapping(value = "/product")
    public List<Product> getByPrice(@RequestParam double price){
        return productService.findProductByPrice(price);
    }
    @GetMapping(value = "/product/all")
    public List<Product> getAllProduct(){
        return productService.allProducts();
    }
    @GetMapping(value = "/product/info")
    public Optional<Product> getProduct(@RequestParam Long id){
        return productService.info(id);
    }
    @Transactional
    @PostMapping(value = "/product/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@PathVariable Long id,@RequestBody Product product) {
         productService.update(id, product);
    }
    @GetMapping(value = "/product/expirationDate/{yearOfManufacture}/{takeToYear}")
    public List<Product> getProductExpirationDate(@PathVariable int yearOfManufacture,@PathVariable int takeToYear){
        return productService.getExpirationDate(yearOfManufacture,takeToYear);
    }
}
