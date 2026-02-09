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
                bat 'mvn clean test -DsuiteXmlFile=testng.xml -Dmaven.test.failure.ignore=true'
            }
        }
    }

    post {
        always {
            echo 'Build finished!'
            script {
                // Always generate Allure report
                allure includeProperties: false, 
                       jdk: '', 
                       results: [[path: 'target/allure-results']]
            }
        }
        success {
            echo 'Tests passed successfully!'
        }
        failure {
            echo 'Tests failed!'
        }
    }
}