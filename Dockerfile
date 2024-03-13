

# Build stage
FROM maven:3.6.0-jdk-11-slim AS build
COPY pom.xml /app/
COPY src /app/src
RUN mvn -f /app/pom.xml test | tee /app/test_results.txt  # Capture test results to a file
RUN mvn -f /app/pom.xml clean package

# Run stage
FROM openjdk:latest
COPY --from=build /app/target/SET08103_GP-1.0-SNAPSHOT-jar-with-dependencies.jar /app/SET08103_GP-1.0-SNAPSHOT-jar-with-dependencies.jar
ENTRYPOINT ["java", "-jar", "app/SET08103_GP-1.0-SNAPSHOT-jar-with-dependencies.jar"]
RUN cat /app/test_results.txt