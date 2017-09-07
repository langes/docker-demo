FROM openjdk:8-alpine
COPY ./target/docker-demo2-1.0.0.jar /app/docker-demo.jar
WORKDIR /app
CMD ["java", "-Xmx100M", "-jar", "docker-demo.jar"]
