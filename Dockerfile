FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/MyMangaStore-0.0.1.jar
COPY ${JAR_FILE} app_MyMangaStore.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_MyMangaStore.jar"]