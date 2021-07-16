# Base image
FROM openjdk:11

EXPOSE 8080:8080
RUN mkdir /app

COPY ./build/install/com.actonate.ktor-starter/ /app/
WORKDIR /app/bin

CMD ["./com.actonate.ktor-starter"]
