# ktor-starter

A sample Ktor api project running as an application inside [Docker](https://www.docker.com/).

## Running

To build and run this application with Docker, execute the following commands:

```bash
./gradlew :docker:installDist
docker build -t ktor-starter .
docker run -p 8080:8080 ktor-starter
```
 
Then, navigate to 
[http://localhost:8080/ping](http://localhost:8080/ping)
[http://localhost:8080/order](http://localhost:8080/order)
[http://localhost:8080/order/2020-04-06-01](http://localhost:8080/order/2020-04-06-01)
[http://localhost:8080/order/2020-04-06-01/total](http://localhost:8080/order/2020-04-06-01/total)
to see the sample api json response.
