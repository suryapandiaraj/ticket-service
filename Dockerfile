FROM openjdk:21-jdk-alpine

LABEL maintainer="ErenJaeger"

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]
