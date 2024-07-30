package com.github.rafinhalq.http_interface;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final Client1Service client1Service;
    private final Client2Service client2Service;

    public TestController(Client1Service client1Service, Client2Service client2Service) {
        this.client1Service = client1Service;
        this.client2Service = client2Service;
    }

    @PostMapping(path = "/test")
    public String testPost() {
        return client1Service.testPost() + " " + client2Service.testPost();
    }

    @GetMapping(path = "/test")
    public String testGet() {
        return client1Service.testGet() + " " + client2Service.testGet();
    }

    @PutMapping(path = "/test")
    public String testPut() {
        return client1Service.testPut() + " " + client2Service.testPut();
    }

    @PatchMapping(path = "/test")
    public String testPatch() {
        return client1Service.testPatch() + " " + client2Service.testPatch();
    }

    @DeleteMapping(path = "/test")
    public String testDelete() {
        return client1Service.testDelete() + " " + client2Service.testDelete();
    }
}
