package com.krakedev.inventario.service;

import java.util.List;
import java.util.Optional;

import com.krakedev.inventario.entity.Product;
import com.krakedev.inventario.entity.StatusProduct;

public interface ProductService {

    Product registerProduct(Product product);
    List<Product> listProducts();
    Optional<Product> findProductById(Long idProduct);
    Optional<Product> findProductByName(String name);
    Product updateProduct(Long idProduct, Product product); 
    void deleteProduct(Long idProduct);

    Product changeProductStatus(Long idProduct, StatusProduct newStatusProduct);
    List<Product> listProductsByStatus(StatusProduct statusProduct);
}
