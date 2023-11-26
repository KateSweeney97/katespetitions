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
                sh "mvn clean"
            }
        }
        stage('package'){
            steps{
                sh 'mvn package'
            }
        }
        stage('test'){
            steps{
                echo 'test'
            }
        }
        stage('archive'){
            steps{
                archiveArtifacts allowEmptyArchive: true,
                    artifacts: '**/katespetitions*.war'
            }
        }
        stage('deploy'){
            steps{
                sh 'docker build -f Dockerfile -t myapp . '
                sh 'docker run --name "myappcontainer" -p 8081:8080 --detach myapp:latest'
            }
        }
    }
}
