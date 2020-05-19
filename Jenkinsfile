pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                println "Build"
                sh 'mvn clean'
            }
        }
        stage('Test') {
            steps {
                println "Test1"
                sh 'mvn test'
            }
        }
        stage('Package') {
           steps {
              println "packaging ....."
              sh 'mvn package -Dmaven.test.skip=true'
              sh 'sudo docker build -t jenkins-docker:v1.0.1 .'
              println "Deploy_test1"
           }
        }
        /* stage('Deploy') {
            steps {
                sh 'docker rm -f jenkins-docker'
                sh 'docker rmi -f jenkins-docker'
                sh 'docker run -dit --name jenkins-docker -p 9011:9011 jenkins-docker:v1.0.1'
                println "Deploy_test1"
            }
        } */
    }
}