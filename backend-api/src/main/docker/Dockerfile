# Use a base image with Java and a specific version (e.g., OpenJDK 11)
FROM openjdk:21

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/*.jar /app/app.jar

# Expose the port that your Spring Boot app will run on
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "app.jar"]