# Use minimal JDK base image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy the jar file from your local system into the container
COPY target/bloom-tailor-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Spring Boot usually runs on 8080)
EXPOSE 8080

# Command to run your jar
ENTRYPOINT ["java", "-jar", "app.jar"]
