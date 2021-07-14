pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out...'
                git 'https://bitbucket.org/Batista_Ricardo/devops-20-21/src/master/ca5/Part_2/'
            }
        }
        stage('Assemble') {
            steps {
                echo 'Assembling...'
                dir ('ca5/Part_2/'){
                sh './gradlew clean assemble'
                }
            }
        }

        stage('Tests') {
                    steps {
                        echo 'Testing...'
                        dir ('ca5/Part_2/'){
                        sh './gradlew test'
                        junit '**/TEST-com.greglturnquist.payroll.EmployeeTest.xml'
                        }
                    }
                }

        stage('Javadoc') {
                    steps{
                        echo 'Generating Javadoc'
                        dir('ca5/Part_2/'){
                        sh './gradlew javadoc'
                        javadoc javadocDir: 'build/docs/javadoc', keepAll: false
                        publishHTML([allowMissing: false, alwaysLinkToLastBuild: false, keepAll: false,
                        reportDir: 'build/docs/javadoc', reportFiles: 'index.html', reportName: 'HTML Report', reportTitles: 'Generated Javadoc'])
                        }
                    }
                }

        stage('Archiving') {
                    steps {
                        echo 'Archiving...'
                        archiveArtifacts 'ca5/Part_2/build/libs/*'
                        }
                    }

     stage('Docker Image') {
                        steps {
                            echo 'Generating Docker Image...'
                            dir('ca5/'){
                            script{
                            ca5_Image = docker.build("titipipers/ca5-part2-image:${env.BUILD_ID}")
                            ca5_Image.push()
                            }
                            }
                            }
                        }
        }
    }