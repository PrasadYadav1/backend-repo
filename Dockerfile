FROM openjdk:11-jdk-alpine
ADD target/technoidentity-api.jar technoidentity-api.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","technoidentity-api.jar"]
