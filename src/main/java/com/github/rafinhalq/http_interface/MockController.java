package com.github.rafinhalq.http_interface;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {
    @PostMapping(path = "/mock")
    public String testPost() {
        return "Created!";
    }

    @GetMapping(path = "/mock")
    public String testGet() {
        return "Hello World!";
    }

    @PutMapping(path = "/mock")
    public String testPut() {
        return "Updated!";
    }

    @PatchMapping(path = "/mock")
    public String testPatch() {
        return "Patched!";
    }

    @DeleteMapping(path = "/mock")
    public String testDelete() {
        return "Deleted!";
    }
}
