package com.project.api.repository;


import com.project.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query(value = "SELECT * FROM product p WHERE p.description like ?1%", nativeQuery = true)
    List<Product> findByPartialDesc(String partialName);

    @Query(value = "SELECT * FROM product p WHERE p.price < ?1", nativeQuery = true)
    List<Product> findUnderPrice(double price);

    @Query(value = "SELECT * FROM product p WHERE p.brand like %?1% AND p.price < ?2", nativeQuery = true)
    List<Product> findByBrandAndPrice(String brand, double price);

    List<Product> findByBrand(String email);
}
