FROM openjdk:11-jre-slim
WORKDIR /app
ARG artifact=target/my-service-0.1.jar
COPY ${artifact} app.jar
EXPOSE 8089
CMD ["java", "-jar", "app.jar"]
