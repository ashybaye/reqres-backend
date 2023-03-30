## Back-end application using ReqRes API

This project was bootstrapped with [Spring Boot](https://start.spring.io/).

This app will communicate with the [Reqres API](https://reqres.in/) and create a webclient microserice API for basic CRUD operations. 

### To run locally:
- Run: `mvn spring-boot:run`
- The service will run on http://localhost:8080
- Use Postman to test the api responses, ex: `GET localhost:8080/resources`

This serivce can be used with the front-end application that runs on http://localhost:8081

### This service provides:
- Endpoints for Users:
  - retrieve the list of all users: `GET localhost:8080/users`
  - retrieve the details by user id: `GET localhost:8080/users/1`
  - delete a user: `DELETE localhost:8080/users/1`
  - update a user `PUT localhost:8080/users/1`
- Endpoints for Resources:
  - retrieve the list of all resources: `GET localhost:8080/resources`
  - retrieve the details by resource id: `GET localhost:8080/resources/1`
  - delete a resource: `DELETE localhost:8080/resources/1`
  - update a resource `PUT localhost:8080/resources/1`  

### To do:
- actually learn how to do java projects properly
- security and authentication
- test coverage