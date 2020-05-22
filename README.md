# Basic Annotation example project
Overview of how IOC in spring, spring dependency injection and spring lifecycle with annotations 

### Autowiring Injection Types
1. Constructor Injection
2. Setter Injection
3. Field Injection - also covers @Qualifiers

### Annotations - Default Bean Names - The Special Case
In general, when using Annotations, for the default bean name, Spring uses the following rule.

If the annotation's value doesn't indicate a bean name, an appropriate name will be built based on the short name of the class (with the first letter lower-cased).

For example:
```
AccountInterest --> accountInterest
```

However, for the special case of when BOTH the first and second characters of the class name are upper case, then the name is NOT converted.

For the case of ACCOUNTInterest
```
ACCOUNTInterest --> ACCOUNTInterest
```
No conversion since the first two characters are upper case. Behind the scenes, Spring uses the **Java Beans Introspector** to generate the default bean name. Also, here's a link to the documentation.
- https://docs.oracle.com/javase/8/docs/api/java/beans/Introspector.html#decapitalize(java.lang.String)

As always, you can give explicity names to your beans.
```
@Component("foo")
```

### FAQ: How to inject properties file using Java annotations
1. Create a properties file to hold your properties. It will be a name value pair.  
New text file:  src/bank.properties
```
foo.name=HSBC
foo.branch=East London
```

2. Load the properties file in the XML config file.
File: applicationContext.xml
Add the following lines:
```
<context:property-placeholder location="classpath:bank.properties"/>
```
This should appear just after the **<context:component-scan .../>** line

3. Inject the properties values into your class
```
@Value("${foo.name}")
private String name;
    
@Value("${foo.branch}")
private String branch;
```

### Spring Bean Scopes
1. singleton: Creates the single shared instance of a bean. Default scope.
2. prototype: Creates the new bean instance for each container request.
3. request: Scoped to an HTTP web request. Only used for web apps.
4. session: Scoped to an HTTP web session. Only used for web apps.
5. global-session: Scoped to an global HTTP web session. Only used for web apps.

### Bean Lifecycle Methods/Hooks
* You can add custom code during bean initialization
  * Calling custom business logic methods
  * Setting up handles to resources (sockets, db, file etc)
  
* You can add custom code during bean destruction
  * Calling custom business logic methods
  * Setting up handles to resources (sockets, db, file etc)
  
#### Special Note about init and destroy Method Signatures
When using XML configuration,

* **Access modifier**
The method can have any access modifier (public, protected, private)

* **Return type**
The method can have any return type. However, "void' is most commonly used. If you give a return type just note that you will not be able to capture the return value. As a result, "void" is commonly used.

* **Method name**
The method can have any method name.

* **Arguments**
The method can not accept any arguments. The method should be no-arg.

There is a subtle point you need to be aware of with "prototype" scoped beans.
For "prototype" scoped beans, Spring does not call the destroy method.  Gasp! 

**QUESTION**: How can I create code to call the destroy method on prototype scope beans <br/>
**ANSWER**: You can destroy prototype beans but custom coding is required.<br/>

1. Create a custom bean processor. This bean processor will keep track of prototype scoped beans. During shutdown it will call the destroy() method on the prototype scoped beans.

2. The prototype scoped beans MUST implement the DisposableBean interface. This interface defines a "destroy()" method. This method should be used instead of the @PreDestroy annotation.

### Download spring jar files
https://repo.spring.io/release/org/springframework/spring/
1. Choose the latest stable release "*-dist.zip".
2. Copy all the jar files under lib folder from the downloaded zip.
3. Create a new folder name lib under your working directory.
4. Paste those jar files under lib folder.
5. Add classpath to your eclipse project.
6. Right click on your "Project" >> "Properties" >> "Java Build Path" >> "Libraries" tab >> Click "Add JARs" >> "Select all the JAR files from you lib folder" >> "Apply and Close".
7. Now there will be a "Referenced Libraries" folder which will have your all spring JAR files.
8. Done

### Run Project
Right click on your project >> Run As >> Java Application
