pipeline
{
	agent any
	
	tools	{
		maven "TestMaven"
		}

	stages
	{
		stage('Build')
		{
			steps
			{
			git 'https://github.com/jglick/simple-maven-project-with-tests.git'
			bat 'mvn -Dmaven.test.failure.ignore=true clean package'
			}
			post
			{
				success
				{
				junit '**/target/surefire-reports/*.xml'
				archiveArtifacts 'target/*.jar'
				}
			}
		}

		stage("Deploy to QA")
		{
			steps
			{
			echo("deploy to qa")
			}
		}

		stage("Regression Automation Test")
		{
			steps
			{
				catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE')
				{
					git 'https://github.com/dhavalesupriya0-sudo/PlaywrightEndtoEnd'
					bat "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_regression.xml"
				}
			}
		}

		stage("Publish Extent Report")
		{
			steps
			{
				publishHTML([allowMissing: false,
				alwaysLinkToLastBuild: false,
				keepAll: true,
				reportDir: 'build',
				reportFiles: 'TestExecutionReport.html',
				reportName: 'HTML Extent Report',
				reportTitles: ''])
			}
		}
	}
}