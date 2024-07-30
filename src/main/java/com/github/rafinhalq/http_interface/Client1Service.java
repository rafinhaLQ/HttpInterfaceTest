package com.github.rafinhalq.http_interface;

import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PatchExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

@HttpExchange(value = "http://localhost:8080/mock1")
public interface Client1Service {
    @PostExchange
    String testPost();

    @GetExchange
    String testGet();

    @PutExchange
    String testPut();

    @PatchExchange
    String testPatch();

    @DeleteExchange
    String testDelete();
}
