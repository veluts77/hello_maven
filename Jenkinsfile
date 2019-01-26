pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        stage('build') {
            steps {
                sh 'echo "Start building :)"'
                sh 'mvn clean package'
                sh 'echo "Stop building :)"'
            }
        }
    }
}
