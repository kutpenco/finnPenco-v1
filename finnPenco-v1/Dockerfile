FROM openjdk

WORKDIR /app

COPY /target/finnPenco-v1-0.0.1-SNAPSHOT.jar /app/finnPenco-0.0.1.jar

ENTRYPOINT ["java","-jar","/app/finnPenco-0.0.1.jar"]

EXPOSE 8080