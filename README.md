# Lottery Generator Service

### Description

This service will generate random lottery numbers. Lottery number series and length can be configured through properties.

### BUILD

Project can be build via maven or can be done via docker

#### DOCKER

Run 

` docker build . -t vnair5/lottery-generator-service:latest `

` docker run -p 8090:8090 -d docker build . -t vnair5/lottery-generator-service`

