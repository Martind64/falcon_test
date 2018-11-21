README
======

[Requirements](Requirements.md)

## TEPA - The Enterprise Palindrome Application

This application consists of an api and a view.

It is able to calculate the longest palindrome within a string  and save the string to the database while simultaneously displaying the posted data in a view.


#### Running the application

To run the application run the following commands

* ./mvnw clean package
* docker-compose up

#### View

The application contains a view that via a message broker is dynamically updated with the posted data. 

To see the view go to: ***localhost:8080***

#### The API

The API has a single endpoint where a POST and GET request is available

```
http://localhost:8080/palindrome
```

Post request example

```
{
   "content": "abrakadabra",
   "timestamp": "2018-10-09 00:12:12+0100"
}
```
The timestamp in the model is a custom timestamp containing a mix of the ISO 8601 and RFC 822 standard

ISO 8601 = 2018-10-09 00:12:12

RFC 822 = +0100

#### Test Suite
Tests are located under src/main/test

When writing tests use the following naming convention:
```
unitUnderTest_scenarioUnderTest_expectedBehaviour
```



