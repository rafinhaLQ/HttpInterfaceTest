package com.github.rafinhalq.http_interface;

import com.github.rafinhalq.http_interface.beanregister.EnableHttpExchangeBeans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableHttpExchangeBeans
public class HttpInterfaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HttpInterfaceApplication.class, args);
	}

}
