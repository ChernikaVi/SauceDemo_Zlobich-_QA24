pipeline {
    agent any

    tools {

        maven "M3"
        jdk 'JDK19'
    }

    triggers {
        parameterizedCron('''
        0 21 * * 0-6 %SUITE=smokeTests.xml;BROWSER=Chrome;HEADLESS=true;
        30 21 * * 0-6 %SUITE=regressionTests.xml;BROWSER=Firefox;HEADLESS=false;
        ''')
    }

    parameters {
        choice(name: 'SUITE', choices: ['src/test/java/suite/smokeTests.xml', 'src/test/java/suite/regressionTests.xml'], description: 'Choose suite to run')
        choice (name: 'BROWSER', choices: ['chrome', 'firefox'], description: 'Select a browser')
        booleanParam (name: 'HEADLESS', defaultValue: false, description: 'Headless mode')
    }

    stages {
        stage('Run test') {
            steps {
                git branch: "${params.BRANCH}", url: 'https://github.com/ChernikaVi/SauceDemo_Zlobich-_QA24'

                sh "mvn -Dmaven.test.failure.ignore=true -Dsuite=${params.SUITE} -Dbrowser=${params.BROWSER} -Dheadless=${params.HEADLESS} clean test"
            }

            post {
                success {
                    junit '**/target/reports/TEST-*.xml'
                }
            }
        }

        stage('Generate Allure report') {
    steps {
         script {
            allure([
             includeProperties: false,
             jdk: '',
             properties: [],
             reportBuildPolicy: 'ALWAYS',
             results: [[path: 'target/allure-results']]
             ])
        }
     }
     }
     }
     }