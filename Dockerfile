# Etapa 1: Usar uma imagem base que contém o JDK 21
FROM openjdk:21-jdk-slim AS build

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo pom.xml e baixar as dependências do Maven
COPY pom.xml .

# Baixar as dependências sem construir o projeto
RUN mvn dependency:go-offline

# Copiar todo o código do projeto para dentro do container
COPY src ./src

# Compilar o projeto
RUN mvn clean package -DskipTests

# Etapa 2: Construir a imagem final
FROM openjdk:21-jdk-slim

# Definir o diretório de trabalho para a etapa final
WORKDIR /app

# Copiar o arquivo JAR gerado na etapa de build para a imagem final
COPY --from=build /app/target/Java_Project-1.0-SNAPSHOT.jar /app/app.jar

# Expor a porta em que a aplicação irá rodar (exemplo: porta 8080)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
