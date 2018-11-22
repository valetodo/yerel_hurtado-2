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
    }
}
