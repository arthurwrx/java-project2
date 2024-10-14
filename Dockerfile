# Etapa 1: Usar uma imagem base que contém o Maven e o JDK 17
FROM maven:3.9.8-eclipse-temurin-17 AS build

# Copiar o pom.xml e o código fonte para a imagem
COPY pom.xml /app/pom.xml
COPY src /app/src

# Mudar o diretório de trabalho
WORKDIR /app

# Compilar o projeto
RUN mvn clean package

# Etapa 2: Usar uma imagem JDK 17 para rodar a aplicação
FROM eclipse-temurin:17-jdk

# Copiar o JAR gerado da etapa anterior
COPY --from=build /app/target/Java_Project-1.0-SNAPSHOT.jar /app/app.jar

# Expor a porta que a aplicação usa
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
