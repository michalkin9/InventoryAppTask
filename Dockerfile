FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD target/task-0.0.1-SNAPSHOT.jar task-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/task-0.0.1-SNAPSHOT.jar"]