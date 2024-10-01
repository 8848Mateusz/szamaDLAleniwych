# szamaDLAleniwych - final project for the course
## Description
szamaDLAleniwych is a project written in Java. It was created as part of the Java Developer course at CodersLab. The main goal is to allow users to find recipes based on provided ingredients or by searching for a specific dish name. The project integrates with the external Spoonacular API and includes full user management functionality.
## Functionality
- Find recipes based on three provided ingredients
- Search for recipes by dish name
- User management
- Integration with the Spoonacular API
## System Requirements
- Java 11 or later
- Maven 3.6.0 or later
- MySQL 8.0 or later
- IntelliJ IDEA or other development environment
## Installation and Setup
### 1. Clone the Repository
Create a fork of the repository. Clone the repository to your computer using the following command:
```bash
 git clone https://github.com/8848Mateusz/szamaDLAleniwych.git
```
Make sure to use the address of your own fork, which should look like:
``` bash
https://github.com/your-username/repository-address
```
Import the project as a Maven project following these steps:
- In IntelliJ, go to: File → New → Project from Existing Sources...
- Select the location of the cloned project directory and confirm.
- In the new window, choose Import project from external model and select Maven.
- Click Finish.
### 2. Database Configuration
Create an empty MySQL database with the name szamaDLAleniwych.
### 3. API Key Configuration
Register at Spoonacular and obtain an API key. Then, in the file `src/main/resources/application.properties`, add your API key on line `13`.
### 4. Maven Dependencies
Ensure that all required dependencies are defined in the pom.xml file. You will need the following dependencies:
``` xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.3.0</version>
    <relativePath/>
</parent>

<packaging>war</packaging>

<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.apache.tomcat.embed</groupId>
        <artifactId>tomcat-embed-jasper</artifactId>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.hibernate.validator</groupId>
        <artifactId>hibernate-validator</artifactId>
        <version>6.0.23.Final</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.security</groupId>
        <artifactId>spring-security-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>jakarta.servlet.jsp.jstl</groupId>
        <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
        <version>3.0.0</version>
    </dependency>
    <dependency>
        <groupId>org.glassfish.web</groupId>
        <artifactId>jakarta.servlet.jsp.jstl</artifactId>
        <version>2.0.0</version>
    </dependency>
</dependencies>
```
## Technologies Used
  - Spring Boot
  - Spring Security
  - Spoonacular API
  - MySQL
## Author
Mateusz Maciejewski

## License
This project is licensed under the MIT License.
  
