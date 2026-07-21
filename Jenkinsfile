pipeline
{
	agent any
	
	tools	{
		maven 'TestMaven'
		}

	stages
	{
		stage('Build')
		{
			steps
			{
			git 'https://github.com/jglick/simple-maven-project-with-tests.git'
			sh 'mvn -Dmaven.test.failure.ignore=true clean package'
			}
			post
			{
				success
				{
				junit '**/target/surefire-reports/Test-*.xml'
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

		stage("regression automation Test")
		{
			steps
			{
				catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE')
				{
					git 'https://github.com/dhavalesupriya0-sudo/PlaywrightEndtoEnd'
					sh "mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testrunners/testng_regressions.xml"
				}
			}
		}

		stage("Publish Extent report")
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