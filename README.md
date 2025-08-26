# Maven Hello World Template

[![Java CI](https://github.com/chuck650/maven-hello-world-template/actions/workflowsjava-ci.yml)

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
mvn exec:java -Dexec.mainClass="com.example.helloworld.App"
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