FROM gradle:8-jdk21-alpine AS builder

WORKDIR /greetings_test_service

COPY gradlew .
COPY gradle gradle

COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradle.properties .
COPY src src

RUN chmod +x ./gradlew

RUN ./gradlew build --no-daemon

FROM ghcr.io/graalvm/graalvm-community:21

WORKDIR /greetings_test_service

COPY --from=builder /greetings_test_service/build/libs/greetingstestservice-0.1-all.jar greetingstestservice.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "greetingstestservice.jar"]