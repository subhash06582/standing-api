FROM openjdk:8-jdk-alpine

LABEL authors="Subhash Mishra <subhash06582@gmail.com>"

USER root

WORKDIR /usr/app

COPY target/league-service-1.0.0.jar /usr/app

EXPOSE 8802

ARG PROFILE=dev

ENV spring.profiles.active=$PROFILE

ENTRYPOINT [ "java", "-jar", "league-service-1.0.0.jar" ]

# docker build -t subhash06582/league-service .
# docker build -t subhash06582/league-service . --build-arg PROFILE=prod
# docker run -p 8802:8802 -d --name league-service subhash06582/league-service
# docker exec -it league-service sh
