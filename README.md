# Hotel Microservices Application

This is a microservices application for a hotel system, developed using Spring Boot. It consists of various services such as the rating service, user service, and hotel service. The application also incorporates security, an API gateway, a service registry using Eureka, and communication between services using Feign client.

## Tools & Technologies used:

- Spring Boot
- Spring JPA
- Spring Security
- MySQL
- Spring Cloud
- Postman

## Features

- Rating Service: Allows users to rate hotels and retrieve average ratings for hotels.
- User Service: Handles user management, including user registration and authentication.
- Hotel Service: Manages hotel information, including creating, updating, and retrieving hotel details.

## Security

The application implements security measures to protect user data and restrict unauthorized access. The following security features have been implemented:

- Authentication: Users are required to authenticate themselves before accessing any functionality.
- Authorization: Different user roles have different levels of access to the application's features.
- Password Encryption: User passwords are securely encrypted using password encoders to protect sensitive information.

## API Gateway

An API gateway is used to provide a single entry point for the microservices and handle requests from clients. The API gateway offers the following benefits:

- Centralized Authentication and Authorization: The API gateway handles authentication and authorization for all incoming requests.
- Request Routing: The gateway routes incoming requests to the appropriate microservice based on the requested API endpoint.
- Load Balancing: Incoming requests can be load-balanced across multiple microservice instances.
- Caching: The gateway can cache responses to improve performance.

## Service Registry (Eureka)

A service registry using Eureka is implemented to enable service discovery and registration. The service registry provides the following capabilities:

- Service Discovery: Microservices can discover and locate other services dynamically using the registry.
- Service Registration: Each microservice registers itself with the service registry upon startup.

## Communication using Feign Client

Communication between microservices is achieved using the Feign client, which simplifies the process of making inter-service calls. Benefits of using Feign clients include:

- Declarative REST Clients: Feign allows you to define REST clients using annotations, simplifying the implementation of communication between services.
- Load Balancing: Feign integrates with service registries to provide load-balanced client-side load balancing across multiple instances of a service.


## Acknowledgements

This application is built using the following technologies and framework:

- Spring Boot
- Spring Security
- Spring Cloud Netflix (Eureka)
- Spring Cloud Gateway
- Spring Data JPA
- MySQL Database
- Feign Client


