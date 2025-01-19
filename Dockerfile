# Multi stage build
FROM maven:3.8.5-openjdk-8-slim AS builder
WORKDIR /app
COPY . /app
RUN mvn clean install -DskipTests -U -X
FROM jetty:9.4-jdk8-slim

# Copy the WAR file from the builder image into Jetty's webapps directory
COPY --from=builder /app/target/demo-struts1-1.0-SNAPSHOT.war /var/lib/jetty/webapps/demo-struts1.war

# Expose the port Jetty will run on (default: 8080)
EXPOSE 8080