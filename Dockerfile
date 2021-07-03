#build jar

FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/jumiaTask/src
COPY pom.xml /home/jumiaTask
RUN mvn -f /home/jumiaTask/pom.xml clean package


#running jar
FROM openjdk:latest


COPY --from=build /home/jumiaTask/target/jumiaTask-0.0.1-SNAPSHOT.jar /usr/local/lib/app.jar
#ADD target/jumiaTask-0.0.1-SNAPSHOT.jar app.jar
COPY sample.db sample.db

ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]

EXPOSE 8080