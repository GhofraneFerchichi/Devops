FROM openjdk:11-jre-slim
WORKDIR /app
COPY target/springapp.jar springapp.jar
EXPOSE 8088
CMD ["java", "-jar", "SpringApp.jar"]

