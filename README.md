# i-code-java-conf-2016

This project has 4 modules:

1. Standard: in this module, we showcase the standard usage of Spring Data JPA. All the good stuff that it brings forward for the Spring users.
   The project itself is built with Spring boot.
   There is data.sql under resources with preload some information into H2, the in-memory database used for this project.
   Per default, it runs on port 8080. Below are the different endpoints:
   * localhost:8080/customers
   * localhost:8080/customers/by?firstName=Steven&lastName=Ndaye
   * localhost:8080/customers/status?lastName=Ndaye&statuses=GOOD_STANDING,DEBT

2. Specification: in this module we showcase how Specification API enhances Spring Data JPA by giving us a better way to query data.
   The project uses employees database loaded within mysql database.
   Where do I get it from?
   Go to this github repo: https://github.com/datacharmer/test_db
   It has all the instructions on how to install this large dataset.
   Per default, it runs on port 8082. Below are the different endpoints:
   * localhost:8082/employees/by?bornFrom=1957-01-01&bornTo=1960-01-01&hiredFrom=1980-01-01&hiredTo=1990-01-01
   * localhost:8082/employees (NB. Use this with caution, it will load the entire employees data set)
   * localhost:8082/employees/female?bornBefore=1962-01-01
   * localhost:8082/employees/male?hiredAfter=1990-01-01
   * localhost:8082/employees/employee?firstName=Gino&lastName=Usery&bornBefore=1960-01-01&hiredAfter=1990-01-01

3. Query dsl: in this module we showcase how QueryDSL framework enables the construction of statically typed SQL-like queries via its fluent API.
   This project uses Sakila database. It comes loaded within mysql if you had installed it with its sample database.
   In case you do not have it, check this github repo: https://github.com/datacharmer/test_db/tree/master/sakila
   Per default, it runs on port 8081. Below are the different endpoints:
   * localhost:8081/customers/stores?id=1
   * localhost:8081/customers/by?status=ACTIVE
   * localhost:8081/customers/by?status=INACTIVE
   * localhost:8081/customers/predicate?firstName=ALFREDO
   * localhost:8081/customers/predicate?storeId=1&active=1

4. Stream: This solution is probably controversial but hey see how you can improve it.
   Basically we stream all the database data into a stream and apply some queries.
   It uses the employees database mentioned up there.
   Per default, it runs on 8083. And below are the different endpoints:
   * localhost:8083/employees
   * localhost:8083/employees/by?gender=M
   * localhost:8083/employees/filter?bornFrom=1958-01-01&bornTo=1961-01-01


The typical way of running these maven projects:

   ```
   mvn clean compile
   ```

   ```
   mvn package
   ```

   ```
   mvn spring-boot:run
   ```

Run these commands under every module.

Voila!

Make a pull request if you have changes to make.
