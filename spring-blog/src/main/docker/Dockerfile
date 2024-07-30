FROM amazoncorretto:21
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} spring-blog.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","spring-blog.jar"]