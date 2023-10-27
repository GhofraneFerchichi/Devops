FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/my-service-1.0.jar my-service.jar
EXPOSE 8088
CMD ["java", "-jar", "my-service.jar"]
