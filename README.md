# Introduction

This project aims to demonstrate how Kafka works with Spring Cloud Stream in distributed systems. 
This project simulates an Order Management system containing an Order Producer Service and an Order Consumer Service.
In production, each service can be scaled up horizontally by adding more instance. 

Order Service instances consume Kafka message with the same consumer group to

## Tech stack

JDK 11, Gradle, Spring boot, Spring Feign, Resilience4j, Wiremock

We will use Spring Feign to make RESTful requests to the KYC service and enable bulkhead to the **VerificationService**. The source
code is really straightforward, the **VerificationServiceClient** makes request to the KYC API which is consumed by the
**VerificationUserService** in order to return the verification result to customers via **VerificationUserEndpoint**.

Bulkhead is applied to the **VerificationService* via the below configurations:
```shell
resilience4j.bulkhead:
  instances:
    verificationUserService:
      maxConcurrentCalls: 5
      maxWaitDuration: 2000ms
```
We will write an integration test (**VerificationServiceTest**) to verify how Bulkhead works by a few scenarios.

## How to get started?
We can start this project via below gradle commands:
```shell
gradle build
gradle bootRun
```
To run the integration test
```shell
gradle build
gradle test
```

