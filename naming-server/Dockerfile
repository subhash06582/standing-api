FROM openjdk:8-jdk-alpine

LABEL authors="Subhash Mishra <subhash06582@gmail.com>"

USER root

WORKDIR /usr/app

COPY target/naming-server-1.0.0.jar /usr/app

EXPOSE 8761

ARG PROFILE=dev

ENV spring.profiles.active=$PROFILE

ENTRYPOINT [ "java", "-jar", "naming-server-1.0.0.jar" ]

# docker build -t subhash06582/naming-server .
# docker build -t subhash06582/naming-server . --build-arg PROFILE=prod
# docker run -p 8761:8761 -d --name naming-server subhash06582/naming-server
# docker exec -it naming-server sh
