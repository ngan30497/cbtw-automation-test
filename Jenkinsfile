pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    triggers {
        pollSCM('H/5 * * * *') // Poll GitHub every 5 minutes
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn clean test -DsuiteXmlFile=testng.xml'
            }
        }

        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false, 
                       jdk: '', 
                       results: [[path: 'target/allure-results']]
            }
        }
    }

    post {
        always {
            echo 'Build finished!'
        }
        success {
            echo 'Tests passed successfully!'
        }
        failure {
            echo 'Tests failed!'
        }
    }
}