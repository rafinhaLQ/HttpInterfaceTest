package com.github.rafinhalq.http_interface.beanregister;

import com.github.rafinhalq.http_interface.scan.HttpExchangeScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpExchangeAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

public class HttpExchangeBeansRegister implements ImportBeanDefinitionRegistrar {

    private static final Logger log = LoggerFactory.getLogger(HttpExchangeBeansRegister.class);

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        var attributes = importingClassMetadata.getAnnotationAttributes(EnableHttpExchangeBeans.class.getName());
        if (attributes != null) {
            var basePackage = importingClassMetadata.getClassName();
            basePackage = basePackage.substring(0, basePackage.lastIndexOf('.'));
            registerHttpExchangeInterfaces(basePackage, registry);
        }
    }

    private void registerHttpExchangeInterfaces(String basePackage, BeanDefinitionRegistry registry) {
        var httpInterfaces = HttpExchangeScanner.findHttpExchangeInterfaces(basePackage);
        for (Class<?> httpInterfaceClass : httpInterfaces) {

            var beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(httpInterfaceClass);
            beanDefinition.setInstanceSupplier(() -> createClient(httpInterfaceClass));

            var beanName = standardizeBeanName(httpInterfaceClass.getSimpleName());

            registry.registerBeanDefinition(beanName, beanDefinition);

            log.debug("Registered bean: {}", beanName);
        }
    }

    private <T> T createClient(Class<T> clientClass) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
            .builder()
            .exchangeAdapter(createAdapter())
            .build();

        return factory.createClient(clientClass);
    }

    private HttpExchangeAdapter createAdapter() {
        var client = WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector())
            .build();

        return WebClientAdapter.create(client);
    }

    private static String standardizeBeanName(String name) {
        return name.substring(0, 1).toLowerCase() + name.substring(1);
    }
}
