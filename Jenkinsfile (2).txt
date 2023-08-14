pipeline{
agent any
  environment {
        SONAR_SCANNER_HOME = tool 'SonarQubeScanner'
  }
tools { 
 maven 'Apache 3.8.6' 
 jdk 'Java 11' 
 }
stages{
stage("clean"){
steps{
echo "Start Clean"
sh "mvn clean"
}
}
stage("test"){
steps{
echo "Start Test"
sh "mvn test"
}
}
stage("build"){
steps{
echo "Start build"
sh "mvn clean package"
}
}
         stage('SonarQube Analysis') {
            steps {
sh "${SONAR_SCANNER_HOME}/bin/sonar-scanner -Dsonar.host.url='http://172.17.0.3:9000' -Dsonar.token='squ_1a6daa8cda9963ee31f1cf1fb94b471d6ad5f643' -Dsonar.projectKey='squ_1a6daa8cda9963ee31f1cf1fb94b471d6ad5f643' -Dsonar.sources=src -Dsonar.language=java -Dsonar.java.binaries=target/classes"
            }
        }
}
}

