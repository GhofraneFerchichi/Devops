### STAGE 1: BUILD ###
# Use Node.js 16.x
FROM node:16-alpine AS builder

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier package.json et package-lock.json dans le répertoire de travail
COPY package*.json ./

# Installer les dépendances
RUN npm install --force

# Copier l'ensemble du code source dans le répertoire de travail
COPY . .

# Construire l'application Angular
RUN npm run build

# Étape 2 : Utiliser Nginx comme image de base pour servir l'application Angular
FROM nginx:latest

# Copier l'application Angular compilée de l'étape "builder" vers le dossier public par défaut de Nginx
COPY --from=builder /app/dist/crudtuto-Front /usr/share/nginx/html

# Exposer le port 80 pour le serveur web
EXPOSE 80
