# spring-labs

**Spring Framework** learning labs.

Created using:
- **IntelliJ IDEA 2022.2 (Community Edition)**
- **openjdk 11.0.17**


---


### Maven CLI wrapper

<details>
<summary>Add the Maven wrapper</summary>

```shell
mvn wrapper:wrapper
```

More info: https://maven.apache.org/wrapper/

</details>


### Run the jar

<details>
<summary>Run a Spring boot application with the "java -jar" command</summary>

```shell
java -jar target/myapplication-0.0.1-SNAPSHOT.jar
```

</details>


<details>
<summary>Run a Spring boot application using Gradle</summary>

```shell
gradle bootRun
```

</details>


<details>
<summary>Specify no profile</summary>

```shell
mvn spring-boot:run
```

</details>


<details>
<summary>Specify a profile</summary>

```shell
mvn spring-boot:run -Dspring-boot.run.profiles=local
```

</details>


---


### Run tests

<details>
<summary>Run all test cases</summary>

```shell
mvn test
```

</details>


<details>
<summary>Run a single test class</summary>

```shell
mvn -Dtest=ClassTest1 test
```

</details>


<details>
<summary>Run multiple test classes</summary>

```shell
mvn -Dtest=ClassTest1,ClassTest2 test
```

</details>


<details>
<summary>Run a single test method from a test class</summary>

```shell
mvn -Dtest=ClassTest1#methodName test
```

</details>


<details>
<summary>Run all test methods that match pattern `testHello*` from a test class</summary>

```shell
mvn -Dtest=ClassTest1#testHello* test
```

</details>


<details>
<summary>Run all test methods matching pattern `testHello*` and `testMagic*` from a test class</summary>

```shell
mvn -Dtest=ClassTest1#testHello*+testMagic* test
```

</details>
