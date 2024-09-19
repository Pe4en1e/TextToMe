FROM bellsoft/liberica-openjdk-alpine:17.0.12-cds

WORKDIR /back

COPY out/artifacts/ttm_backend_jar/ttm_backend.jar /back/ttm_backend.jar

CMD ["java", "-jar", "ttm_backend.jar"]