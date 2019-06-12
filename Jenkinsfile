pipeline {
    agent any
    stages {
        stage ('Initialize') {
            steps {
                sh 'make'
			}
        }

        stage ('Build') {
            steps {
                sh 'create'
			}
        }
    }
}