pipeline {
    agent any
	tools { 
        jdk 'jdk8' 
    }
    stages {
	
		stage ('Initialize') {
            steps {
                sh '''
                    
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