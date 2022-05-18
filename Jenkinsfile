pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones específicas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3')) //Número maximo de ejecuciones a guardar
		disableConcurrentBuilds() //No permitir compilaciones simultaneas
  }

  //Una sección que define las herramientas “preinstaladas” en Jenkins
  tools {
    jdk 'JDK11_Centos' //Versión preinstalada en la Configuración del Master
  }

  //Aquí comienzan los “items” del Pipeline
  stages{
    stage('Checkout') {
      steps{
        echo "------------>Checkout<------------"
		checkout scm
      }
    }
	
	stage('Clean') {
      steps{
        echo "------------>Clean<------------"
        sh 'chmod +x ./microservicio/gradlew'
    	sh './microservicio/gradlew --b ./microservicio/build.gradle clean'
      }
    }
    
    stage('Compile & Unit Tests') {
      steps{
        sh 'chmod +x ./microservicio/gradlew'
        sh './microservicio/gradlew --b ./microservicio/build.gradle test'
      }
    }

    stage('Static Code Analysis') {
      steps{
        echo '------------>Análisis de código estático<------------'
			withSonarQubeEnv('Sonar') {
			sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
			sonarqubeMasQualityGatesP(sonarKey:'co.com.ceiba.adn:miprimertitulo-rober.sehuanez', 
			sonarName:'CeibaADN-MiPrimerTitulo(rober.sehuanez)', 
			sonarPathProperties:'./sonar-project.properties')

        }
      }
    }

    stage('Build') {
      steps {
        echo "------------>Build<------------"
		//Construir sin tarea test que se ejecutó previamente
		sh './microservicio/gradlew --b ./microservicio/build.gradle build -x test'
      }
    }  
  }

  post {
    always {
      echo 'This will always run'
    }
    success {
      echo 'This will run only if successful'
	  junit 'microservicio/dominio/build/test-results/test/*.xml' //RUTA RELATIVA DE LOS ARCHIVOS .XML
    }
    failure {
      echo 'This will run only if failed'
	  //send notifications about a Pipeline to an email
	  mail (to: 'rober.sehuanez@ceiba.com.co',
		    subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
			body: "Something is wrong with ${env.BUILD_URL}")
    }
    unstable {
      echo 'This will run only if the run was marked as unstable'
    }
    changed {
      echo 'This will run only if the state of the Pipeline has changed'
      echo 'For example, if the Pipeline was previously failing but is now successful'
    }
  }
}