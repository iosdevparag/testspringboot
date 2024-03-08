FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/app-test.jar .
EXPOSE 8080
CMD ["java","-jar", "app-test.jar"]