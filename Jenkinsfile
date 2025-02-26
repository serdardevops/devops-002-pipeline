pipeline {
    agent any

    tools{
        jdk 'JDK17'
        maven 'Maven3'

    }

    stages {
        stage('Build Maven') {
            steps {
            checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/serdardevops/devops-002-pipeline']])
                bat 'mvn clean install'
            }
        }


        stage('Docker Image') {
            steps {
                bat 'docker build -t serdardevops/my-application .'
            }
        }

        stage('Docker Image to DeckerHub') {
            steps {
              script{
                    withCredentials([string(credentialsId: 'dockerhub', variable: 'dockerhub')]) {
                     //bat 'docker login -u serdardevops -p dckr_pat_LTgLWBx1obez_YmA_S4XC4wx3N8'

                     bat 'echo docker login -u serdardevops -p ${dockerhub}'
                     bat 'docker image push serdardevops/my-application'
                    }
                }
            }
        }

        stage('Deoploy Kubernetes') {
            steps {
              script {
                    kubernetesDeploy (configs: 'deploymentservice.yaml',kubeconfigId: 'kubernetes' )
            }
        }
    }
}