#builder
FROM maven:alpine as builder
RUN apk update && \
    apk add git

RUN git clone https://github.com/Web-tree/mystuff.git && \
    git clone https://github.com/Web-tree/trust.git && \
    git clone https://github.com/Web-tree/mydata && \
    git clone https://github.com/Web-tree/auth && \
    cd mystuff/back && mvn dependency:resolve && \
    cd ../../trust/back && mvn install && \
    cd ../../mydata/back && mvn dependency:resolve && \
    cd ../../auth/back && mvn dependency:resolve && \
    mv ~/.m2/repository /repo

FROM alpine
COPY --from=builder /repo /repo