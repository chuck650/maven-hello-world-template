# Configuration Guide for Maven Project (CONFIG.md)

This guide explains the key sections of the `pom.xml` file for this project and why using Maven helps standardize the build process for all developers.

---

## What is Maven?

Maven is a build automation tool for Java projects. It helps manage dependencies (libraries your code needs), compiles your code, runs tests, and packages your application. By using Maven, every developer working on this project can build and run the code the same way, regardless of their computer setup.

---

## Key Sections of `pom.xml`

### 1. Project Coordinates
```xml
<groupId>edu.pstcc.citc.App</groupId>
<artifactId>hello-world</artifactId>
<version>1.0-SNAPSHOT</version>
```
- **groupId**: Like a namespace, usually your organization or school.
- **artifactId**: The name of your project.
- **version**: The version of your project.

### 2. Properties
```xml
<properties>
  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
  <maven.compiler.source>21</maven.compiler.source>
  <maven.compiler.target>21</maven.compiler.target>
</properties>
```
- Sets the Java version (21) and file encoding (UTF-8) for consistency.

### 3. Dependencies
```xml
<dependencies>
  <dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```
- Lists libraries your project needs. Here, JUnit is used for testing.

### 4. Build Plugins
Plugins add extra features to the build process. Key plugins used:

#### a. Compiler Plugin
```xml
<plugin>
  <artifactId>maven-compiler-plugin</artifactId>
  ...
</plugin>
```
- Compiles your Java code using the version specified in properties.

#### b. Surefire Plugin
```xml
<plugin>
  <artifactId>maven-surefire-plugin</artifactId>
  ...
</plugin>
```
- Runs your unit tests automatically.

#### c. Exec Plugin
```xml
<plugin>
  <artifactId>exec-maven-plugin</artifactId>
  <configuration>
    <mainClass>edu.pstcc.citc.App</mainClass>
  </configuration>
</plugin>
```
- Lets you run your Java program with a simple command: `mvn exec:java`.
- The `mainClass` property tells Maven which class contains your `public static void main(String[] args)` method.

#### d. Jar Plugin
```xml
<plugin>
  <artifactId>maven-jar-plugin</artifactId>
  ...
</plugin>
```
- Packages your code into a `.jar` file for distribution.

#### e. Javadoc Plugin
```xml
<plugin>
  <artifactId>maven-javadoc-plugin</artifactId>
  ...
</plugin>
```
- Generates documentation from your code comments.

---

## Why Use Maven?
- **Consistency:** Everyone builds and runs the project the same way.
- **Dependency Management:** Maven downloads libraries for you.
- **Automation:** Compile, test, and package with simple commands.
- **Documentation:** Generates API docs automatically.

---

## Summary
- The `pom.xml` file is the blueprint for building your project.
- Maven ensures all developers have the same setup and process.
- Each section of the `pom.xml` has a specific purpose to help automate and standardize your Java project.

If you are new to Java or XML, don't worry! The structure is designed to be readable and reusable. As you gain experience, you'll be able to customize it for your own projects.
