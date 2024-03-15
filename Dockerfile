FROM openjdk:17
WORKDIR /app
COPY . /app
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app/app.jar"]