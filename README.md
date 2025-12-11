# Maven Hello World Template

[![Java CI](https://github.com/chuck650/maven-hello-world-template/actions/workflows/java-ci.yml/badge.svg?branch=main)](https://github.com/chuck650/maven-hello-world-template/actions/workflows/java-ci.yml)

This is a simple Maven-based Java project designed for use as a GitHub Classroom template. It includes a basic "Hello World" application, Javadoc comments, and is compatible with Visual Studio Code.

For details on project configuration and Maven setup, see [CONFIG.md](CONFIG.md).

## 📦 Project Structure

The main folders and files:

- `src/main/java` — your main Java source code
- `src/test/java` — your test code
- `pom.xml` — Maven project configuration
- `README.md` — this file
- `CONFIG.md` — explains the Maven configuration
- `dist/` — created when you package the project (`mvn package`); contains the built `.jar` file and Javadoc `.jar`.
- `docs/` — created when you generate Javadoc (`mvn javadoc:javadoc` or `mvn package`); contains HTML API documentation in `docs/apidocs/`.

> The `dist/` and `docs/` folders are generated automatically by Maven. You do not need to create them manually.


## 🚀 Getting Started

### Prerequisites

- Java JDK 21
- Apache Maven
- Visual Studio Code (recommended)

### Common Commands

- Build the project:

  ```sh
  mvn compile
  ```

- Run the application:

  ```sh
  mvn exec:java
  ```

- Run tests:

  ```sh
  mvn test
  ```

For details on how the project is configured, see [CONFIG.md](CONFIG.md).

### Run Tests

```bash
mvn test
```

### Generate Javadoc

```bash
mvn javadoc:javadoc
```

The documentation will be generated in target/site/apidocs.

### Generate JAR Packages

```bash
mvn package
```

## Running directly with java

To bypass Maven and run the compiled application directly on the JRE, use this command.

```sh
java -cp target/classes edu.pstcc.citc.App
```

### License

This project is intended for educational use.
