package com.krakedev.inventario.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krakedev.inventario.entity.Product;
import com.krakedev.inventario.entity.StatusProduct;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long idProduct);
    Optional<Product> findByName(String name);
    List<Product> findByStatusProduct(StatusProduct statusProduct);
}
