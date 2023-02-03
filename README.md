<div>
  <p>
    <img src= "https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" alt="Spring"/>
    <img src= "https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white" alt="Java"/>
  </p>
</div>

# Banking API 

A simple Spring Boot project of a simple banking API <br>

Project executed to study Spring Boot and the creation of API'S REST <br>

**Proposed activities:**<br>

* Implement path that performs the creation of an account;
* Implement path that performs deposit operation in an account;
* Implement a path that performs a balance inquiry operation in a given account;
* Implement a path that performs a withdrawal operation on an account;
* Implement path that performs the blocking of an account;
* Implement path that retrieves the transaction statement from an account;

## Running through `.jar`

## Requirements: <br>

* JDK 17 (or newer)
* MySQL Server 8.0
* Postman Api Platform *( You can use Insomnia, or any other API testing tool)*
<br> <br>


## Execution: <br>

Download the latest `.jar` version from the releases tab and the latest Postman collection.

Run with the command: <br>
`java -jar BankingAPI-2.0.jar --spring.datasource.username=*YourMySQLUsername* --spring.datasource.password=*YourMySQLPassword*` <br>
( *Always changing username and password to the ones set in your MySQL Server* )

and use Postman presets to request **OR** open `localhost:8080/swagger` to see all requests


## Running through IDE

### Requirements: <br>

* JDK 17 (LTS)
* Maven 3.8.1
* MySQL Server 8.0
* An IDE *( I used Intellij IDEA Ultimate )*
* Postman Api Platform *( You can use Insomnia, or any other API testing tool)*
<br> <br>


### Execution: <br>

After cloning the project, access the project through the IDE.

Open the `application.properties` file located in `src/main/resources` and change the properties to your MySQL username and password *(and datasource url if you change MySQL default port.)*

**It is not necessary to create the database manually, if it does not exist, it will be created on the first run.** <br>


Import Postman presets on `Bank Project.postman_collection.json` and use pre-made requests.<br>
(Modify path in postman if you change default port)<br>
<br>**OR**<br>
<br>Open `localhost:8080/swagger` to check all possible requests.<br><br>

### Here's an example of a request to create an account:

<br>Post request to `localhost:8080/account` with JSON body: <br>


```json
{
  "balance" : 10,
  "accountType" : 1
}
```
