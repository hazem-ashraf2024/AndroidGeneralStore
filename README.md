# AndroidGeneralStore - Mobile Automation Test Framework

Project Description
-------------------
AndroidGeneralStore is a mobile automation testing framework for Android applications built with Java, Appium, TestNG and Maven. The project follows common test-automation best practices such as the Page Object Model (POM), reusable screen utilities, and TestNG-based test execution.

Tech Stack
----------
- Java 25
- Appium (io.appium:java-client) 10.0.0
- TestNG 7.11.0
- Maven
- IntelliJ IDEA (recommended)

Project Structure
-----------------
Top-level project tree (relevant files and folders):

```
AndroidGeneralStore/
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       └── screenEngine
│   │           ├── BaseScreen.java
│   │           ├── ElementAction.java
│   │           └── Gestures.java
│   └── test
│       ├── java
│       │   └── engine
│       │       ├── BaseTestCase.java
│       │       ├── BaseTestScenario.java
│       │       └── BaseCartScreenTests.java
│       │   └── testCases
│       │       └── ...
│       └── resources
│           └── GeneralStore.apk
└── target/
```

Key folders
- `src/main/java/screenEngine` - Core screen and utility classes (base screen, element actions, gestures)
- `src/test/java/engine` - Base test classes that start/stop Appium and driver
- `src/test/resources` - Test resources (APK under test)
- `pom.xml` - Maven dependency and build configuration

Test structure
--------------
- Tests are implemented using TestNG and live under `src/test/java`.
- `BaseTestCase` uses TestNG `@BeforeMethod`/`@AfterMethod` to create a fresh Appium session per test method.
- `BaseTestScenario` uses TestNG `@BeforeClass`/`@AfterClass` to create a single Appium session per test class (scenario).
- Page objects / screen classes are under `src/main/java/screenEngine` and follow the POM-style separation of screen logic from tests.

Driver setup
------------
Driver and Appium server are created programmatically in the base test classes:
- `UiAutomator2Options` is used to configure the Android session (device name, app path, chromedriver settings).
- `AppiumDriverLocalService` with `AppiumServiceBuilder` starts a local Appium server bound to 127.0.0.1:4723.
- `AndroidDriver` is created with the service URL and options.

Configuration management
------------------------
- The current project hardcodes device identifiers, APK path, and Chromedriver path in `BaseTestCase` / `BaseTestScenario`.
- For a production-ready framework, externalize these values into a `config.properties` or `testng.xml` and load them at runtime.

Reporting tools
---------------
- No reporting framework (Allure, ReportNG, ExtentReports) was detected in the repository or `pom.xml`.
- TestNG's native reports will still be produced under `target/surefire-reports` when tests are run via Maven Surefire.

Dependency management
---------------------
Dependencies are declared in `pom.xml`. Extracted key dependencies:

- org.testng:testng:7.11.0 (scope: test)
- io.appium:java-client:10.0.0 (scope: compile)

(These were read directly from `pom.xml`.)

Platform support
----------------
- Android is supported via UiAutomator2 (UiAutomator2Options present).
- iOS support is not detected in the repository.

Parallel execution
------------------
- No explicit parallel execution configuration was detected in the repository (no Maven Surefire plugin configuration or TestNG `testng.xml` specifying parallel). TestNG supports parallelism, and it can be enabled by supplying a `testng.xml` or surefire plugin config.

CI/CD Integration
-----------------
- No CI/CD configuration files were detected (no `.github/workflows`, `Jenkinsfile`, GitLab CI file, etc.).

Best practices used
-------------------
- Separation of concerns via Page Object Model (screen classes under `screenEngine`).
- Reusable utilities placed in `screenEngine` (`ElementAction`, `Gestures`).
- TestNG is used for structuring tests and lifecycle management.
- FluentWait-based wait utilities used in `ElementAction` and base tests.

Known improvements / recommendations
-----------------------------------
- Externalize configuration (device name, app path, server host/port, chromedriver path) to a properties file or environment variables.
- Add a `testng.xml` to control suites, groups, and parallel execution.
- Add a reporting tool (Allure/Extent) for richer test reports.
- Add CI workflows (GitHub Actions) to run tests on PRs / merges.
- Add error handling and null checks to avoid NPEs during driver/session initialization.

How to run
----------
Prerequisites
- Java JDK 11+ installed and JAVA_HOME set
- Maven installed and on PATH
- Appium server binary installed globally (if not using the programmatic service), or ensure the Appium Java service can start on your machine
- Android emulator or device connected and accessible at the configured device name (current config uses `127.0.0.1:5554`)
- Chromedriver available if tests interact with webviews (the project currently uses chromedriver settings in `BaseTestCase`/`BaseTestScenario`)

Install / Build

```powershell
# From project root
mvn -q clean test-compile
```

Run all tests (via Maven)

```powershell
mvn -DskipTests=false test
```

Run a single TestNG test class

```powershell
mvn -Dtest=productListScreenTests.ProductListScreenTests test
```

Or run via TestNG XML (if you add `testng.xml`):

```powershell
mvn test -Dsurefire.suiteXmlFiles=testng.xml
```

Running from IntelliJ IDEA
- Import the project as a Maven project.
- Right-click a test class or method and choose "Run".
- Make sure the device/emulator and Appium server are available.

Test configuration
------------------
The framework currently configures capabilities and Appium service in code. Recommended improvements:
- Move configuration values to `src/test/resources/config.properties` or use environment variables.
- Add a utility loader class to read configuration and build `UiAutomator2Options` dynamically.

Parallel Execution
------------------
Parallel execution is not currently configured. To enable TestNG parallelism:
- Create a `testng.xml` and add parallel="methods" or parallel="classes" with a `thread-count`.
- Configure Maven Surefire plugin in `pom.xml` to pick up the `testng.xml` or pass the suite file on the command line.

Reporting
---------
- Native TestNG HTML reports will be generated by Maven Surefire in `target/surefire-reports`.
- To add richer reports, integrate Allure or ExtentReports and update the `pom.xml` with the relevant plugin/config.

CI/CD
-----
No CI configuration detected. Example GitHub Actions steps to consider:
- Set up Java and Android SDK
- Start an emulator or connect a device
- Install Appium
- Run `mvn test`

Contributing
------------
Contributions are welcome. Please follow these guidelines:
1. Fork the repository.
2. Create a new branch for your feature or bugfix.
3. Add tests for new functionality.
4. Ensure `mvn -DskipTests=false test` passes locally.
5. Open a pull request describing your changes.

License
-------
This project is licensed under the MIT License - see the LICENSE file for details.

Author
------
- [Your Name Here] - replace with actual author details

Acknowledgements
----------------
- Built using Appium Java Client and TestNG

```
