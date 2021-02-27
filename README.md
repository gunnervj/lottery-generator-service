# Lottery Generator Service

### Description

This service will generate random lottery numbers. Lottery number series and length can be configured through properties.

### BUILD

Project can be build via maven or can be done via docker

#### DOCKER

Docker is using multistage build. First it will run the maven build and will build docker image at the second stage.

Run 

` docker build . -t vnair5/lottery-generator-service:latest `

` docker run -p 8090:8090 -d vnair5/lottery-generator-service`


### Endpoint

Can be accessed via.

http://localhost:8090/lottery/generate