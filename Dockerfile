
FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/my-service-1.0.jar /app/my-service.jar
# EXPOSE 8080
# Define the command to run your application
CMD ["java", "-jar", "my-service.jar"]
