FROM openjdk
EXPOSE 8082
WORKDIR /app
COPY target/student.jar /app/student.jar
ENTRYPOINT ["java", "-jar" , "student.jar"]