package com.project.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Integer> {

    @Query(value = "SELECT * FROM produto p WHERE p.description like ?1%", nativeQuery = true)
    List<Produto> findByPartialDesc(String partialName);

    @Query(value = "SELECT * FROM produto p WHERE p.price < ?1", nativeQuery = true)
    List<Produto> findUnderPrice(double preco);

    @Query(value = "SELECT * FROM produto p WHERE p.brand like %?1% AND p.price < ?2", nativeQuery = true)
    List<Produto> findByBrandAndPrice(String brand, double price);

    List<Produto> findByBrand(String email);
}
