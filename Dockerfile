FROM openjdk:11-jre-slim
WORKDIR /app

# the artifact path
ARG artifact=target/achat.jar

COPY ${artifact} my-service-0.1.jar
EXPOSE 8088
CMD ["java", "-jar", "my-service-0.1.jar"]
