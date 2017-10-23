# POC TO SEARCH THE FILES BASED ON A GIVEN STRING
Springboot poc for searching the files with a string pattern

## Overview

  * [Software Used](#software-used)
  * [Project Structure](#project-structure)
  * [Running POC](#running-poc)
  * [Testing Application](#testing-application)
  

### Introduction

The main aim of this exercise is to ensure that the restful webservice is production ready and given an folder structure and the pattern to search it should do an recursive search on the directory and find all the files based on the pattern.
Once the files are found it would add the results in the ArrayList and pass the results as JSON objects to the browser that can be verified in the Postman.

## Software Used
- Eclipse & Embedded Maven
- PostMan
- Code Coverage Tools like : JACOCO
- Spring Boot 1.4.7
- Ubuntu  16.0.4 LTS ( 64 bit)
- Browsers : Chrome, Chromium, FireFox
- Test Coverage Tools : JUnit and MockMVC
- Logging Tools : SLF4j
- Front End : Boots Trap and Thymeleaf
- Java :8 ( 64 bit)

## Project Structure
- Project Name : RestSearchFiles
- Controller: The controllers are placed in the package ( searchfiles.controller)
- Model: The Model for the POC is places in ( searchfiles.model)
- View : The View( Index.html) is placed in the src/main/resources/templates, the tomcat embedded runs on the port 9596


## Running POC
- Download the zip or clone the Git repository.
- Unzip the zip file (if you downloaded one)
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open Eclipse 
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
   - Select the right project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application
- You are all Set

## Testing Application
- Open the Browser ( Prefer to open Firefox )
- type in http://localhost:9596/
- The index.html page opens up
- Enter the path and the phrase to search.
- Once the results are found you can see them as JSON objects.


