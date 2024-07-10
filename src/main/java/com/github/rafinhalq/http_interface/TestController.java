package com.github.rafinhalq.http_interface;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final ClientService clientService;

    public TestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(path = "/test")
    public String testPost() {
        return clientService.testPost();
    }

    @GetMapping(path = "/test")
    public String testGet() {
        return clientService.testGet();
    }

    @PutMapping(path = "/test")
    public String testPut() {
        return clientService.testPut();
    }

    @PatchMapping(path = "/test")
    public String testPatch() {
        return clientService.testPatch();
    }

    @DeleteMapping(path = "/test")
    public String testDelete() {
        return clientService.testDelete();
    }
}
