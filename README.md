## Microservices of two Java processes

#### 1. Application Process (Server)

Runs on: localhost:8090/triangle-service/

#### 2. Data Injector Process (client)

Runs on: http://localhost:8080/data-injector/generate


## Requirements

* [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or later
* [Maven 3.0+](http://maven.apache.org/download.cgi)

## Build with Maven

* [Welcome to Apache Maven](https://maven.apache.org/)
* [Building Java Projects with Maven](https://spring.io/guides/gs/maven/)

## Build and run tests with Maven

* cd into project-root-folder using the terminal.

* Run this maven command:
 
``` 
mvn clean test
``` 

## Run the services

* cd into project-root-folder using your terminal.

* Using Maven you can run the application using **mvn spring-boot:run**. 

```
1. Application Process (Server)
  cd microservices/triangle-service/triangle-service-application
  mvn spring-boot:run
```

* Or you can build an executable JAR file with **mvn clean package** and run the JAR by typing:

```
  java -jar microservices/triangle-service/target/triangle-service-1.0.0.jar
```

```
2. Data Injector Process (client)
  cd microservices/data-injector
  mvn spring-boot:run
```

* Or you can build an executable JAR file with **mvn clean package** and run the JAR by typing:

```
  java -jar microservices/data-injector/target/data-injector-1.0.0.jar
```

## Test the services

* Call this get request a few times, each call will create a new triangle with a 'pre_calc' state, which will be updated by a scheduler service (AlgoService):

```
GET http://localhost:8080/data-injector/generate
```

* Get all triangles:

```
GET localhost:8090/triangle-service/
```

## H2 Console

http://localhost:8090/pacing-service/h2-console
```
Driver Class: org.h2.Driver
JDBC URL: jdbc:h2:C:\workspace\microservices\data\h2db
User Name: sa
Password:
```