FROM jenkins/jenkins:lts

USER root

RUN apt-get update
RUN apt-get -y install jq

RUN groupadd docker && \
    usermod -a -G docker jenkins

VOLUME /var/run/docker.sock
RUN chown -R jenkins /var/run/docker.sock

USER jenkins