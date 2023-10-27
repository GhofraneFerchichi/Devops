FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/SpringApp.jar SpringApp.jar
EXPOSE 8088
CMD ["java", "-jar", "my-service.jar"]
