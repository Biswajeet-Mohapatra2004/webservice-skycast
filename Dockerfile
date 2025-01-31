FROM openjdk:24-slim-bullseye
VOLUME /tmp
COPY ./target/proxy-server.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
EXPOSE 8080