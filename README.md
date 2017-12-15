# Random Number Generator And Sorter Application

## Requirement

The requirement is to generate random number based on the user input (count) and sort them in ascending order using a sorting algorithm. The GUI should be used to capture the user input and should display the below details.

 - Generated Random Number
 - Sorted Random Number
 - No of position changed (swap count for sorting)
 - Time taken to sort the random numbers
 
 Also, the application should persist the data even after restart.
 
## Solution Proposed

Below are the technology stack used to achieve the solution. 

### Java 8 
  For Lambda Expressions and Stream APIs
### Spring boot
  To configure Spring MVC, embedded Servlet Container (used Tomcat 8.5 for this application) and H2 Database
### Spring-MVC
  To create loosely coupled web application
### Spring-Data-JPA
  To use the in-build JpaRepository to persist and retrieve data through query methods
### H2 Database
  To persist the data even after restart, I have the in-memory database
### Maven
To build and package the application to JAR

## Steps to execute the Application
 - Make sure Java 8 is installed on your PC
 - Clone the source code from https://github.com/rajaasthana/RandomNumberGeneratorAndSorter
 - Import as Maven Project in Eclipse or any supported IDE 
 - Locate **Application.java** under com.randomnumbersorter package and run it as Java Application
 - Once the server is started, launch the application using http://localhost:8080/home/ in any browser
 - You can now generate and sort random numbers
