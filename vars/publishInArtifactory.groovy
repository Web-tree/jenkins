#!/usr/bin/env groovy
import org.webtree.jenkins.pipeline.Artifactory

def call(String artifactoryId = 'webtree-artifactory') {
    new Artifactory(script:this).publish(artifactoryId)
    return this
}