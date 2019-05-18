#builders
FROM maven:3-jdk-8-alpine as builder-jdk8
RUN apk update && \
    apk add git

RUN git clone https://github.com/Web-tree/trust.git && \
    cd trust/back && mvn install -DskipTests && \
    cd ../../
RUN git clone https://github.com/Web-tree/auth && \
    cd auth && mvn package -DskipTests
#RUN git clone https://github.com/Web-tree/mydata && \
#    cd ../../mydata/api && mvn package -DskipTests
RUN mv ~/.m2/repository /repo

FROM maven:3-jdk-11-slim as builder-jdk11
RUN apt update && \
    apt install -y git

RUN git clone https://github.com/Web-tree/mystuff.git && \
    cd mystuff/back && mvn package -DskipTests && \
    mv ~/.m2/repository /repo

FROM alpine
COPY --from=builder-jdk8 /repo /repo
COPY --from=builder-jdk11 /repo /repo