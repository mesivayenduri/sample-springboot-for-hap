pipeline {
    agent any

    tools {
        maven 'maven'    // Must match the name in Jenkins tool config
        jdk 'jdk-17'           // Must match your JDK config name
    }

    environment {
        MAVEN_HOME = "${tool ''}"
        JAVA_HOME = "${tool 'jdk-17'}"
        PATH = "${env.JAVA_HOME}/bin:${env.MAVEN_HOME}/bin:${env.PATH}"
    }
    stages {
        // stage('Checkout') {
        //     steps {
        //         git 'https://github.com/mesivayenduri/sample-springboot-for-hap.git'
        //     }
        // }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
    post {
        success {
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            junit '**/target/surefire-reports/*.xml'
        }
        failure {
            echo 'Build failed!'
        }
    }
    triggers {
        pollSCM('H/5 * * * *') // Poll SCM every 5 minutes
    }
