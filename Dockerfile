FROM amazoncorretto:17

COPY /target/demo-0.0.1-SNAPSHOT.jar /var/app/app.jar

EXPOSE 4444

ENTRYPOINT [ "java", "-jar", "/var/app/app.jar" ]