package com.github.rafinhalq.http_interface.service;

import com.github.rafinhalq.http_interface.model.Product;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PatchExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

@HttpExchange(value = "http://localhost:8080/mock2")
public interface ClientService2 {
    @PostExchange
    Product testPost();

    @GetExchange
    Product testGet();

    @PutExchange
    Product testPut();

    @PatchExchange
    Product testPatch();

    @DeleteExchange
    Product testDelete();
}
