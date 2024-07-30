package com.github.rafinhalq.http_interface.annotation;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HttpExchangeScanner {

    private HttpExchangeScanner() {
    }

    public static List<Class<?>> findHttpExchangeInterfaces(String basePackage) {
        Reflections reflections = new Reflections(new ConfigurationBuilder()
            .forPackage(basePackage)
            .addScanners(Scanners.TypesAnnotated));

        Set<Class<?>> annotatedClasses = reflections.getTypesAnnotatedWith(HttpExchange.class);
        List<Class<?>> httpExchangeInterfaces = new ArrayList<>();

        for (Class<?> clazz : annotatedClasses) {
            if (clazz.isInterface()) {
                httpExchangeInterfaces.add(clazz);
            }
        }

        return httpExchangeInterfaces;
    }
}
