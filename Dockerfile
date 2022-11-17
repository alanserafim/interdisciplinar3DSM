FROM eclipse-temurin:11
MAINTAINER fateczl.gov.sp.br
COPY target/grupo3-0.0.1-SNAPSHOT.jar grupo3-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/grupo3-0.0.1-SNAPSHOT.jar"]