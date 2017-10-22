# Simple Router

This project is a standard application written in "spring boot" whose main feature is to provide the list of all countries with their currencies

## Getting Started

clone the git repository with 
```
git clone https://github.com/berroto/sample-routing.git
```
If you don't have maven installed in your system you can use the maven wrapper provided in the repository.

Go the the root directory and just run
```
mvn package 
```

### Prerequisites

Since the application use the H2 in-memory database you do not need anything.
The application may run on a servlet container (eg. Tomcat) otherwise the war can run by itself since it contains an embedded tomcat

### Installing And Deployment

For the embedded tomcat you may run:
```
git clone https://github.com/berroto/sample-routing.git
mvn package 
java -jar target\sample-routing-<version>.war
```

The application listen on 8081 TCP port and application context is "sample-router".
So you can access to the API opening the browser to that link:
http://localhost:8081/sample-router/api/countries

for a standard servlet container you may deploy the sample-routing-<version>.war.original 

## Running the tests

The test automation is a feature not available yet

## API and Web Page

Two pages are available. 
* The REST api to get the list of the coutries on: /sample-router/api/countries
* A paginated web page on:  /sample-router/countries

The login and password are:
* username: admin password: admin!
* username: user password: user! (access to the web page only)

## Spring security

I used the spring security with the basic authentication.

## Built With

* [Spring boot](https://projects.spring.io/spring-boot/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Groovy](http://groovy-lang.org/) - Programming Language 
* [Thymeleaf](http://www.thymeleaf.org/) - Template Engine

## Versioning

I used [Git Flow](http://nvie.com/posts/a-successful-git-branching-model/) as a versioning model

## Authors

* **Roberto Valletta** - *Initial work*

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Future Step

* Add Spock as testing framework
* Add logout page to test the login - logout flow
* Add an update method to update the currencies
* Use spring security with in database roles / user / grants
* Add an homepage that list all the features
* Add a page with the changelog

