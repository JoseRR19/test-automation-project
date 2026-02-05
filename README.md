# Test Automation Project

## Description
This is a Java-based test automation project that covers UI and API testing. It uses Selenium WebDriver and TestNG for web automation, Postman/Newman for API tests, and Maven for build and profile management. The framework follows the Page Object Model, supports multiple environments (dev, QA, prod), and generates test reports and screenshots for verification.

## Prerequisites
- Java 17+
- Maven 3.6+
- Google Chrome
- Git

## Setup
1. Clone the repository `git clone https://github.com/JoseRR19/test-automation-project` 
2. cd your-repo 
3. Run `mvn clean install`

## Running Tests
### Dev profile (default)
mvn clean test

### QA profile
mvn clean test -Pqa

### Production profile
mvn clean test -Pprod

## Maven Profiles

- dev: Default local execution
- qa: QA environment execution
- prod: Production environment execution

## Project Structure
- `src/test/java/pages/` - Page Object classes
- `src/test/java/tests/` - Test classes
- `src/test/java/utils/` - Utilities
- `src/test/resources/` - Test data and configurations

## Reports
- Surefire Test reports are generated in `target/surefire-reports/`
- Newman Test reports are in `newman/`
