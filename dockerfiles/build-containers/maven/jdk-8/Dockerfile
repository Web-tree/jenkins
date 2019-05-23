FROM webtree/base-maven-builder as source

FROM maven:3.6.0-jdk-8-alpine
COPY --from=source /repo /root/.m2/repository/
