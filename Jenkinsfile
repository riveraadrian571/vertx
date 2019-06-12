pipeline {
    agent any
    tools {
        maven 'apache-maven-3.6.1'
        jdk 'jdk1.8.0_144'
    }
    stages {
        stage ('Initialize') {
            steps {
                bat 'echo step 1 idk'
                bat 'echo "PATH = ${PATH}"'
                bat 'echo "M2_HOME = ${M2_HOME}"'
            }
        }

        stage ('Build') {
            steps {
                bat 'mvn -Dmaven.test.failure.ignore=true install' 
            }
        }
    }
}