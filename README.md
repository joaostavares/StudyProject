<div>
  <p>
    <img src= "https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" alt="Spring"/>
    <img src= "https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white" alt="Java"/>
  </p>
</div>

# Banking API

A simple Spring Boot project of a simple banking api <br>

Project executed to study Spring Boot and the creation of API'S REST <br>

**Proposed activities:**<br>

* Implement path that performs the creation of an account;
* Implement path that performs deposit operation in an account;
* Implement a path that performs a balance inquiry operation in a given account;
* Implement a path that performs a withdrawal operation on an account;
* Implement path that performs the blocking of an account;
* Implement path that retrieves the transaction statement from an account;


## Requirements: <br>

* JDK 19
* Maven 3.8.1
* An IDE *( I used Intellij IDEA )*
* Postman Api Platform *( You can use Insomnia, or any other API testing tool)*
<br> <br>


### Instructions: <br>

After cloning the project, access the project through the IDE and run it.

Import Postman presets on `Bank Project.postman_collection.json` and use pre-made requests.<br>
<br>**OR**<br>
<br>Open `localhost:8080/swagger` to check all requests.<br><br>

#### Here's an example of a request to create and account:

<br>Post request to `localhost:8080/contas` with JSON body: <br>


```json
{
  "saldo" : 100,
  "limiteSaqueDiario" : 10,
  "flagAtivo" : 0,
  "tipoConta" : 1,
  "dataCriacao" : "09-10-1998"
}
```
### Additional Information: <br>

You can check what is in the `bankingdb` database while executing project, accessing `localhost:8080/h2` and using these properties: <br> <br>

| *Property* |        *Value*        |
|:----------:|:---------------------:|
|  JDBC URL  | jdbc:h2:mem:bankingdb |
|  Username  |         root          |
|  Password  |      PassCode98#      |


<br>All of these properties can be changed in `resources/application.properties` <br>

##### Database will run in memory, so it will be deleted when the project stop running. 
