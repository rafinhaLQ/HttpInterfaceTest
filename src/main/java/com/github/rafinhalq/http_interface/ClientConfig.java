package com.github.rafinhalq.http_interface;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpExchangeAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;

@Configuration
public class ClientConfig {
    @Bean
    public ClientService clientService() throws SSLException {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
            .builder()
            .exchangeAdapter(client())
            .build();

        return factory.createClient(ClientService.class);
    }

    private HttpExchangeAdapter client() throws SSLException {
        SslContext ssl = SslContextBuilder.forClient()
            .trustManager(InsecureTrustManagerFactory.INSTANCE)
            .build();

        var httpClient = HttpClient.create().secure(t -> t.sslContext(ssl));

        var client = WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector(httpClient))
            .build();

        return WebClientAdapter.create(client);
    }
}
