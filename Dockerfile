FROM jenkins/jenkins:lts

USER root

RUN apt-get update && apt-get -y install jq

USER jenkins