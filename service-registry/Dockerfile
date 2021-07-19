FROM openjdk:8-jre-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} registry-service.jar

EXPOSE 8761

ENTRYPOINT ["java","-jar","/registry-service.jar"]
