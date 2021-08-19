FROM openjdk:11-jre-slim-buster
VOLUME /main-app
ADD build/libs/newsletter-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]