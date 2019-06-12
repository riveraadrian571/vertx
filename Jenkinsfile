pipeline {
    agent any
	tools { 
        jdk 'jdk8' 
		maven 'mvn-3.3.9'
    }
    stages {
	
		stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }

        stage ('Build') {
            steps {
                echo 'create'
			}
        }
    }
}