package com.github.rafinhalq.http_interface;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mock1Controller {
    @PostMapping(path = "/mock1")
    public String testPost() {
        return "Mock 1 - Created!";
    }

    @GetMapping(path = "/mock1")
    public String testGet() {
        return "Mock 1 - Hello World!";
    }

    @PutMapping(path = "/mock1")
    public String testPut() {
        return "Mock 1 - Updated!";
    }

    @PatchMapping(path = "/mock1")
    public String testPatch() {
        return "Mock 1 - Patched!";
    }

    @DeleteMapping(path = "/mock1")
    public String testDelete() {
        return "Mock 1 - Deleted!";
    }
}
