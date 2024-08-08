package com.github.rafinhalq.http_interface.config;

import com.github.rafinhalq.http_interface.scan.HttpExchangeScanner;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpExchangeAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ClientConfig {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(ClientConfig.class);
    private static final String BASE_PACKAGE = "com.github.rafinhalq.http_interface";

    private final GenericApplicationContext context;

    public ClientConfig(GenericApplicationContext context) {
        this.context = context;
    }

    @PostConstruct
    public void registerClients() {
        var httpExchangeInterfaces = HttpExchangeScanner.findHttpExchangeInterfaces(BASE_PACKAGE);
        for (Class<?> httpExchangeInterface : httpExchangeInterfaces) {
            var beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(httpExchangeInterface);
            beanDefinition.setInstanceSupplier(() -> createClient(httpExchangeInterface));

            var beanName = standardizeBeanName(httpExchangeInterface.getSimpleName());

            context.registerBeanDefinition(beanName, beanDefinition);
            log.debug("Registered bean: {}", beanName);
        }
    }

    private <T> T createClient(Class<T> clientClass) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
            .builder()
            .exchangeAdapter(client())
            .build();

        return factory.createClient(clientClass);
    }

    private HttpExchangeAdapter client() {
        var client = WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector())
            .build();

        return WebClientAdapter.create(client);
    }

    private String standardizeBeanName(String beanName) {
        return beanName.substring(0, 1).toLowerCase() + beanName.substring(1);
    }
}
