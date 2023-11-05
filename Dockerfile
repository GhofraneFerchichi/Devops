FROM openjdk:11-jre-slim
WORKDIR /app

# the artifact path
ARG artifact=target/achat.jar

COPY ${artifact} achat.jar
EXPOSE 8088
CMD ["java", "-jar", "achat.jar"]
