# AndroidGeneralStore - Mobile Automation Test Framework

A friendly mobile automation testing framework for Android applications that makes testing actually enjoyable! Built with Java, Appium, TestNG and Maven, following practical test-automation best practices.

## What We Use

- **Java 25** - Modern and powerful
- **Appium 10.0.0** - Reliable mobile automation
- **TestNG 7.12.0** - Flexible test framework
- **Allure Reports** - Beautiful test reports
- **Maven** - Dependency management made easy
- **Jackson** - JSON handling for test data
- **Commons IO** - File operations utilities

## Project Layout

```
AndroidGeneralStore/
├── pom.xml                    # Dependencies and build config
├── src/
│   ├── main/java/
│   │   ├── screenEngine/      # Core utilities & base classes
│   │   └── generalStoreScreens/ # Page objects for the app
│   └── test/
│       ├── java/
│       │   ├── engine/        # Base test classes
│       │   ├── testCases/     # Individual test cases
│       │   └── testScenarios/ # End-to-end scenarios
│       └── resources/
│           └── GeneralStore.apk # Our test app
└── target/                    # Build outputs and reports
```

## What We Test

The framework covers the main user flows of the General Store app:

- **Landing Screen** - User registration and form validation
- **Product List** - Product browsing and selection
- **Shopping Cart** - Cart management and checkout flow

### Test Categories

1. **Unit Tests** - Individual screen functionality
2. **Integration Tests** - Cross-screen workflows
3. **Scenario Tests** - Complete user journeys

## How It Works

### Base Classes

- **BaseTestCase** - Fresh Appium session for each test method
- **BaseTestScenario** - Shared session for test classes
- **BaseScreen** - Common screen utilities and waits

### Screen Objects

Clean, maintainable page objects for:
- `LandingScreen` - Registration and login
- `ProductListScreen` - Product catalog
- `CartScreen` - Shopping cart management

### Smart Features

- **JSON Test Data** - External test data management
- **Properties File Support** - Flexible configuration
- **Screenshot Capture** - Automatic failure screenshots
- **Allure Reporting** - Rich, interactive test reports
- **Gesture Support** - Touch and swipe actions

## Getting Started

### Prerequisites

- Java JDK 11+ (we use 25)
- Maven 3.6+
- Appium server
- Android emulator or device
- ChromeDriver (for webviews)

### Quick Setup

```bash
# Clone and build
git clone <repository-url>
cd AndroidGeneralStore
mvn clean compile

# Run all tests
mvn test

# View Allure reports
mvn allure:serve
```

### Running Specific Tests

```bash
# Run landing screen tests
mvn test -Dtest=LandingScreenTestSuitTests

# Run product list tests
mvn test -Dtest=ProductListScreenTests

# Run cart tests
mvn test -Dtest=CartTestSuitTests

# Run end-to-end scenarios
mvn test -Dtest=VerifyAddProductToCartTests
```

## Configuration

The framework supports multiple configuration approaches:

1. **Hardcoded** (for quick starts)
2. **Properties File** (recommended for teams)
3. **JSON Test Data** (for data-driven testing)

### Properties File Support

Create `src/test/resources/config.properties`:
```properties
device.name=emulator-5554
app.path=src/test/resources/GeneralStore.apk
server.host=127.0.0.1
server.port=4723
```

## Reports & Results

### Allure Reports

Beautiful, interactive reports with:
- Test execution timeline
- Screenshots and videos
- Test data and parameters
- Failure analysis

Generate reports:
```bash
mvn test
mvn allure:serve    # View live reports
mvn allure:report   # Generate static reports
```

### TestNG Reports

Standard HTML reports in `target/surefire-reports/`

## Best Practices We Follow

- **Page Object Model** - Clean separation of concerns
- **Reusable Utilities** - Don't repeat yourself
- **Explicit Waits** - Reliable test execution
- **Data-Driven Testing** - Flexible test data management
- **Comprehensive Reporting** - Know what's happening

## Cool Features

- **Screenshot on Failure** - Automatic visual debugging
- **JSON Test Data** - Easy test data management
- **Gesture Support** - Natural mobile interactions
- **Flexible Configuration** - Adapt to your environment
- **Parallel Execution Ready** - Scale your testing

## Contributing

We'd love your help! Here's how to get started:

1. Fork the project
2. Create a feature branch
3. Add your awesome tests
4. Make sure everything passes: `mvn test`
5. Open a pull request

## Need Help?

- Check the test classes for examples
- Look at the screen objects for patterns
- Review the base classes for setup
- Run Allure reports for detailed insights



---

**Happy Testing! 🚀**
