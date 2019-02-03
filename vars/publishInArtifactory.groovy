#!/usr/bin/env groovy
import org.webtree.jenkins.pipeline.Artifactory

def call(String credentialsId, String artifactoryPrefix, String jarPrefix) {
    new Artifactory(script:this).publish(credentialsId, artifactoryPrefix, jarPrefix)
    return this
}