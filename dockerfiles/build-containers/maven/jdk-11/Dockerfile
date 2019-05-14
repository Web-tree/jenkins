FROM webtree/build-images:base-maven as source

FROM maven:3.5.4-jdk-11-slim
COPY --from=source /repo /root/.m2/repository/
