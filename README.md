
This is a Maven Project developed in a challenge between friends.
Here I'm using Java 11 with Spring Data REST to develop two microservices. 

Now I'm using an H2 In Memory database but I'll change to PostgreSQL in the next commit.

We have the following microservices working as modules inside an IntelliJ project:

1.) PersonManagement
Runs on port: 8081
H2 Console: http://localhost:8081/console/
Swagger: http://localhost:8082/swagger-ui.html
The jdbc url should be: jdbc:h2:mem:testdb
The user name is "sa" and there is no password

2.) HospitalManagement
Runs on port: 8082
H2 Console: http://localhost:8082/console/
Swagger: http://localhost:8082/swagger-ui.html 
The jdbc url should be: jdbc:h2:mem:testdb
The user name is "sa" and there is no password

Maybe you need to configure both modules at module settings that is accessible right click menu, then you can (re)add all libraries and Jar's and after access the menu 'Run -> Rebuild Project' before run successfully.

