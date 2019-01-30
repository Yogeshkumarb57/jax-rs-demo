# REST APIs using JAX-RS, Jersey + Swagger Documentation
JAX-RS REST APIs using jersey as implementation, swagger for documentation

<h3>Required Dependencies :</h3>

    ...
    ...
    <dependencies>
      <dependency>
            <groupId>javax.ws.rs</groupId>
            <artifactId>javax.ws.rs-api</artifactId>
            <version>2.0</version>
        </dependency>
        <dependency>
            <groupId>org.glassfish.jersey.containers</groupId>
            <artifactId>jersey-container-servlet</artifactId>
            <version>2.25.1</version>
        </dependency>

        <!-- for data exchange format -->
        <dependency>
            <groupId>org.glassfish.jersey.media</groupId>
            <artifactId>jersey-media-json-jackson</artifactId>
            <version>2.25</version>
        </dependency>

        <dependency>
            <groupId>io.swagger</groupId>
            <artifactId>swagger-jersey2-jaxrs</artifactId>
            <version>1.5.13</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
            <scope>provided</scope>
        </dependency>
    </dependencies>

<h3>Build Information :</h3>
      
    ...
    ...
    <packaging>war</packaging>
    ...
    ...
    <build>
        <finalName>jax-rs-demo</finalName>
        <sourceDirectory>src/main/java</sourceDirectory>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
            </resource>
        </resources>
        <plugins>
            <plugin>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.5.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>

            <!-- Embedded Tomcat Server plugin-->
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.2</version>
                <configuration>
                    <port>9000</port>
                    <path>/</path>
                </configuration>
            </plugin>
        </plugins>
    </build>
    ...

<h3>Run Application :</h3>

--> Build applicaton from project root directory : <b>mvn clean install</b>

--> Start application from project root directory : 
<b>mvn tomcat7:run</b>


<h3>Test Application :</H3>

Hit the following urls

--> APIs available on http://localhost:9000/rest --- rest is a base path for apis

	Products API --> http://localhost:9000/rest/products

--> http://localhost:9000/rest/swagger.json --- for swagger json

--> http://localhost:9000/swagger-ui.html --- for swagger ui 


<h3>Add Swagger UI</h3>

	Swagger ui files added separately from "https://github.com/swagger-api/swagger-ui/tree/master/dist" into directory "/src/main/webapp"
	
<b>Update SwaggerUIBundle({url: ${swagge_json_url} ...}) to swagger json url</b>

SwaggerUIBundle({
        url: location.protocol + "//" + location.hostname + (location.port && ":" + location.port)+ "/rest/swagger.json",
       ...})

