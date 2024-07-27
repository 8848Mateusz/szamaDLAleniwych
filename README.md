# szamaDLAleniwych - projekt zaliczeniowy kurs

## Opis projektu
szamaDLAleniwych to projekt napisany w języku Java. Powstał w celu zaliczenia kursu JAVA Developers w CodersLab. Jego głównym założeniem jest umożliwienie użytkownikom w znajdowaniu przepisów kulinarnych na podstawie podanych składników lub poprzez wpisanie konkretnej nazwy potrawy. Projekt korzysta z zewnętrznego API Spoonacular i ma pełną funkcjonalność obsługi użytkownika.

## Funkcjonalność
- Znajdowanie przepisów na podstawie podanych trzech składników
- Wyszukiwanie przepisów po nazwie potrawy
- Obsługa użytkownika
- Integracja z API Spoonacular

## Wymagania systemowe

- Java 11 lub nowsza
- Maven 3.6.0 lub nowszy
- MySQL 8.0 lub nowszy
- IntelliJ IDEA lub inne środowisko programistyczne

## Instalacja i uruchomienie

### 1. Klonowanie repozytorium

- git clone https://github.com/8848Mateusz/szamaDLAleniwych.git
- cd szamaDLAleniwych

### 2. Konfiguracja bazy danych

Utwórz pustą bazę danych MySQL o nazwie szamaDLAleniwych.

### 3. Konfiguracja klucza API

Zarejestruj się na Spoonacular i zdobądź klucz API. Następnie w pliku src/main/resources/application.properties w wierszu 13 dodaj swój klucz API.

### 4. Zależność Maven

Upewnij się, że wszystkie wymagane zależności są zdefiniowane w pliku pom.xml. Będziesz potrzebować następujących zależności:
-	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.3.0</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
 - <packaging>war</packaging>
 - <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
- <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>
- <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
- <dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
			<scope>provided</scope>
		</dependency>
- <dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
- <dependency>
			<groupId>org.hibernate.validator</groupId>
			<artifactId>hibernate-validator</artifactId>
			<version>6.0.23.Final</version>
		</dependency>
- <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
- <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
- <dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
- <dependency>
			<groupId>jakarta.servlet.jsp.jstl</groupId>
			<artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
			<version>3.0.0</version>
		</dependency>
 - <dependency>
			<groupId>org.glassfish.web</groupId>
			<artifactId>jakarta.servlet.jsp.jstl</artifactId>
			<version>2.0.0</version>
		</dependency>

  ## Używane technologie
  - Spring Boot
  - Spoonacular API
  - MySQL

## Autor
Mateusz Maciejewski

## Licencja
Projekt jest dostępny na licencji MIT.
  
