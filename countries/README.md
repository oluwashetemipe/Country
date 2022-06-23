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
3. Add `spring.profiles.active = dev` to your application.properties 

Then run:
```
run: mvn spring-boot:run
```

## Endpoints
1. Fetch A list Of All The Countries Loaded In The Database
```
GET:{{localhost}}country/api/list-all-countries?page={int}&size={int}
```
2. Fetch A list Of All The Countries By Partial Search
```
GET:{{localhost}}country/api/list-all-countries-by-search/page={int}&size={int}
```
3. Add a country to the Database using a Json Request format
```
GET:{{localhost}}country/api/add-country
```