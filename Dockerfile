FROM openjdk:8-jdk
EXPOSE 8080
ARG JAR_FILE=target/FileSystem-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} FileSystem-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/FileSystem-0.0.1-SNAPSHOT.jar"]