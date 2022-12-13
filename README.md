# spring-boot-examples-feign-client
Spring Boot Examples on Feign Clients

A multi-module Maven project with two Spring Boot apps:

1. A very simple Rest app.
2. A MQ app, that
   3. listens for messages
   4. And tries to forward them to the Rest app.
   5. It will retry to do so in case the Rest app is not reachable.
