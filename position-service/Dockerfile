FROM openjdk:8-jdk-alpine

LABEL authors="Subhash Mishra <subhash06582@gmail.com>"

USER root

WORKDIR /usr/app

COPY target/position-service-1.0.1.jar /usr/app

EXPOSE 8080

ARG PROFILE=dev

ENV spring.profiles.active=$PROFILE

ENTRYPOINT [ "java", "-jar", "position-service-1.0.1.jar" ]

# docker build -t subhash06582/position-service .
# docker build -t subhash06582/position-service . --build-arg PROFILE=prod
# docker run -p 8080:8080 -d --name position-service subhash06582/position-service
# docker exec -it position-service sh
