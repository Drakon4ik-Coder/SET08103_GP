

# Build stage
FROM maven:3.6.0-jdk-11-slim AS build
COPY pom.xml /app/
COPY src /app/src
RUN mvn -f /app/pom.xml test | tee /app/test_results.txt  # Capture test results to a file
RUN mvn -f /app/pom.xml clean package

# Run stage
FROM openjdk:latest
COPY --from=build /app/target/SET08103_GP-1.0-SNAPSHOT-jar-with-dependencies.jar /app/SET08103_GP-1.0-SNAPSHOT-jar-with-dependencies.jar
COPY --from=build /app/test_results.txt /app/test_results.txt
COPY start.sh start.sh
RUN chmod +x start.sh
ENTRYPOINT ["start.sh"]
