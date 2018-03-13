# Wit-Neptune
RESTful API demo with `Spring Boot`.

1. You need to install `Java 1.8.0 or above, Maven 3.2.1 or above, MYSQL` first.<br/>

2. [Wit-Neptune-Tree](https://github.com/witpool/Wit-Neptune/blob/master/Wit-Neptune-Tree.txt)<br/>
`# ls` <br/>
`pom.xml  wit-common  wit-persist  wit-rest  wit-service` <br/>

3. Update the below configurations with your real database account to `wit-rest/src/main/resources/application.yml`<br/>
`username: root`<br/>
`password: 123456`<br/>

4. Package `wit-neptune` with `maven` tools.<br/>
`# mvn clean install`<br/>
`# ls wit-rest/target/wit-rest-1.0.jar`<br/>
`wit-rest/target/wit-rest-1.0.jar`<br/>

5. Start Spring Boot application.<br/>
`java -jar wit-rest/target/wit-rest-1.0.jar`<br/>

6. UT by [Wisdom RESTClient](https://github.com/Wisdom-Projects/rest-client/blob/master/tools/restclient-1.2.jar)
, import testing [case file.](https://github.com/witpool/Wit-Neptune/blob/master/Wit-Neptune-Cases.json)
![image](https://github.com/witpool/Wit-Neptune/blob/master/Wit-RESTClient.png)<br/>
More about the usages of the tool, please visit [Wisdom RESTClient](https://github.com/Wisdom-Projects/rest-client).<br/>

