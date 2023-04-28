FROM maven
MAINTAINER Anushka
EXPOSE 8080
COPY /target/docker-demo-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]