pipeline {
    agent { 
        node {
            label 'docker-agent-alpine'
            }
      }
    stages {
        stage('Build') {
            steps {
                echo "Building.."
                sh '''
                echo "Building executable jar..."
                chmod +x ./gradlew
                ./gradlew build --no-daemon
                '''
            }
        }
        stage('Test') {
            steps {
                echo "Testing..."
            }
        }
        stage('Deliver') {
            steps {
                echo 'Starting app....'
                sh '''
                ./gradlew run
                '''
            }
        }
    }
}