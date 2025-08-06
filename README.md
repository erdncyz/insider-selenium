# 🚀 Insider Test Automation

This project contains automated test scenarios for the [Insider](https://useinsider.com/) website using Selenium WebDriver.

## 📋 Table of Contents

- [About the Project](#about-the-project)
- [Features](#features)
- [Requirements](#requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Test Scenarios](#test-scenarios)
- [Configuration](#configuration)
- [Contributing](#contributing)
- [License](#license)

## 🎯 About the Project

This project is developed to test QA positions on Insider's career page. The test scenarios include:

- Homepage verification
- Career page navigation
- QA positions listing
- Lever page verification

## ✨ Features

- 🔧 **Selenium WebDriver 4.15.0** - Modern web automation
- 🧪 **JUnit 4** - Test framework
- 🚗 **WebDriverManager** - Automatic driver management
- 📦 **Maven** - Dependency management
- 🎨 **Page Object Model** - Clean and maintainable code structure
- 🌐 **Cross-platform** - Windows, macOS, Linux support

## 📋 Requirements

- **Java 11** or higher
- **Maven 3.6** or higher
- **Chrome Browser** (latest version)
- **Git**

## 🛠️ Installation

1. **Clone the project:**
   ```bash
   git clone https://github.com/your-username/insider-test-automation.git
   cd insider-test-automation
   ```

2. **Install dependencies:**
   ```bash
   mvn clean install
   ```

3. **Download Chrome Driver:**
   - Download the appropriate version for your operating system from [ChromeDriver](https://chromedriver.chromium.org/)
   - Place it in the `drivers/` folder

## 🚀 Usage

### Run All Tests
```bash
mvn test
```

### Run Specific Test Class
```bash
mvn test -Dtest=verify_QA_jobs
```

### Run in Headless Mode
```bash
mvn test -Pheadless
```

### Generate Test Reports
```bash
mvn surefire-report:report
```

### Using the Test Runner Script
```bash
# Run all tests
./run-tests.sh

# Run only QA Jobs test
./run-tests.sh qa-jobs

# Run in headless mode
./run-tests.sh headless
```

## 📁 Project Structure

```
insider_test-master/
├── src/
│   └── test/
│       └── java/
│           ├── objects/                 # Page Object Model classes
│           │   ├── HomePage.java
│           │   ├── MorePage.java
│           │   ├── CareersPage.java
│           │   ├── QAPage.java
│           │   ├── OpenPositionPage.java
│           │   └── VerifyLeverPage.java
│           ├── test_scenarios/          # Test scenarios
│           │   ├── BaseTest.java        # Base test class
│           │   ├── TestRunner.java      # Test suite
│           │   └── VerifyQAJobs.java    # QA test
│           └── utils/                   # Utility classes
│               └── TestUtils.java       # Helper functions
├── drivers/                             # WebDriver files
├── target/                              # Maven build outputs
├── .idea/                               # IntelliJ IDEA settings
├── .vscode/                             # VS Code settings
├── pom.xml                             # Maven configuration
├── README.md                           # Project documentation
├── .gitignore                          # Git ignore rules
├── run-tests.sh                        # Test runner script
├── insider_test.iml                    # IntelliJ IDEA module file
├── PROJE_DOKUMANTASYONU.md             # Detailed project documentation
├── HTML_DOKUMANTASYON.html             # HTML format documentation
└── generate-pdf.sh                     # PDF generation script
```

## 🧪 Test Scenarios

### `VerifyQAJobs` Test Scenario

This test scenario performs the following steps:

1. **Homepage Verification**
   - Checks the visibility of Insider logo
   - Accepts cookie permissions

2. **Navigation**
   - Clicks on "More" menu
   - Navigates to "Careers" page

3. **Career Page**
   - Verifies the career page loads correctly
   - Selects QA department

4. **QA Positions**
   - Lists QA positions
   - Displays open positions

5. **Lever Page Verification**
   - Checks if Lever page loads correctly

## 🔧 Configuration

### Test Settings

Test settings can be configured in `VerifyQAJobs.java`:

- **Implicit Wait**: 15 seconds
- **Browser**: Chrome
- **Window**: Maximized
- **Base URL**: https://useinsider.com/

### Chrome Driver Path

Chrome driver path is defined in `pom.xml`:

```xml
<webdriver.chrome.driver>${project.basedir}/drivers/chromedriver.exe</webdriver.chrome.driver>
```

## 📊 Test Reports

Test results can be found in `target/surefire-reports/` directory.

## 🤝 Contributing

1. Fork this repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Create a Pull Request

## 📝 License

This project is licensed under the MIT License. See the `LICENSE` file for details.

## 📞 Contact

- **Project Owner**: [Your Name]
- **Email**: your.email@example.com
- **LinkedIn**: [Your LinkedIn Profile]

## 🙏 Acknowledgments

- [Selenium](https://selenium.dev/) - Web automation framework
- [Insider](https://useinsider.com/) - Tested website
- [Maven](https://maven.apache.org/) - Build tool

---

⭐ If you like this project, don't forget to give it a star! 