FROM openjdk:latest


ADD target/jumiaTask-0.0.1-SNAPSHOT.jar app.jar
COPY sample.db sample.db

ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8088