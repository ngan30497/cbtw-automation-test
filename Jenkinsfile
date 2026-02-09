pipeline {
    agent any

    triggers {
        cron('* 0 * * 0') // Daily at midnight
        cron('* 0 * * 5') // Weekly on Fridays at midnight
    }

    stages {
        stage('Run Tests') {
            steps {
                script {
                    // Run TestNG tests
                    sh 'mvn test -DsuiteXmlFile=testng.xml'
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                script {
                    // Generate Allure reports
                    sh 'allure generate -o allure-results'
                }
            }
        }
    }

    post {
        always {
            // Archive Allure results
            allure([$class: 'AllureArchiver', results: 'allure-results'])
        }
    }
}