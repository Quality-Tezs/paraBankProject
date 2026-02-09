pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'Java21'
    }

    environment {
        MAVEN_OPTS = '-Dmaven.test.failure.ignore=true'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'master', url: 'https://github.com/Quality-Tezs/paraBankProject.git'
            }
        }

        stage('Clean Workspace') {
            steps {
                cleanWs()
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
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'target/allure-results']]
                ])
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.html', fingerprint: true
        }

        success {
            echo '✅ Pipeline completed successfully!'
        }

        failure {
            echo '❌ Pipeline failed! Please check logs.'
        }
    }
}
