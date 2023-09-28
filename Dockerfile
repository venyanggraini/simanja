FROM maven:3 as maven
WORKDIR /opt/app
COPY ./pom.xml /opt/app
RUN mvn verify --fail-never
COPY ./src /opt/app/src
RUN mvn package -DskipTests

FROM eclipse-temurin:17-jre as builder
WORKDIR /opt/application
COPY --from=maven /opt/app/target/*.jar ./application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM --platform=linux/amd64 eclipse-temurin:17-jre
WORKDIR /opt/application
COPY --from=builder /opt/application/dependencies/ ./
COPY --from=builder /opt/application/spring-boot-loader/ ./
COPY --from=builder /opt/application/snapshot-dependencies/ ./
COPY --from=builder /opt/application/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]


# how to run after built docker image
# docker run -e SPRING_DATASOURCE_URL=jdbc:postgresql://192.168.1.17:54321/simanjadb -p 9000:9000 simanja-api-services