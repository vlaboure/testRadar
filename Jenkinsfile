pipeline {
  agent any
  stages {
    stage('test') {
      steps {
        git(url: 'https://github.com/vlaboure/testRadar.git', branch: 'main', credentialsId: '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')
      }
    }

  }
  environment {
    Build = 'sh \'make\''
  }
}