package org.webtree.jenkins.pipeline

class Artifactory {
    Script script

    def publish(String artifactoryId) {
        script.rtMavenDeployer(
                id: 'webtree-maven-deployer',
                serverId: "${artifactoryId}",
                releaseRepo: 'libs-release',
                snapshotRepo: 'dev'
        )

        script.rtMavenRun(
                goals: 'clean install',
                deployerId: 'webtree-maven-deployer',
        )
    }
}