FROM openjdk:8-jdk-alpine
ENV CONTAINER_NAME localhost
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","service.nba.Application"]
CMD /usr/bin/java -cp /nba-0.1.0.jar service.nba.Application ${CONTAINER_NAME}

