FROM openjdk:8-jre-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} api-gateway-service.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","/api-gateway-service.jar"]
