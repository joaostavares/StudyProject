<div>
  <p>
    <img src= "https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" alt="Spring"/>
    <img src= "https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white" alt="Java"/>
  </p>
</div>

# Banking API

A simple Spring Boot project of a simple banking api <br>

Project done during the internship program, which tends to receive evolutions later <br>

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
* Postman Api Platform *( Just to test the requests, another one of the kind can be used. )*
<br> <br>


### Instructions: <br>

After cloning the project, access the project through the IDE and run it.

Import Postman presets on `Bank Project.postman_collection.json` and use pre-made requests.

<br> **OR** <br>

<br> Create a new account in H2 DataBase with a Post Request on `localhost:8080/contas`:

Example of the request body:

`{
    "saldo" : 100,
    "limiteSaqueDiario" : 10,
    "flagAtivo" : 0,
    "tipoConta" : 1,
    "dataCriacao" : "09-10-1998"
}`

<br> To make a deposit, make a Post Request at `localhost:8080/transacoes/deposito` :

Example of the request body:

`{
    "valor" : 400,
    "dataTransacao" : "09-10-1998",
    "idConta" : 1
}`

<br> To make a withdrawal, make a Post Request at `localhost:8080/transacoes/saque` :

`{
    "valor" : 50,
    "dataTransacao" : "09-10-1998",
    "idConta" : 1 
}`

<br>To check the balance, make a Get Request at:

`localhost:8080/contas/saldo/id` *( Change id to the id of the created account )*

<br>To block the account, make a Put Request at:

`localhost:8080/contas/travamento/id` *( Change id to the id of the created account )*

<br>To get the account statement, make a Get Request at:

`localhost:8080/trasacoes/extrato/id` *( Change id to the id of the created account )*

### Comments: <br>

You can check what is in the `testdb` database from `localhost:8080/h2` with username: `sa` and password: `password` and these properties can be changed in `resources/application. properties`
