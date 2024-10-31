pipeline {
    agent { 
        node {
            label 'docker-agent-alpine'
        }
    }
    stages {
        stage('Build Docker Image') {
            steps {
                echo "Building docker image..."
                sh '''
                docker build --no-cache -t greetings_test_service .
                '''
            }
        }
        stage('Deliver') {
            steps {
                echo 'Starting app....'
                sh '''
                docker run -d -p 8081:8081 greetings_test_service
                '''
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}