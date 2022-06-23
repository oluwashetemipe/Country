> COUNTRY SEARCH API DOCUMENTATION


## Prerequisites

Please install or have installed the following:

- [JDK17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Postgres](https://www.pgadmin.org/download/)
- [Junit5](https://junit.org/junit5/)

## Installation

1. Clone this repo
2. Set your environment variables:
   You can add your environment variables to the `applications-dev.properties` file
3. Then, make sure in your  application.properties `spring.profiles.active = dev`:

Then run:
```
run: mvn spring-boot:run
```

## Endpoints
1. Fetch A list Of All The Countries Loaded In The Database
```
GET:{{localhost}}country/api/list-all-countries/page={int}&size={int}
```