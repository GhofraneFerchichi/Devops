FROM openjdk:11-jre-slim
WORKDIR /app

# the artifact path
ARG artifact=target/springapp.jar

COPY ${artifact} app.jar
EXPOSE 8089
CMD ["java", "-jar", "app.jar"]

