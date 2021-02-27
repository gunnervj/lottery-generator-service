FROM openjdk:8-jdk-alpine as build

WORKDIR /temp

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests

FROM openjdk:8-jdk-alpine
RUN addgroup -S lottery-group && adduser -S lottery-user -G lottery-group
COPY --from=build /temp/target/lottery-generator-service-*.jar /app/lottery-generator-service.jar

USER lottery-user
ENTRYPOINT ["java", "-jar", "/app/lottery-generator-service.jar"]
EXPOSE 8090