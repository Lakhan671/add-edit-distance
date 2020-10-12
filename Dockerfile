FROM openjdk:8
ADD target/innowatts-test.jar innowatts-test.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","innowatts-test.jar" ]