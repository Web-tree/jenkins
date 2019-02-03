package org.webtree.jenkins.pipeline
class Artifactory {
    Script script
    def publish(String credentialsId, String artifactoryPrefix, String jarPath) {
        def version = script.sh(
                script: 'mvn -q -Dexec.executable=echo -Dexec.args=\'${project.version}\' --non-recursive exec:exec',
                returnStdout: true
        ).trim()
        script.withCredentials([script.usernamePassword(credentialsId: credentialsId, usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
            script.sh "curl -u ${script.USERNAME}:${script.PASSWORD} -X put https://artifactory.webtree.org/artifactory/list/dev/${artifactoryPrefix}/${version}/ -T ${jarPath}-${version}.jar"
        }
    }
}