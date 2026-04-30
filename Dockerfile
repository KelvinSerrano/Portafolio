# Etapa 1: Construcción (Usamos Maven con Java 21)
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /app
# Copiamos el código fuente
COPY pom.xml .
COPY src ./src
# Compilamos el proyecto omitiendo los tests para que sea más rápido
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Una imagen más ligera solo para correr el Java)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
# Copiamos el archivo .jar generado en la etapa 1
COPY --from=build /app/target/*.jar app.jar
# Exponemos el puerto 8080 que usa Spring Boot
EXPOSE 8080
# Comando para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]