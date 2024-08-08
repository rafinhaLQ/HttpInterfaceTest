package com.github.rafinhalq.http_interface.controller;

import com.github.rafinhalq.http_interface.model.Product;
import com.github.rafinhalq.http_interface.service.ClientService1;
import com.github.rafinhalq.http_interface.service.ClientService2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    private final ClientService1 clientService1;
    private final ClientService2 clientService2;

    public TestController(ClientService1 clientService1, ClientService2 clientService2) {
        this.clientService1 = clientService1;
        this.clientService2 = clientService2;
    }

    @PostMapping(path = "/test")
    public ResponseEntity<List<Product>> testPost() {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(List.of(clientService1.testPost(), clientService2.testPost()));
    }

    @GetMapping(path = "/test")
    public ResponseEntity<List<Product>> testGet() {
        return ResponseEntity.ok(List.of(clientService1.testGet(), clientService2.testGet()));
    }

    @PutMapping(path = "/test")
    public ResponseEntity<List<Product>> testPut() {
        return ResponseEntity.ok(List.of(clientService1.testPut(), clientService2.testPut()));
    }

    @PatchMapping(path = "/test")
    public ResponseEntity<List<Product>> testPatch() {
        return ResponseEntity.ok(List.of(clientService1.testPatch(), clientService2.testPatch()));
    }

    @DeleteMapping(path = "/test")
    public ResponseEntity<List<Product>> testDelete() {
        return ResponseEntity.ok(List.of(clientService1.testDelete(), clientService2.testDelete()));
    }
}
