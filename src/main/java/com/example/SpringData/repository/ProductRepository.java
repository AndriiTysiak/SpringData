package com.example.SpringData.repository;

import com.example.SpringData.entity.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {
    List<Product> findProductByTakeToYearLessThanEqual(int takeToYear);
    List<Product> findProductByPriceLessThan(double price);
    @Modifying
    @Query("UPDATE Product p SET p.name =:name, p.price =:price, p.description =:description, p.country =:country, p.yearOfManufacture =:yearOfManufacture, p.takeToYear =:takeToYear WHERE id =:id")
    void update(Long id,String name,Double price,String description,String country,int yearOfManufacture,int takeToYear);
    @Query( "SELECT p FROM Product p WHERE p.yearOfManufacture =:yearOfManufacture AND p.takeToYear =:takeToYear")
    List<Product> findProductExpirationDate(int yearOfManufacture,int takeToYear);
}
