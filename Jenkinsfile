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
    }
}
