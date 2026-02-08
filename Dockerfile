FROM gradle:jdk21-alpine AS BUILD
WORKDIR /app
COPY . .
RUN gradle build --no-daemon -x test

FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=BUILD /app/build/libs/*.jar /app/agendador-tarefas.jar
EXPOSE 8081
CMD ["java", "-jar", "/app/agendador-tarefas.jar"]