

# Build stage
FROM maven:amazoncorretto AS build
COPY pom.xml /app/
COPY src /app/src
RUN mvn -f /app/pom.xml clean
RUN mvn -f /app/pom.xml compile
RUN mvn surefire:test -f /app/pom.xml | tee /app/test_results.txt  # Capture test results to a file
RUN mvn org.apache.maven.plugins:maven-surefire-plugin:3.2.5:test -f /app/pom.xml
RUN mvn -f /app/pom.xml clean package > /app/test_results.txt

# Run stage
FROM openjdk:latest
COPY --from=build /app/target/SET08103_GP-1.0-SNAPSHOT-jar-with-dependencies.jar /app/SET08103_GP-1.0-SNAPSHOT-jar-with-dependencies.jar
COPY --from=build /app/test_results.txt /app/test_results.txt
COPY start.sh /app/start.sh
#RUN chmod +x /app/start.sh
# Convert line endings of the script and any referenced files
RUN sed -i 's/\r$//' /app/start.sh /app/test_results.txt \
    && chmod +x /app/start.sh
ENTRYPOINT ["/bin/bash", "./app/start.sh"]
