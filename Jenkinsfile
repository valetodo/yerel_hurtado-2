pipeline {
    agent any

    stages {
        stage ('Build') {
            steps {
                sh './quickstart/gradlew clean assemble -p quickstart'
            }
        }
        stage ('Testing') {
            steps {
                sh './quickstart/gradlew test -p quickstart'
                junit '**/test-results/test/*.xml'
            }
        }
        stage ('Publish') {
            steps {
                sh './quickstart/gradlew uploadArchives -p quickstart'
                archiveArtifacts artifacts: '**/repos/*.jar'
            }
        } 

        stage ('Build') {
            steps {
                sh './JavaWebApplication/gradlew clean assemble -p JavaWebApplication'
                sh './JavaWebApplication/gradlew uploadArchives -p JavaWebApplication'
                archiveArtifacts artifacts: '**/repos/*.war'
            }
        }
        stage ('Testing') {
            steps {
                sh './JavaWebApplication/gradlew test -p JavaWebApplication'
                junit '**/reports/tests/test/*.html'
            }
        }
        stage ('Security') {
            steps {
                sh './JavaWebApplication/gradlew sonarqube'
                sh './JavaWebApplication/gradlew dependencyCheckAnalyze'
                archiveArtifacts artifacts: '**/repos/*.html'
            }
        }
        stage ('Deploy') {
            steps {
                sh './JavaWebApplication/gradlew -b deploy.gradle copyWar'
            }
        } 
    }
}
