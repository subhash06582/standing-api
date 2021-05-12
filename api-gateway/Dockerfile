FROM openjdk:8-jdk-alpine

LABEL authors="Subhash Mishra <subhash06582@gmail.com>"

USER root

WORKDIR /usr/app

COPY target/api-gateway-1.0.0.jar /usr/app

EXPOSE 8765

ARG PROFILE=dev

ENV spring.profiles.active=$PROFILE

ENTRYPOINT [ "java", "-jar", "api-gateway-1.0.0.jar" ]

# docker build -t subhash06582/api-gateway .
# docker build -t subhash06582/api-gateway . --build-arg PROFILE=prod
# docker run -p 8765:8765 -d --name api-gateway subhash06582/api-gateway
# docker exec -it api-gateway sh
