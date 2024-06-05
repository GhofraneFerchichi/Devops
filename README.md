# DevOps

Thrilled to share the triumph of my recent DevOps adventure! 🌐 Just completed a dynamic project, steering the full software development lifecycle with precision. Join me on this journey through the integration of state-of-the-art technologies and industry best practices.

## Table of Contents

- [Overview](#overview)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Pipeline Overview](#pipeline-overview)
- [Monitoring](#monitoring)
- [Collaboration](#collaboration)
- [License](#license)

## Overview

This project highlights a robust DevOps pipeline that automates various stages of software development, from building and testing to deployment and monitoring. It leverages industry-standard tools and practices to ensure a seamless and efficient workflow.

## Technologies Used

- **Maven & Git**: Managed the Spring Boot application and version control.
- **JUnit & Mockito**: Ensured code quality with comprehensive testing, enhanced by JaCoCo.
- **GitHub Integration**: Automated pipeline builds using Ngrok to connect Jenkins and GitHub.
- **SonarQube**: Maintained code quality standards.
- **Nexus3**: Managed and hosted artifacts.
- **Docker & DockerCompose**: Created a reliable environment for Spring, MySQL, and Angular.
- **Grafana & Prometheus**: Monitored performance and server health.
- **Jenkins Pipeline**: Developed a CI/CD pipeline for automation.
- **Kubernetes (Minikube)**: Deployed applications with container orchestration.
- **Slack**: Facilitated communication and collaboration.
- **DockerHub**: Managed continuous deployment by pushing Docker images.

## Getting Started

### Clone the Repository

git clone https://github.com/Ghofrane-Ferchichi/DevOps.git
cd DevOps
## Usage

- Build and Run the Application
- Build the project:

./mvnw clean install
Run the application:

./mvnw spring-boot:run
- Docker
- Build the Docker image:

docker build -t devops .
- Run the Docker container:
docker run -p 8080:8080 devops

- Kubernetes
Ensure your Kubernetes cluster is up and running.
Apply the manifest files:
kubectl apply -f k8s/
- Check the status of your pods:
kubectl get pods

## Pipeline Overview
-The Jenkins pipeline automates the following steps:
- Code Checkout: Cloning the repository from GitHub.
- Build: Compiling the code using Maven.
- Testing: Running unit tests with JUnit and Mockito.
- Code Quality Analysis: Using SonarQube for static code analysis.
- Artifact Management: Storing build artifacts in Nexus3.
- Dockerization: Building Docker images and pushing them to DockerHub.
- Deployment: Deploying the application to Kubernetes (Minikube).
- Notification: Sending pipeline status updates to Slack.

## Monitoring
- Grafana & Prometheus: Used to monitor application performance and server health, providing real-time insights and alerting capabilities.
Collaboration
- Slack: Integrated for seamless communication, ensuring the team stays updated with pipeline states and deployments.

##License
This project is licensed under the MIT License. See the LICENSE file for details.
