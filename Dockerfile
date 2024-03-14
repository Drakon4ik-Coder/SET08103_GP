# Build stage
FROM maven:amazoncorretto
COPY pom.xml /app/
COPY src /app/src
RUN mvn -f /app/pom.xml clean
RUN mvn -f /app/pom.xml compile
RUN mvn surefire:test -f /app/pom.xml | tee /app/test_results.txt  # Capture test results to a file
#RUN mvn org.apache.maven.plugins:maven-surefire-plugin:3.2.5:test -f /app/pom.xml | tee /app/test_results.txt
RUN mvn test -Dtest="com.napier.sem.**" -f /app/pom.xml | tee /app/test_results.txt
RUN mvn -f /app/pom.xml clean package -DskipTests
COPY start.sh /app/start.sh
RUN sed -i 's/\r$//' /app/start.sh /app/test_results.txt && chmod +x /app/start.sh
ENTRYPOINT ["/bin/bash", "./app/start.sh"]

