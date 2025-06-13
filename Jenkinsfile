pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: '939c4372-7cc7-414c-a4bf-8a6f8c2fd04c', url: 'https://github.com/JDario-Hernandez/sif-persistence.git'
            }
        }

        stage('Build') {
            steps {
                sh '''
                    docker stop sif-persistence || true
                    docker rm sif-persistence || true
                    docker rmi sif-persistence || true
                    docker build -t sif-persistence .
                '''
            }
        }

        stage('Deploy') {
            steps {
                sh 'docker run -d --name sif-persistence -p 8087:8087 sif-persistence'
            }
        }
    }

    post {
        always {
            cleanWs()
        }
        success {
            echo 'El pipeline se ejecutó correctamente.'
        }
        failure {
            echo 'El pipeline falló.'
        }
    }
}