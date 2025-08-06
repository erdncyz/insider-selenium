# Insider Test Automation Project

A Selenium WebDriver test automation project for testing QA positions on the Insider career page.

## Overview

This project automates the testing of QA job listings on Insider's career website. It follows the Page Object Model (POM) design pattern for maintainable and reusable test code.

## Features

- **Selenium WebDriver 4.15.0** - Modern web automation framework
- **JUnit 4** - Testing framework
- **WebDriverManager** - Automatic ChromeDriver management
- **Maven** - Build and dependency management
- **Page Object Model** - Clean code architecture
- **Cross-platform support** - Works on Windows, macOS, and Linux

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- Chrome browser (latest version)
- Git

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/erdncyz/insider-selenium.git
   cd insider-selenium
   ```

2. Install dependencies:
   ```bash
   mvn clean install
   ```

## Usage

### Run All Tests
```bash
mvn test
```

### Run Specific Test
```bash
mvn test -Dtest=VerifyQAJobs
```

### Run in Headless Mode
```bash
mvn test -Dselenium.headless=true
```

## Project Structure

```
insider-selenium/
├── src/test/java/
│   ├── base/
│   │   └── BaseTest.java              # Base test class with common setup
│   ├── objects/                       # Page Object classes
│   │   ├── HomePage.java             # Homepage interactions
│   │   ├── MorePage.java             # Navigation menu
│   │   ├── CareersPage.java          # Careers page
│   │   ├── QAPage.java               # QA department page
│   │   ├── OpenPositionPage.java     # Job listings page
│   │   └── VerifyLeverPage.java      # Lever application page
│   ├── runner/
│   │   └── TestRunner.java           # Test suite runner
│   └── test_scenarios/
│       └── VerifyQAJobs.java         # Main test scenario
├── src/test/resources/
│   └── test-config.properties        # Test configuration
├── drivers/                          # ChromeDriver files
├── pom.xml                          # Maven configuration
└── README.md                        # This file
```

## Test Scenario

The `VerifyQAJobs` test performs the following steps:

1. **Homepage Verification**
   - Verify Insider logo is displayed
   - Accept cookie permissions

2. **Navigation to Careers**
   - Click Company menu
   - Navigate to Careers page

3. **Careers Page Verification**
   - Verify page elements are loaded
   - Check locations and life sections

4. **QA Department Selection**
   - Click "See all teams"
   - Select Quality Assurance department

5. **QA Jobs Selection**
   - Navigate to QA jobs page

6. **Position Filtering**
   - Click "See all QA jobs"

7. **Lever Page Verification**
   - Verify Lever application page loads

## Configuration

### Test Settings

Key configuration in `BaseTest.java`:
- Implicit wait: 10 seconds
- Page load timeout: 60 seconds
- Base URL: https://useinsider.com/

### Chrome Options

The project uses optimized Chrome options for better performance:
- Maximized window
- Disabled notifications and popups
- Performance optimizations
- Remote debugging enabled

## Test Reports

Test results are generated in `target/surefire-reports/` directory after test execution.

## Troubleshooting

### Common Issues

1. **ChromeDriver Version Mismatch**
   - WebDriverManager automatically handles driver versions
   - Ensure Chrome browser is up to date

2. **Element Not Found**
   - Check if website structure has changed
   - Verify locators in page object classes

3. **Timeout Issues**
   - Increase wait times in BaseTest.java if needed
   - Check internet connection

### Debug Mode

Run tests with debug output:
```bash
mvn test -X
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests if applicable
5. Submit a pull request

## License

This project is open source and available under the MIT License.

## Contact

For questions or issues, please open an issue on GitHub.

---

Built with ❤️ using Selenium WebDriver and Java 