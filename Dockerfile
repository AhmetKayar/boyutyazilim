FROM maven:3-jdk-8-alpine

WORKDIR /usr/src/app

COPY . /usr/src/app
RUN mvn package

CMD [ "sh", "-c", "mvn -Dserver.port=8080 spring-boot:run" ]