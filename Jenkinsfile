pipeline {
    agent any
    environment {
        SONAR_SCANNER_HOME = tool 'SonarQubeScanner'
        SONAR_SCANNER_PATH = "${SONAR_SCANNER_HOME}/bin/sonar-scanner"
        SONAR_URL   = "-Dsonar.host.url='http://172.17.0.3:9000'"
        SONAR_KEY   = '-Dsonar.projectKey=squ_1a6daa8cda9963ee31f1cf1fb94b471d6ad5f643'
        SONAR_NAME  = '-Dsonar.projectName=Web-Pipeline'
        SONAR_INFO  = '-Dsonar.sources=src/main -Dsonar.sourceEncoding=UTF-8 -Dsonar.language=java'
        SONAR_TEST1 = '-Dsonar.test=src/test'
        SONAR_TEST2 = '-Dsonar.junit.reportsPath=target/surefire-reports'
        SONAR_TEST3 = '-Dsonar.surefire.reportsPath=target/surefire-reports'
        SONAR_TEST4 = '-Dsonar.jacoco.reportPath=target/jacoco.exec'
        SONAR_TEST5 = '-Dsonar.java.binaries=target/classes'
        SONAR_TEST6 = '-Dsonar.java.coveragePlugin=jacoco'

        WAR_DIR = "${WORKSPACE}/target"
        WAR_FILES = sh(script: "find ${WAR_DIR} -type f -name '*.war'", returnStdout: true).trim()

        TOMCAT_INFO = 'tomcat:password'
        TOMCAT_URL = '172.17.0.4:8080'
        TOMCAT_DEPLOY = 'lesson15'
        TOMCAT_PATH = "http://${TOMCAT_INFO}@${TOMCAT_URL}/manager/text/deploy?path=/${TOMCAT_DEPLOY}&update=true"
    }
    tools {
        maven 'Apache 3.8.6'
        jdk 'Java 11'
    }
    stages {
        stage('clean') {
            steps {
                echo 'Start Clean'
                sh 'mvn clean'
            }
        }
        stage('test') {
            steps {
                echo 'Start Test'
                sh 'mvn test'
            }
        }
        stage('build') {
            steps {
                echo 'Start Build'
                sh 'mvn clean package'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                echo 'Start Analysis'
                sh "${SONAR_SCANNER_PATH}  ${SONAR_URL} -Dsonar.projectKey='squ_1a6daa8cda9963ee31f1cf1fb94b471d6ad5f643' ${SONAR_KEY} ${SONAR_NAME} ${SONAR_INFO} ${SONAR_TEST1} ${SONAR_TEST2} ${SONAR_TEST3} ${SONAR_TEST4} ${SONAR_TEST5} ${SONAR_TEST6}"
            }
        }
        stage('Deploy to Tomcat') {
            steps {
                script {
                    echo 'Start Deploy'
                    sh(script: "curl --upload-file ${WAR_FILES} ${TOMCAT_PATH}")
                }
            }
        }
    }
}
