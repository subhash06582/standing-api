FROM openjdk:8-jdk-alpine

LABEL authors="Subhash Mishra <subhash06582@gmail.com>"

USER root

WORKDIR /usr/app

COPY target/config-server-1.0.1.jar /usr/app

EXPOSE 8888

ARG PROFILE=native

ENV spring.profiles.active=$PROFILE

ENTRYPOINT [ "java", "-jar", "config-server-1.0.1.jar" ]

# docker build -t subhash06582/config-server .
# docker build -t subhash06582/config-server . --build-arg PROFILE=prod
# docker run -p 8888:8888 -d --name config-server subhash06582/config-server
# docker exec -it config-server sh
