FROM maven:3.8.4-openjdk-11

WORKDIR /home

COPY . /home/

RUN mvn clean test