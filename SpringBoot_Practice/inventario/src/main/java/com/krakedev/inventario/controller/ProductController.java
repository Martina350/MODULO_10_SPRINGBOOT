package com.krakedev.inventario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.inventario.entity.Product;
import com.krakedev.inventario.entity.StatusProduct;
import com.krakedev.inventario.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/register")
    public ResponseEntity<?> registerProduct(@RequestBody Product product) {
        Product newProduct = productService.registerProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> listProduct() {
        List<Product> products = productService.listProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/search/name/{name}")
    public ResponseEntity<?> searchByName(@PathVariable String name) {
        Optional<Product> product = productService.findProductByName(name);
        return product.isPresent() ? ResponseEntity.ok(product.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Product with name " + name + " not found");
    }

    @GetMapping("/search/id/{id}")
    public ResponseEntity<?> searchById(@PathVariable Long id) {
        Optional<Product> product = productService.findProductById(id);
        return product.isPresent() ? ResponseEntity.ok(product.get())
                : ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Product with id " + id + " not found");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        try {
            Product productUpdated = new Product();
            productUpdated.setName(product.getName());
            productUpdated.setDescription(product.getDescription());
            productUpdated.setQuantity(product.getQuantity());
            productUpdated.setPrice(product.getPrice());
            productUpdated.setStatusProduct(product.getStatusProduct());

            Product productBDD = productService.updateProduct(id, productUpdated);
            return ResponseEntity.ok(productBDD);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.ok("Product with id " + id + " deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<?> changeProductStatus(@PathVariable Long id, @RequestBody StatusProduct statusProduct) {
       try{
            Product productUpdate = productService.changeProductStatus(id, statusProduct);
            return ResponseEntity.ok(productUpdate);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("listStatus/{statusProduct}")
    public ResponseEntity<?> listProductsByStatus(@PathVariable StatusProduct statusProduct) {
        List<Product> products = productService.listProductsByStatus(statusProduct);
        return ResponseEntity.ok(products);
    }
}
