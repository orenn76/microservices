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
  cd mprest/triangle-service/triangle-service-application
  mvn spring-boot:run
```

```
2. Data Injector Process (client)
  cd mprest/data-injector
  mvn spring-boot:run
```

* Or you can build an executable JAR file with **mvn clean package** and run the JAR by typing:

```
  java -jar target/mprest-1.0.0.jar
```

## Test the services

Start both services and visit the following url a few times:

```
http://localhost:8080/data-injector/generate
```

Each visit will create a new triangle with a 'pre_calc' state, which will be updated by a scheduler service (AlgoService).