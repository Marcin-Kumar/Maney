# Maney
Personal finance tracking app

---

### Steps to Set Up the Java Project

1. **Clone the Git Repository**  
   Clone the repository from GitHub using the following command:
   ```bash
   git clone https://github.com/Marcin-Kumar/Maney.git
   ```
   This will create a local copy of the repository.

2. **Add a Java-Gradle Module**  
   Under the cloned repository, create a new Gradle module named `backend`. To do this, follow these steps:
   - Open the project in your IDE.
   - Navigate to `File > New > Module`.
   - Select "Gradle" as the module type and choose "Java" as the language.
   - Name the module `backend`.
   - Click "Finish" to generate the module files.

3. **Add `.gitignore` for JetBrains IDE**  
   Download and add a `.gitignore` file that suits JetBrains IDE (like IntelliJ IDEA) by following these steps:
   - Go to the URL: [JetBrains.gitignore](https://github.com/github/gitignore/blob/main/Global/JetBrains.gitignore).
   - Copy the content from the page.
   - In your project root, create a file named `.gitignore`.
   - Paste the copied content into this file and save it.

4. **Add Mockito to `build.gradle`**  
   To add Mockito (a popular Java testing framework) to your project, follow these steps:
   - Open the `build.gradle` file in the `backend` module.
   - Add the following dependency under the `dependencies` block:
     ```gradle
     testImplementation 'org.mockito:mockito-core:5.0.0'
     ```
   - Save the file and run the Gradle sync to apply changes:
     ```bash
     ./gradlew build
     ```

---
