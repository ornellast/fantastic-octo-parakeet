FROM amazoncorretto:17
LABEL authors="ornellast"
ADD target/template-service*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]