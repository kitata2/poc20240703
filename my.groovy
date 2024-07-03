pipelineJob('my-node-app-pipeline') {
    displayName('My Node.js App Pipeline')

    parameters {
        stringParam('ENVIRONMENT', '', 'Environment to deploy the app')
        stringParam('TAG', '', 'Docker tag for the app')
    }

    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url 'https://github.com/my-username/my-node-app.git'
                        credentials('github-credentials')
                    }
                    branch('main')
                }
            }
            scriptPath('scripts/Jenkinsfile')
        }
    }
}
