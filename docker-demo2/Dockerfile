FROM maven
MAINTAINER Anushka
EXPOSE 8081
#VOLUME /tmp
COPY /target/docker-demo2-0.0.1-SNAPSHOT.jar app2.jar
ENTRYPOINT ["java", "-jar", "app2.jar"]