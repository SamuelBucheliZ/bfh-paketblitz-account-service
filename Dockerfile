FROM eclipse-temurin:11-jdk-alpine
VOLUME /tmp
COPY target/paketblitz-account-service.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]