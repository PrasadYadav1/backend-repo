FROM adoptopenjdk/openjdk11:ubi
EXPOSE 9000
ADD target/technoidentity-api.jar technoidentity-api.jar
ENTRYPOINT ["java","-jar","/technoidentity-api.jar"]
