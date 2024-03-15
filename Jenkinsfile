pipeline {
    agent any

    tools {
        git 'G3'
        maven 'M3'
    }

    environment {
        DOCKERHUB_PWD = credentials('docker-jenkins')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/shawanaGideon/labTwo.git'
            }
        }

        stage('Build Maven Project') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Code Coverage') {
            steps {
                sh 'mvn clean test jacoco:prepare-agent jacoco:report'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t shawana/labthreeimage:1.0 .'
            }
        }

        stage('Docker Login') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-jenkins', usernameVariable: 'shawana', passwordVariable: 'DOCKERHUB_PWD')]) {
                    sh '''
                        echo "$DOCKERHUB_PWD" | docker login -u shawana --password-stdin
                    '''
                }
            }
        }

        stage('Docker Push') {
            steps {
                sh 'docker push shawana/labthreeimage:1.0'
            }
        }
    }
}
