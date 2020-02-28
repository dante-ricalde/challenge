# challenge
docker build -f src/main/docker/Dockerfile.jvm -t currency-exchange/rates .
docker run -i --rm -p 8080:8080 currency-exchange/rates
https://www.iban.com/exchange-rates-api
