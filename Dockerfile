# Build stage
FROM maven:amazoncorretto
COPY pom.xml /app/
COPY src /app/src
RUN mvn -f /app/pom.xml clean
RUN mvn -f /app/pom.xml compile
RUN mvn -f /app/pom.xml clean package -DskipTests
COPY start.sh /app/start.sh
RUN chmod +x /app/start.sh
ENTRYPOINT ["/bin/bash", "./app/start.sh"]

