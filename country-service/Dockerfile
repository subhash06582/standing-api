FROM openjdk:8-jdk-alpine

LABEL authors="Subhash Mishra <subhash06582@gmail.com>"

USER root

WORKDIR /usr/app

COPY target/country-service-1.0.0.jar /usr/app

EXPOSE 8801

ARG PROFILE=dev

ENV spring.profiles.active=$PROFILE

ENTRYPOINT [ "java", "-jar", "country-service-1.0.0.jar" ]

# docker build -t subhash06582/country-service .
# docker build -t subhash06582/country-service . --build-arg PROFILE=prod
# docker run -p 8801:8801 -d --name country-service subhash06582/country-service
# docker exec -it country-service sh
