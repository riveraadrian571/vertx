pipeline {
	environment {
		PATH = "C:\\Program Files\\Git\\usr\\bin;C:\\Program Files\\Git\\bin;${env.PATH}"
		stages {
			stage('---clean---') {	
				steps {
					sh "mvn clean"
				}
			}
			stage('---test---') {
				steps {
					sh "mvn test"
				}
			}
			stage('---package---') {
				steps {
					sh "mvn package"
				}
			}
		}
	}
}