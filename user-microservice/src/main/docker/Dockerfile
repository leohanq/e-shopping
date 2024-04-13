FROM eclipse-temurin:17-jdk-alpine
MAINTAINER lq1930
VOLUME /tmp
ARG JAR_FILE=*.jar
ADD ${JAR_FILE} user.jar
ENTRYPOINT ["java","-jar","/user.jar"]