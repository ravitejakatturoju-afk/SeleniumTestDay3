# Selenium Test Automation Framework

## Overview
Automated test suite for ecommerce-playground.lambdatest.io with user registration and login functionality.

## Prerequisites
- Java 11+
- Maven 3.6+
- Chrome browser

## Project Structure
```
src/test/java/
├── base/BaseTest.java          # Base test class with setup/teardown
├── pages/                      # Page Object Model classes
│   ├── HomePage.java
│   ├── LoginPage.java
│   └── RegisterPage.java
├── tests/EcommerceTest.java    # Test cases
└── utils/TestUtils.java        # Utility methods
```

## Running Tests

### Headed Mode (Default)
```bash
mvn test
```

### Headless Mode
```bash
mvn test -Dheadless=true
```

### Run Specific Test
```bash
mvn test -Dtest=EcommerceTest#testUserRegistration
```

## Test Cases
- **testUserRegistration**: Creates new user account with random data
- **testUserLogin**: Logs in with registered user credentials
- **testHomePageTitle**: Verifies home page loads correctly

## Features
- Page Object Model design pattern
- Random test data generation
- Headless/headed mode support
- Proper test dependencies and priorities
- Comprehensive assertions