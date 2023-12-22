pipeline {
    agent any

    tools {
        maven "Maven 3.9.6"
    }

    stages {
        stage('JenkinsFileLoaded') {
            steps {
                script {
                    echo 'Jenkinsfile is loaded'
                }
            }
        }

        stage('Maven Build') {
            steps {
                bat 'mvn clean package'
            }
            post {
                success {
                    archiveArtifacts 'target/*.jar'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build('WishTheSpire:latest')
                    bat "docker image prune -f"
               }
            }
        }

        stage('Start Docker Container') {
            steps {
                script {
                    try {
                        bat "docker stop WishTheSpire"
                        bat "docker rm WishTheSpire"
                    } catch (Exception e) {
                       echo '404 Not Found : WishTheSpire'
                    }
                    bat "docker run --name WishTheSpire -d -p 9075:8080 WishTheSpire:latest WishTheSpire.jar"
                }
            }
        }
    }
}
