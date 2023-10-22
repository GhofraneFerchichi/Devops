FROM openjdk:11
EXPOSE 8080
ADD target/achat.jar achat.jar
ENTRYPOINT ["java","-jar","/devops-integration.jar"]