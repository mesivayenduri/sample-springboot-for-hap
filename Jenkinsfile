pipeline {
    agent any

    tools {
        maven 'maven'    // Must match the name in Jenkins tool config
        jdk 'jdk-17'           // Must match your JDK config name
    }

    environment {
        MAVEN_HOME = "${tool 'maven'}"
        JAVA_HOME = "${tool 'jdk-17'}"
        PATH = "${env.JAVA_HOME}/bin:${env.MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/mesivayenduri/sample-springboot-for-hap.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
    }

    post {
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed.'
        }
    }
}
