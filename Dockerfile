FROM openjdk:11.0.5-jre-slim
EXPOSE 8082
ADD /target/admin-matrix-0.0.1-SNAPSHOT.jar admin-matrix-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","admin-matrix-0.0.1-SNAPSHOT.jar"]