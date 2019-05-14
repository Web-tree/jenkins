#builder
FROM maven:alpine as builder
RUN apk update && \
    apk add git

RUN git clone https://github.com/Web-tree/mystuff.git && \
    cd mystuff/back && \
    mvn dependency:resolve && \
    mv ~/.m2/repository /repo

FROM alpine
COPY --from=builder /repo /repo