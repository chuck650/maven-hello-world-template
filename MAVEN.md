# Simple Maven Guide for Students

Maven is a popular tool for building and managing Java projects. This guide will help you get started with Maven, especially if you are new to Java or build tools.

---

## What is Maven?

- **Maven** automates compiling, testing, and packaging your Java code.
- It manages dependencies (libraries your code needs) for you.
- It uses a configuration file called `pom.xml` to describe your project.

---


## Maven Lifecycle and Typical Workflow

Maven organizes your project build into phases called the "lifecycle." Each phase represents a step in building, testing, and packaging your code. The most common phases are:

- **compile**: Compiles your Java source code.
- **test**: Runs your unit tests.
- **package**: Bundles your code into a distributable format (like a `.jar` file).
- **install**: Installs the built `.jar` into your local Maven repository (for use by other projects).
- **clean**: Removes files from previous builds.

You run these phases with commands like `mvn compile`, `mvn test`, or `mvn package`. Maven will automatically run all earlier phases if you start at a later one (for example, `mvn package` will also compile and test your code first).

### Typical Development Lifecycle

1. **Write or edit your Java code in `src/main/java`.**
2. **Compile your code:**

   ```sh
   mvn compile
   ```

3. **Write and run tests in `src/test/java`:**

   ```sh
   mvn test
   ```

4. **Package your project for distribution:**

   ```sh
   mvn package
   ```

   This creates a `.jar` file in the `dist/` folder and generates documentation.

5. **(Optional) Clean up build files:**

   ```sh
   mvn clean
   ```

This cycle repeats as you develop, test, and improve your project.

| Command                | What it does                                 |
|------------------------|----------------------------------------------|
| `mvn compile`          | Compiles your Java source code               |
| `mvn test`             | Runs your unit tests                         |
| `mvn package`          | Builds a `.jar` file and generates docs      |
| `mvn exec:java`        | Runs your Java application                   |
| `mvn clean`            | Deletes files created by previous builds     |
| `mvn javadoc:javadoc`  | Generates HTML documentation (Javadoc)      |

---

## How to Use Maven in This Project

1. **Open a terminal in the project folder.**
2. **Build the project:**

   ```sh
   mvn compile
   ```

3. **Run the application:**

   ```sh
   mvn exec:java
   ```

4. **Run the tests:**

   ```sh
   mvn test
   ```

5. **Package the project (create a JAR and docs):**

   ```sh
   mvn package
   ```

---


---

## Generating Javadoc with Maven

Maven can automatically generate HTML documentation (Javadoc) from your code comments.

- To generate Javadoc only:
   ```sh
   mvn javadoc:javadoc
   ```
   The documentation will appear in the `docs/apidocs/` folder.

- To generate Javadoc as part of packaging:
   ```sh
   mvn package
   ```
   This will also build your `.jar` file and place the Javadoc in `docs/apidocs/`.

You can open `docs/apidocs/index.html` in your browser to view the generated documentation.

---

## Tips and Notes

- You must use the full command for plugins, like `mvn exec:java` (not just `mvn exec`).
- If you change your code, run `mvn compile` or `mvn package` again to update the build.
- The first time you run Maven, it may take longer as it downloads dependencies.
- All configuration is in `pom.xml`. See CONFIG.md for details.

---

## More Resources

- [Maven in 5 Minutes (official)](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
- [VS Code Java Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

---

If you get stuck, ask your instructor or check the documentation above. Maven helps everyone on your team build and run the project the same way!
