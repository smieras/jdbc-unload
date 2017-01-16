#JDBC-unload

## Introduction and use case

This application aims to provide
 - an easy to configure, 
 - lightweight and
 - memory friendly 
 
approach to unload data to .csv files according to the RFC4180 standard from any SQL database using JDBC.

The general use case is the ability to extract data from a database without the need of an complex and heavy framework. 

The application takes an opinionated view on the format in which the data is extracted. It is kept as minimalistic as possible by cherry picking components from the spring framework to be able to extract data from a database. Nothing more, nothing less.

## How to configure

To configure the application the user must provide an application.yml. The below example can be found [here].(https://github.com/mierasmade/jdbc-unload/blob/master/src/main/resources/application.yml)

	spring:
	  datasource:
	    url: jdbc:mysql://localhost:3306/sakila?useSSL=false
	    username: root
	    password: helloworld
	    driver-class-name: com.mysql.jdbc.Driver
	
	output-dir: target/
	commit-interval: 10
	page-size: 10
	delimiter: "|"
	quote: "\""
	table-definitions:
	  - file-name: Actor.csv    
	    select-query: "SELECT actor_id, first_name, last_name"
	    from-query: "FROM Actor"
	    sort-column: actor_id
	    
**Datasource**  
  
The user must provide datasource credentials. 

Furthermore, depending on the database, it might be required to add a jdbc driver to the class path. One way to do this is by adding a driver as a dependency using maven. The current [POM](https://github.com/mierasmade/jdbc-unload/blob/master/pom.xml) file contains **only** a mysql driver and a hsqldb driver for test purposes. It is up to the user to add a driver corresponding to the actual database used.

	<!-- START:: production database drivers -->
	<dependency>
	   <groupId>mysql</groupId>
	   <artifactId>mysql-connector-java</artifactId>
	</dependency>      
	<!-- END:: production database drivers -->

**General application configuration**   
- The output directory will be created based on the relative path to which the jar is deployed. It assumes write permission.   
- The commit interval can be used to indicate how much rows should be kept in memory before writing them to a file.   
- The page size determines how many records are fetched per read from the database.   
- The delimiter is the separation character between columns.   
- The quote is the character used to surround the content of a column if a column contains the delimiter.   

**Specific application configuration**   

For **each** table the user wishes to unload, a set of four configurations are needed:
- The desired file name followed by the .csv extension.
- The select part of the prepared statement query.
- The from part of the prepared statement query.
- The column used to order by. 

## How to run

After setting up an application.yml and possibly adding the correct jdbc driver to the classpath, the application can be packaged using [maven](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html).

The application can be executed by running the jar. The application can be made aware of its configuration by pointing it in the right direction by using spring.config.location as an argument.

	java -jar jdbc-unload-1.0.0.jar --spring.config.location=yourlocation/application.yml

## References

- Spring Boot 1.4.3.RELEASE official [documentation](http://docs.spring.io/spring-boot/docs/1.4.3.RELEASE/reference/htmlsingle/)
- Accessing Relational Data using JDBC with Spring [guide](https://spring.io/guides/gs/relational-data-access/)
- Spring Batch [JdbcPagingItemReader](http://docs.spring.io/spring-batch/apidocs/org/springframework/batch/item/database/JdbcPagingItemReader.html)

	


