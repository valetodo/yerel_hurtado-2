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

        stage ('Build_webApplication') {
            steps {
                sh './JavaWebApplication/gradlew clean assemble -p JavaWebApplication'
                sh './JavaWebApplication/gradlew uploadArchives -p JavaWebApplication'
                archiveArtifacts artifacts: '**/repos/*.war'
            }
        }
        stage ('Testing_webApplication') {
            steps {
                sh './JavaWebApplication/gradlew test -p JavaWebApplication'
                archiveArtifacts artifacts: '**/reports/tests/test/*.html'
            }
        }
        stage ('Security_webApplication') {
            steps {
                sh './JavaWebApplication/gradlew -p sonarqube'
                sh './JavaWebApplication/gradlew -p dependencyCheckAnalyze'
                archiveArtifacts artifacts: '**/repos/*.html'
            }
        }
        stage ('Deploy_webApplication') {
            steps {
                sh './JavaWebApplication/gradlew -b deploy.gradle copyWar'
            }
        } 
    }
}
