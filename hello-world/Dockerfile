FROM openjdk:17-jdk-alpine
WORKDIR /test
COPY target/hello-world-1.0.0.jar xyz.jar
ENTRYPOINT [ "sh","-c","java -jar xyz.jar" ]
