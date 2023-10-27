FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/springpp.jar springapp.jar
EXPOSE 8088
CMD ["java", "-jar", "springapp.jar"]

