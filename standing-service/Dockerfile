FROM openjdk:8-jdk-alpine

LABEL authors="Subhash Mishra <subhash06582@gmail.com>"

USER root

WORKDIR /usr/app

COPY target/standing-service-1.0.1.jar /usr/app

EXPOSE 8803

ARG PROFILE=dev

ENV spring.profiles.active=$PROFILE

ENTRYPOINT [ "java", "-jar", "standing-service-1.0.1.jar" ]

# docker build -t subhash06582/standing-service .
# docker build -t subhash06582/standing-service . --build-arg PROFILE=prod
# docker run -p 8803:8803 -d --name standing-service subhash06582/standing-service
# docker exec -it standing-service sh
