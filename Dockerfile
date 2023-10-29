# Utilisez l'image OpenJDK 11 comme image de base
FROM openjdk:11

# Exposez le port sur lequel votre application Java écoute
EXPOSE 8080

# Définissez le répertoire de travail dans le conteneur
WORKDIR /app

# Mettez à jour le système et installez curl pour télécharger le JAR
RUN apt-get update && apt-get install -y curl

# Téléchargez le JAR depuis l'URL spécifiée et nommez-le achat.jar
RUN curl -o achat.jar -L "http://192.168.1.40:8081/repository/deploymentRepo/tn/esprit/rh/achat/1.0/achat-1.0.jar"

# Commande d'entrée pour exécuter l'application Java
CMD ["java", "-jar", "/app/achat.jar"]