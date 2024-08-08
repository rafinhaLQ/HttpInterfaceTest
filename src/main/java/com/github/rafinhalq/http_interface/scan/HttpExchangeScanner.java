package com.github.rafinhalq.http_interface.scan;

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
        Reflections projectReflected = new Reflections(new ConfigurationBuilder()
            .forPackage(basePackage)
            .addScanners(Scanners.TypesAnnotated));

        Set<Class<?>> annotatedClasses = projectReflected.getTypesAnnotatedWith(HttpExchange.class);
        List<Class<?>> httpExchangeInterfaces = new ArrayList<>();

        for (Class<?> clazz : annotatedClasses) {
            if (clazz.isInterface()) {
                httpExchangeInterfaces.add(clazz);
            }
        }

        return httpExchangeInterfaces;
    }
}
