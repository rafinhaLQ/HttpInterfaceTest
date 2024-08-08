package com.github.rafinhalq.http_interface.controller;

import com.github.rafinhalq.http_interface.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class Mock2Controller {
    @PostMapping(path = "/mock2")
    public ResponseEntity<Product> testPost() {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new Product("Product 2", "Description 2", new BigDecimal("100.00")));
    }

    @GetMapping(path = "/mock2")
    public ResponseEntity<Product> testGet() {
        return ResponseEntity.ok(new Product("Product 2", "Description 2", new BigDecimal("100.00")));
    }

    @PutMapping(path = "/mock2")
    public ResponseEntity<Product> testPut() {
        return ResponseEntity.ok(new Product("Product 2", "Description 2", new BigDecimal("100.00")));
    }

    @PatchMapping(path = "/mock2")
    public ResponseEntity<Product> testPatch() {
        return ResponseEntity.ok(new Product("Product 2", "Description 2", new BigDecimal("100.00")));
    }

    @DeleteMapping(path = "/mock2")
    public ResponseEntity<Product> testDelete() {
        return ResponseEntity.ok(new Product("Product 2", "Description 2", new BigDecimal("100.00")));
    }
}
