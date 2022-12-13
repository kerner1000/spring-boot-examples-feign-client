# spring-boot-examples-feign-client
Spring Boot Examples on Feign Clients

A multi-module Maven project with two Spring Boot apps:

1. A very simple Rest app.
2. A MQ app, that
    1. listens for messages
    2. And tries to forward them to the Rest app.
    3. It will retry to do so in case the Rest app is not reachable.
