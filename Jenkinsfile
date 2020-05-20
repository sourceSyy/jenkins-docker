pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                println "Build"
                 script {
                    def pom = readMavenPom file: 'pom.xml'
                    POM_VERSION = pom.version
                    PROJECT_NAME = pom.artifactId
                    if (env.BRANCH_NAME == 'deploy') {
                        DOCKER_TAG = 'prod'
                    }
                    if (env.BRANCH_NAME == 'review') {
                        DOCKER_TAG = 'beta'
                    }
                    if (env.BRANCH_NAME == 'master') {
                        DOCKER_TAG = 'test'
                    }
                 }
                 echo 'Building ' + PROJECT_NAME + '/' + POM_VERSION + ' ...'
                 sh 'mvn compile'
                //sh 'mvn clean'
            }
        }
        stage('Test') {
            steps {
                println "Test1"
                //sh 'mvn test'
            }
        }
        stage('Package') {
           steps {
              println "packaging ....."
              sh 'mvn package -Dmaven.test.skip=true'
              //sh 'sudo docker rmi -f jenkins-docker:v1.0.1'
              sh 'sudo docker build . -t jenkins-docker:' +  DOCKER_TAG
              println "packaging .....  done"

              //println "Deploy_test1"
           }
        }
        stage('Deploy') {
           steps {
               sh 'docker stop  jenkins-docker'
               sh 'docker rm -f jenkins-docker'
               sh 'docker run -dit --name jenkins-docker -p 9011:9011 jenkins-docker:' = DOCKER_TAG
               println "Deploy ..... done"
           }
       }
    }
}