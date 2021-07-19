FROM openjdk:8-jre-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} investments-service.jar

EXPOSE 8084

ENTRYPOINT ["java","-jar","/investments-service.jar"]
