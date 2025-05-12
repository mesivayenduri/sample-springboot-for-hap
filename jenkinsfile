pipeline {
    agent any

    tools {
        maven 'Maven 3.6.3' // or whatever name you configured in Jenkins -> Global Tool Configuration
        jdk 'jdk-17'         // if you've configured JDK 17 in Jenkins tools
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/mesivayenduri/sample-springboot-for-hap.git'
            }
        }
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
}
    triggers {
        pollSCM('H/5 * * * *') // Poll SCM every 5 minutes
    }
}