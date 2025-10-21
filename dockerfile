# --- STAGE 1: build ---
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src

# Empaqueta la app (si no quieres tests, añade -DskipTests)
RUN mvn -B package -DskipTests

# --- STAGE 2: runtime (más liviano, solo JRE) ---
FROM eclipse-temurin:21-jre

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
