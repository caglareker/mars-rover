FROM maven:3.8.5-jdk-11-slim AS build
ADD . ./mars-rover
WORKDIR /mars-rover
RUN mvn clean install -DskipTests

FROM adoptopenjdk/openjdk11:latest
COPY --from=build ./mars-rover/target/*.jar mars-rover.jar
ENTRYPOINT ["java","-jar","/mars-rover.jar"]