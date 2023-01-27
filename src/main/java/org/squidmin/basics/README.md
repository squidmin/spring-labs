<details>
<summary>Terminology</summary>

Learn the different terms used in the world of Spring.

The following topics are covered:
- Beans
- Autowiring
- Dependency injection
- Inversion of Control
- IoC container
- Bean factory
- Application context

### Beans

Beans are the objects of classes that are managed by Spring. Traditionally, objects used to create their own dependencies, but Spring manages all the dependencies of an object and instantiates the object after injecting the required dependencies. The `@Component` annotation is the most common method of defining beans.

```java
@Component
public class Vehicle {

}
```

### Autowiring

The process of identifying a dependency, looking for a match, and then populating the dependency is called autowiring. The `@Autowired` annotation tells Spring to find and inject a collaborating bean into another. If more than one bean of the same type is available, Spring throws an error. In the following scenario, two beans of type `Operator` are detected by Spring:

```java
@Component
class Arithmetic() {
    @Autowired
    private Operator operator;
    //...
}

@Component
class Addition implements Operator {

}

@Component
class Subtraction implements Operator {

}
```

Spring will not know which bean to inject in the `Arithmetic` bean unless the developer explicitly specifies it.

### Dependency injection

Dependency injection is the process by which Spring looks up the beans that are needed for a particular bean to function and injects them as a dependency. Spring can perform dependency injection by using a **constructor** or by using a **setter method**.

### Inversion of Control

Traditionally, the class which needed the dependency created an instance of the dependency. The class decided when to create the dependency and how to create it. For example, `Engine` class is a dependency of `Vehicle` class, which creates its object:

```java
class Vehicle {
    private Engine engine = new Engine();
    //...
}
```

Spring takes this responsibility from the class and creates the object itself. The developer simply mentions the dependency and the framework takes care of the rest.

```java
class Vehicle {
    private Engine engine;
    //...
}
```

Thus, control moves from the component that needs the dependency to the framework. The framework takes the responsibility for finding out the dependencies of a component, ensuring their availability and injecting them in the component. This process is called **Inversion of Control**.

![01.png](img/01.png)

### IoC container

An **IoC container** is a framework that provides the **Inversion of Control** functionality.

The IoC container manages the beans. For the above-mentioned example, it creates an instance of the `Engine` class, then creates an instance of `Vehicle` class, and then injects the `Engine` object as a dependency into the `Vehicle` object.

```java
class Vehicle {
    private Engine engine;
    //...   
}
```

**IoC container** is a generic term. It is not framework-specific. Spring offers two implementations of the **IoC container**:
1. Bean factory
2. Application context

![02.png](img/02.png)

Both of them are interfaces that have different implementations available. Application context is the typical IoC container in the context of Spring. Spring recommends using it unless there is a memory concern, like in a mobile device. If available memory is low, bean factory should be used.

### Bean factory

The basic version of the Spring IoC container is **bean factory**. It is the legacy IoC container and provides basic management for beans and wiring of dependencies. In Spring, bean factory still exists to provide backward compatibility.

### Application context

**Application context** adds more features to the bean factory that are typically needed by an enterprise application. It is the most important part of the Spring framework. All the core logic of Spring happens here. It includes basic management of beans and wiring of dependencies as provided by the bean factory. Additional features in application context include **Spring AOP** features, **internationalization**, **web application context**, etc.

</details>


<details>
<summary>Spring Architecture</summary>

Discussion of the modular architecture of Spring and popular Spring projects.

The following topics are covered:
- Spring modules
  - Data access / integration
  - Web (MVC / remoting)
  - Test
  - AOP
- Spring projects

Spring is not one big framework. It is broken down into modules. This can be seen in the Maven Dependencies folder, where there are a lot of JAR files instead of just one big JAR.

![03.png](img/03.png)

Spring is built in a modular way and this enables some modules to be used without using the whole framework. It also makes integration with other frameworks easy. The developer can choose which module to use and discard ones that are not required.

### Spring modules

The modules of Spring architecture, grouped together in layers, are shown below:

![04.png](img/04.png)

The Core Container contains the following modules: **Beans**, **Core**, **Context**, and **Spring Expression Language (SpEL)**. These modules provide fundamental functionality of the Spring framework, like **Inversion of Control (IoC)**, **dependency injection**, **internationalization** as well as support for querying the object at run time.

### Data access / integration

Spring has very good integration with data and integration layers, and provides support to interact with databases. It contains modules like **JDBC**, **ORM**, **OXM**, **JMS**, and **Transactions**.
- The JDBC (Java Database Connectivity) module allows the data layer to interact with databases to get data or store data, or to interact with other systems without the need of cumbersome JDBC coding. Spring JDBC is very straightforward as compared to plain JDBC and makes the code very short.
- The ORM (Object Relational Mapping) module provides support to integrate with ORM frameworks including Hibernate and JPA.
- The JMS (Java Messaging Service) module talks to other applications through the queue to produce and consume messages.
- The OXM (object-XML mapping) module makes the object-to-XML transformation easy by providing useful features.
- The transaction management module provides support for successful rollback in case a transaction fails.

### Web (MVC / remoting)

It contains the **Web**, **Servlets**, **Portlets**, and **Sockets** modules to support the creation of a web application. Spring offers a web framework of its own called **Spring MVC**.

### Test

The **Test** module handles the cross-cutting concern of unit testing. The **Spring Test** framework supports testing with **JUnit**, **TestNG**, as well as creating mock objects for testing the code in isolation.

### AOP

The **AOP** module provides **Aspect Oriented Programming** functionality like **method interception** and **pointcuts** as well as **security** and **logging** features. Spring has its own module called **Spring AOP** that offers basic, aspect-oriented programming functionality. Advanced AOP functionality can be implemented through integration with **AspectJ**. AOP features cross-cutting concerns from business logic.

### Spring projects

Spring also provides solutions to different enterprise application problems through **Spring projects**. Some of them are discussed below:

![05.png](img/05.png)

**Spring Boot** is used to develop microservices. It makes developing applications easy through features like startup projects, auto configuration, and actuator. Spring Boot has gained massive popularity since it was first released in 2014.

**Spring Cloud** allows the development of cloud native applications that can be dynamically configured and deployed. It provides functionality for handling common patterns in distributed systems.

**Spring Data** provides consistent access to SQL and NoSQL databases.

**Spring Integration** implements the patterns outlined by the book Enterprise Application Integration Patterns. It allows enterprise applications to be connected easily through messaging and declarative adapters.

**Spring Batch** provides functionality to handle large volumes of data like ability to restart, ability to read from and write to different systems, chunk processing, parallel processing, and transaction management.

**Spring Security** provides security solutions for different applications be it a web application or a REST service. It also provides authentication and authorization features.

**Spring Session** manages session information and makes it easier to share session data between services in the cloud regardless of the platform/container. It also supports multiple sessions in a single browser instance.

**Spring Mobile** offers device detection and progressive rendering options that make mobile web application development easy.

**Spring Android** facilitates the development of Android applications.

</details>


<details>
<summary>Reasons for Sustained Popularity</summary>

Discussion of some factors of Spring that led to its widespread adoption and sustained popularity.

The following topics are covered:
- Flexibility and integration with other frameworks
- Removes plumbing code
- Promotes testable code
- Staying up-to-date

### Flexibility and integration with other frameworks

Spring has a very flexible architecture. Spring modules are not dependent on one another and offer a developer the freedom to pick and choose according to the requirements of the application. Spring projects are designed with very specific purposes in mind.

Spring offers integration with a large number of frameworks. For example, even though Spring offers its own MVC framework, SpringMVC, it also offers integration with other MVC frameworks. Using Spring does not decrease the developer's options.

### Removes plumbing code

Plumbing code not only makes programming longer but also reduces the readability of code. For example, in JDBC programming, a lot of code is required for simple functionality. Connection establishment and exception handling span many lines of code.

Spring removes plumbing code and lets the programmer focus on the application logic. The amount of code written in Spring is negligible. No exception handling code is required because Spring makes all its exceptions unchecked.

### Promotes testable code

Spring framework enables writing testable code. It offers good integration with JUnit and Mockito frameworks, which lets us write unit tests quickly and easily. The core feature of Spring is dependency injection and if it is used properly, writing unit tests for the code becomes very easy.

### Staying up-to-date

Spring is able to stay current and adapt to changes in development. For example, microservices and cloud services have evolved in the last decade. Spring has come up with projects to keep up with the trend, like Spring Boot, which helps with designing microservices.

</details>


<details>
<summary>Creating a project</summary>

There are different ways of creating a Spring project:
1. Follow the **Spring Initializr** instructions: https://start.spring.io/
   - Select the dependencies and create a basic project structure with a **Maven** or **Gradle** build specification. This project is available for download in the form of a zip file to be used in a variety of IDEs like **Eclipse**, **IntelliJ**, etc.
2. Use the **Spring Initializr** plugin for IntelliJ.
3. If using **Maven** for dependency management and you know the dependencies your project will need: <a href="https://search.maven.org/">Search **Maven Central**</a> for the dependencies your project requires. 
4. Refer to the `pom.xml` of this project and copy any dependencies your project requires.

The highlight of Spring Boot is its auto-configuration feature whereby it automatically includes all the dependencies of a project based on property files and JAR classpaths. Spring Boot is basically the Spring framework along with embedded servers. Spring Boot removes the need for XML configuration.

![06.png](img/06.png)

<blockquote>Note: Given the simplicity and ease that Spring Boot provides, we will use it to create our first Spring project.</blockquote>

This project will use a **Maven** build configuration, with **Spring Boot v2.4.3** at the time of this writing.

Any version which is greater than **Spring Boot 2.0** should work for the examples in this project. It is better to avoid `SNAPSHOT` versions as they are alpha or beta versions.

Specify a **GroupId** and **ArtifactId** for the project. This project used the IntelliJ IDE's **New Project** prompts to create these.

![07.png](img/07.png)

Spring Initializr, by default, creates Spring as one of the dependencies of the project, so we do not need to explicitly specify any dependency. Later in this course, we will create projects with dependencies like **Web**, **AOP**, **JDBC**, **JPA**, etc.

![08.png](img/08.png)

When the **Generate** button on the form is clicked, the Initializer creates a zip file that is downloaded by the browser. Unzip this file and place it in a folder on the hard drive.

To import this project in Eclipse, choose **File => Import => Existing Maven Projects**. Search for **Maven** in the search bar if the option isn't visible. Browse to the folder on the hard drive where the unzipped Spring Boot project is placed. The `pom.xml` file can be seen. Select the file and click **Finish** to import the project.

![09.png](img/09.png)

All the dependencies needed to set up the project will be downloaded via the IDE. When the import process finishes, the following hierarchy can be seen:
- `src/main/java` where the Java code will be written. Right now, it contains the project file `<YourAppName>Application.java`
- `src/main/resources` where the application properties are written.
- `src/test/java` where the tests will be written.

![10.png](img/10.png)

The `pom.xml` file contains the project metadata information and lists the dependencies.

If using **Eclipse**, The Maven Dependencies folder contains the jar files of all the dependencies. If you used Initializr, Spring may have automatically added the dependencies `spring-boot-starter`, `spring-context`, `spring-beans`, and `spring-core`, among other dependencies.

![11.png](img/11.png)

When the project dependencies are finished downloading, they can be found in the **External Libraries** folder, if using **IntelliJ**.

The `org.squidmin` package contains the main application, `Application.java`, which contains the `main` method. The `main` method of the `Application` class can be used to execute the Spring Boot application.

In IntelliJ, an easy way to run the main application is to right-click on the `Application.java` file in the **Project View** and select **Run 'Application.main()'**.

![12.png](img/12.png)

This will launch a simple *Spring context*. The program successfully runs and prints some text on the console.

![13.png](img/13.png)

</details>


<details>
<summary>Dependency</summary>

This section discusses the concept of dependency by setting up a simple example using a Spring Boot application.

The following topics are covered:
- Tight coupling

In this section, we will build a movie recommender system and add some logic to it.

A recommender system is a system that filters some entities based on the user's history. Recommender systems also rank these items based on user preferences. The system works by taking an input and then finding items similar to that input.

In this section, we will write the basic code for a movie recommender application. The application will take a movie and recommend other movies similar to it. There are various ways in which recommendations can be found. One method is content-based filtering in which item-to-item similarity is used as a basis for finding matches. So, for a movie like Finding Dory, the system will find movies of the same genre, like Happy Feet, Ice Age, Shark Tale, etc.

![14.png](img/14.png)

1. We will create sub-packages inside the `org.squidmin.basics.movierecommendersystem` package to keep the files for every section separate. This is an optional step. Right-click on the base package, mouse-hover **New =>**, and select **Package**. Then provide the name as `section1` and press **Enter** to create the sub-package.

![15.png](img/15.png)

![16.png](img/16.png)

![17.png](img/17.png)

The package for each section contains the `MovieRecommenderSystemApplication` class containing the main method. This file can simply be copied from the `org.squidmin.basics.movierecommendersystem` package to the newly created package.

![18.png](img/18.png)

2. We will create a class named `RecommenderImplementation` in the section1 sub-package.

![19.png](img/19.png)

![20.png](img/20.png)

The `RecommenderImplementation` class will have a method called `recommendMovies()`, which will find similar movies using a content-based filter and then return the results.

The `recommendMovies()` method takes a movie as input so the input parameter is of type String and returns a list of similar movies. Hence, the return type is String[]. Inside the method, we will use a filter to find similar movies and return the results.

```java
public class RecommenderImplementation {
    public String[] recommendMovies (String movie) {
        //use content based filter to find similar movies
        //return the results
        return new String[] {"M1", "M2", "M3"};
    }
}
```

We need to hard code the results returned by this method to avoid compile-time errors. The hard coded results will be removed in **step 5**.

Now, we will write the logic of the `recommendMovies()` method in the `RecommenderImplementation` class. As mentioned earlier, we will use a technique called content-based filtering to find movie recommendations. We can implement this technique as a separate class to keep the `recommendMovies()` method independent of the filter implementation.

We will create a new class `ContentBasedFilter` that has a method `getRecommendations()` implementing the logic of the content-based filter. The method returns a list of movies that are relevant to the input, taking into account the user's watch history as well as movies that are similar to the input. We will not make it complex at this step and ignore input arguments like the number of movies to recommend, user's watch history, and the user-movie matrix of ratings.

Our method will have just one input parameter, the movie name, of `String` type. All the steps in finding the relevant movies are performed in this method.

<blockquote>We have hardcoded the results. The <code>getRecommendations()</code> method returns three movies similar to the movie, “<i>Finding Dory</i>”.</blockquote>

```java
public class ContentBasedFilter {
    public String[] getRecommendations(String movie) {
        //logic of content based filter
        return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
    }
}
```

Now, we can use an object of the `ContentBasedFilter` class in the `RecommenderImplementation` class as follows:

Since the `getRecommendations()` method is returning a `String[]`, we can remove our hard-coded results and replace them with the actual ones returned by the method.

In the `MovieRecommenderSystemApplication` class, we will create an object of the `RecommenderImplementation` class and use it to find movie recommendations for the movie, *Finding Dory*, as follows:

```java
import java.util.Arrays;

public class MovieRecommenderSystemApplication {
    public static void main(String[] args) {
        RecommenderImplementation recommender = new RecommenderImplementation();    
        String[] result = recommender.recommendMovies("Finding Dory");
        System.out.println(Arrays.toString(result));
    }
}
```

To make the output readable, we use the `toString()` method after importing `java.util.Arrays`.

The code in the widget below, when executed, returns a list of movies hard-coded in the `ContentBasedFilter` class.

#### `MovieRecommenderSystem.java`

```java
package org.squidmin.basics.movierecommendersystem.section1;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MovieRecommenderSystemApplication {

	public static void main(String[] args) {
		
		//SpringApplication.run(MovieRecommenderSystemApplication.class, args);

		//create object of RecommenderImplementation class
		RecommenderImplementation recommender = new RecommenderImplementation();	
		
		//call method to get recommendations
		String[] result = recommender.recommendMovies("Finding Dory");
		
		//display results
		System.out.println(Arrays.toString(result));

	}

}
```

#### `RecommenderImplementation.java`

```java
package org.squidmin.basics.movierecommendersystem.lesson1;

public class RecommenderImplementation {

	public String [] recommendMovies (String movie) {
		
		//use content based filter to find similar movies
		
		ContentBasedFilter filter = new ContentBasedFilter();
		String[] results = filter.getRecommendations(movie);
	
		//return the results
        //return new String[] {"M1", "M2", "M3"};
		return results;
	}

}
```

#### `ContentBasedFilter.java`

```java
package org.squidmin.basics.movierecommendersystem.lesson1;

public class ContentBasedFilter {
	public String[] getRecommendations(String movie) {
		
		//implement logic of content based filter
		
		//return movie recommendations
		return new String[] {"Happy Feet", "Ice Age", "Shark Tale"};
	}
}
```

#### Output

```
[Happy Feet, Ice Age, Shark Tale]
```

### Tight coupling



</details>