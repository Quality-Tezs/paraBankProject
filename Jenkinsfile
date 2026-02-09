pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'Java21'
    }

    stages {

        stage('Clean Workspace') {
            steps {
                cleanWs()
            }
        }

        stage('Checkout Code') {
            steps {
                git branch: 'master', url: 'https://github.com/Quality-Tezs/paraBankProject.git'
            }
        }

        stage('Build Project') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Automation Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Generate Allure Report') {
            steps {
                allure([
                    results: [[path: 'target/allure-results']]
                ])
            }
        }
    }

    post {
        success {
            echo '✅ Pipeline Completed Successfully'
        }

        failure {
            echo '❌ Pipeline Failed'
        }
    }
}
