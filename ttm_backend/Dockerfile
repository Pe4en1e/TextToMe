FROM bellsoft/liberica-openjdk-alpine:17.0.12-cds

WORKDIR /back

COPY target/ttm_backend-0.0.1-SNAPSHOT.jar /back/ttm.jar

CMD ["java", "-jar", "ttm.jar"]