FROM openjdk:8-alpine
COPY target/junior-java-backend-assignment-1.0-SNAPSHOT.jar /app.jar
CMD ["java", "-jar", "/app.jar"]
