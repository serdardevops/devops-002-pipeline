# Uygulamanın çalışması için JDK lazım
#FROM amazoncorretto:17
FROM openjdk:17

# Prokemizin jar dosyası konumu
ARG JAR_FILE=target/*.jar

# Projenin jar halini dockerin içine şu isimle kopyala
COPY ${JAR_FILE} devops-hello-app.jar

# Terminalden çalıştırmak istediğin komutları CMD ile kullanıyorsun
CMD apt-get update
# CMD apt-get upgrade -y

# İç portu sabitlemek için
EXPOSE 8080

# Uygulamanın çalışacağı komut
ENTRYPOINT ["java", "-jar", "devops-hello-app.jar"]