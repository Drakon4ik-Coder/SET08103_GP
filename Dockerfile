FROM openjdk:latest
LABEL authors="Alex"
COPY ./target/SET08103_GP-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "SET08103_GP-1.0-SNAPSHOT-jar-with-dependencies.jar", "-d"]
