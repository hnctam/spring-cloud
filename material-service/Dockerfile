FROM anapsix/alpine-java:8
VOLUME /ami
ENV port 8803

ENV serverName ami/material-service
ENV spring.profiles.active dev
ADD ./target/material-service-0.0.1-SNAPSHOT.jar /app/app.jar
ADD ./src/main/resources/application.yml /app/config/

EXPOSE 8803
ENTRYPOINT ["java", "-Xmx512m", "-XX:+HeapDumpOnOutOfMemoryError", "-XX:HeapDumpPath=logs", "-Djava.net.preferIPv4Stack=true", "-Dport=8803", "-Duser.timezone=UTC", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]