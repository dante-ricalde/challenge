# Postman project at the root folder of this project
`backend_api.postman_collection.json`

# Application running in local
http://localhost:8080

# Access the OpenAPI definitions in JSON format
http://localhost:8080/v3/api-docs

# Access the Swagger UI to explore the API documentation and try the endpoints
http://localhost:8080/swagger-ui/index.html

# CODE REVIEW AND REFACTORING
## For the endpoint /api/users
- We can add some filters to this endpoint to reduce the number of users returned avoiding this way 
  responding a giant response that can be difficult to transmit and process. The filters can be some fields
  of the Entity `User`
- We can add some pagination to this endpoint
- We can stream the user data for the response using Spring WebFlux

    ```java
        @GetMapping("/users")
        public Flux<User> users() {
            log.debug("Invoking /users endpoint");
            return userService.findAll();
        }
    ```

## For the endpoint /api/square
-  We could add some restrictions to the parameter `number` like: number of digits and fractional digits.

    ```java
        @GetMapping("/square")
        public Double square(@RequestParam @Digits(integer = 10, fraction = 2) Double number) {
            log.debug("Invoking /square endpoint with number '{}'", number);
            return Math.pow(number, 2);
        }
    ```
   
# Build and run docker image
Locate (cd) at the root folder of the project: `backend-api`

## Build docker image
```dockerfile
docker build -t backend-api . -f src/main/docker/Dockerfile
```

## Run docker image
```dockerfile
docker run -p8080:8080 -d backend-api
```