# Web-application - Food delivery "Hungry Wolf"

## Table of contents
* [Summary](#summary)
* [Tech Stack](#tech-stack)
* [Environment](#environment)
* [Launch](#launch)
* [Application interaction](#application-interaction)
* [Contacts](#contacts)

## Summary
Delivery food project. The customer places an order through 
the website or mobile application. The courier receives the order and fulfills it. 
The cafe administrator monitors the supply of products and profits, interacts with 
the kitchen, couriers and customers.

## Tech Stack:
- Java 17;
- PostgreSQL 15;
- Spring Boot 2;
- Hibernate 5;
- Lombok 1;
- Liquibase 4;

## Environment
JDK 17, IntelliJ IDEA CE 2021.3.3, Maven 3.8.1, PostrgreSQL 15

## Launch
1. Create database: dish.
2. Run the application from the Main class.
3. Start Postman and run requests.

## Application interaction
1. The customer registers an order.
2. The kitchen receives the order and fulfills it. Updates order readiness statuses and product statuses.
3. The courier receives the order, fulfills it, updates its location.
4. The administrator checks the status of the work of clients, kitchen, couriers, food deliveries, profits.
5. How to run application via Docker Compose: docker-compose run job4j_dish

## Contacts
telegram: @knownasmars