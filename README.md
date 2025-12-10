# Maven Hello World Template

[![Java CI](https://github.com/chuck650/maven-hello-world-template/actions/workflows/java-ci.yml/badge.svg?branch=main)](https://github.com/chuck650/maven-hello-world-template/actions/workflows/java-ci.yml)

This is a simple Maven-based Java project designed for use as a GitHub Classroom template. It includes a basic "Hello World" application, Javadoc comments, and is compatible with Visual Studio Code.

## 📦 Project Structure

.
├── hello-world.code-workspace
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── example
│   │               └── helloworld
│   │                   └── App.java
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── helloworld
│                       └── AppTest.java
└── target
    ├── classes
    │   └── com
    │       └── example
    │           └── helloworld
    │               └── App.class
    └── test-classes
        └── com
            └── example
                └── helloworld
                    └── AppTest.class

## 🚀 Getting Started

### Prerequisites

- Java JDK 21
- Apache Maven
- Visual Studio Code
  - Java Extension Pack
  - Maven for Java

### Build the Project

```bash
mvn compile
```

### Run the Application

```bash
mvn exec:java -Dexec.mainClass="edu.pstcc.chnelson.helloworld.App"
```

### Run Tests

```bash
mvn test
```

### Generate Javadoc

```bash
mvn javadoc:javadoc
```

The documentation will be generated in target/site/apidocs.

### VS Code Setup

Recommended extensions:

```json
{
  "recommendations": [
    "vscjava.vscode-java-pack",
    "vscjava.vscode-maven"
  ]
}
```

Place this in .vscode/extensions.json to help students install the right tools.

### License

This project is intended for educational use.

### `.gitignore`

```gitignore
# Maven target directory
target/

# Logs
*.log

# Compiled class files
*.class

# VS Code settings
.vscode/

# IDE files
*.iml
.idea/
*.ipr
*.iws

# OS-specific files
.DS_Store
Thumbs.db
```
## Running with Maven

To avoid having to specify the main class entry point each time, configure Maven's pom.xml and set the entrypoint for the exec plugin by adding this to the plugins section.

```xml
<plugin>
  <groupId>org.codehaus.mojo</groupId>
  <artifactId>exec-maven-plugin</artifactId>
  <version>3.2.0</version> <!-- Check for the latest stable version if needed -->
  <configuration>
    <!-- 
      SET YOUR FULLY QUALIFIED MAIN CLASS HERE 
      (e.g., edu.pstcc.citc.App or com.example.DataViewer) 
    -->
    <mainClass>edu.pstcc.citc.App</mainClass>
  </configuration>
</plugin>
```

Otherwise, you will have to specify it each time you execute the application with maven like this.

```sh
mvn exec:java -Dexec.mainClass="edu.pstcc.citc.App"
```

## Running directly with java

```sh
java -cp target/classes edu.pstcc.citc.App
```
