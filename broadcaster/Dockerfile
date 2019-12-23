FROM openjdk:8-jdk-alpine
ENV CONTAINER_NAME localhost
VOLUME /tmp
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","service.broadcaster.Application"]
CMD /usr/bin/java -cp /broadcaster-0.1.0.jar service.broadcaster.Application ${CONTAINER_NAME}
