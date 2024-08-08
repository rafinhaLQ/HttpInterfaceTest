# HttpInterfaceTest

This project demonstrates how to automate Bean generation for Spring HTTP Client Interfaces using Spring Boot.

## Description

The project automates the registration of HTTP client interfaces annotated with `@HttpExchangeClient`. It uses a custom scan and register these interfaces as Spring beans.

You can read more about it on the medium article: [Dynamic Bean Generation for Spring HTTP Client Interfaces](https://medium.com/@rafinhalq/automating-bean-generation-for-spring-http-client-interfaces-e7576b924482).

## Test it out
You can run the program and test the calls with the `http-request.http` file.

> Note: Use only one of the methods to register the beans, otherwise it will try to override the beans and it will crash.
