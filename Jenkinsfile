pipeline{
    agent any
    
    stages{
        stage('getproject'){
            steps{
                git 'https://github.com/KateSweeney97/katespetitions.git'
            }
        }
        stage('Build'){
            steps{
                sh "mvn clean:clean"
                
                sh "mvn dependency:copy-dependencies"
                
                sh "mvn compiler:compile"
            }
        }
        stage(test){
            steps{
                echo 'test'
            }
        }
        stage('exec'){
            steps{
                sh "mvn exec:java"
            }
        }
    }
}
