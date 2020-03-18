FROM anapsix/alpine-java:8
VOLUME /ami
ENV port 8801

ENV serverName dcp-service
ENV spring.profiles.active h2
ADD ./target/dcp-service-0.0.1-SNAPSHOT.jar /app/app.jar
ADD ./src/main/resources/application.yml /app/config/

EXPOSE 8801
ENTRYPOINT ["java", "-Xmx512m", "-XX:+HeapDumpOnOutOfMemoryError", "-XX:HeapDumpPath=logs", "-Djava.net.preferIPv4Stack=true", "-Duser.timezone=UTC", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]