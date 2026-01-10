package com.krakedev.inventario.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.inventario.entity.Product;
import com.krakedev.inventario.entity.StatusProduct;
import com.krakedev.inventario.repository.ProductRepository;
import com.krakedev.inventario.service.ProductService;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product registerProduct(Product product) {
        //Product newProduct = productRepository.save(product);
        //return newProduct;
        return productRepository.save(product);
    }

    @Override
    public List<Product> listProducts() {
        //List<Product> products = productRepository.findAll();
        //return products;
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProductById(Long idProduct) {
        //Optional<Product> product = productRepository.findbyId(idProduct);
        //return product;
        return productRepository.findById(idProduct);
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        //Optional<Product> product = productRepository.findByName(name);
        //return product;
        return productRepository.findByName(name);
    }

    @Override
    @SneakyThrows
    public Product updateProduct(Long idProduct, Product product) {
        Product productUpdated = productRepository.findById(idProduct)
                .orElseThrow(()-> new Exception("Product Id" + idProduct + " not found"));
        productUpdated.setName(product.getName());
        productUpdated.setDescription(product.getDescription());
        productUpdated.setQuantity(product.getQuantity());
        productUpdated.setPrice(product.getPrice());
        productUpdated.setStatusProduct(product.getStatusProduct());

        Product productUpdatedSaved = productRepository.save(productUpdated);
        return productUpdatedSaved;
    }

    @Override
    @SneakyThrows
    public void deleteProduct(Long idProduct) {
        productRepository.findById(idProduct)
                .orElseThrow(()-> new Exception("Product Id" + idProduct + " not found"));
        productRepository.deleteById(idProduct);
    }

    @Override
    @SneakyThrows
    public Product changeProductStatus(Long idProduct, StatusProduct newStatusProduct) {
       Product productUpdated = productRepository.findById(idProduct)
                .orElseThrow(()-> new Exception("Product Id" + idProduct + " not found")); 
       productUpdated.setStatusProduct(newStatusProduct);
       return productRepository.save(productUpdated);
    }

    @Override
    public List<Product> listProductsByStatus(StatusProduct statusProduct) {
        return productRepository.findByStatusProduct(statusProduct);
    }

}
