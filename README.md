# OrangeHRM BDD Automation Framework

> An enterprise-grade, behavior-driven development (BDD) test automation framework engineered to validate the complete HR management lifecycle of the **OrangeHRM** platform. This project demonstrates dual expertise in **software engineering** and **QA automation** — implementing clean code architectures, proven design patterns, and production-scale testing practices that mirror real-world delivery pipelines.

---

## 🎯 Project Mission

OrangeHRM is a widely deployed, open-source HR management system used by enterprises globally. This framework was built to establish a **living regression safety net** around its core HR workflows — ensuring that every build is validated against human-readable business requirements before it reaches production.

The framework treats test automation not as an afterthought, but as a **first-class engineering discipline**: with layered architecture, separation of concerns, and a design that scales horizontally across features, environments, and team members.

---

## 🚀 Key Architectural Highlights

### True BDD Execution
Feature files are authored in **plain Gherkin** — readable by business stakeholders, product owners, and QA alike. Step definitions are decoupled, highly reusable, and mapped one-to-one with business intent rather than implementation details.

### Page Object Model (POM)
A strict POM enforces **UI element isolation** from test logic. Every page in the OrangeHRM application is represented as a dedicated Java class — locators live exactly where they belong, making maintenance a single-point-of-change operation rather than a cross-cutting concern.

### Robust Synchronization
Brittle `Thread.sleep()` calls are entirely absent from this codebase. All wait strategies are implemented using **custom explicit and fluent wait wrappers**, built on top of Selenium's `ExpectedConditions` and `FluentWait` APIs, yielding deterministic and timing-resilient test execution.

### Enterprise-Grade Reporting
Every test run produces dual-layer reporting artifacts:
- **Extent Reports** — interactive HTML dashboards with step-level pass/fail breakdown, execution timelines, and embedded failure screenshots
- **Cucumber HTML Reports** — scenario-level BDD traceability reports mapping Gherkin steps to their execution outcomes

### Screenshot on Failure
Automated screenshot capture is wired into the framework's `@After` hooks, attaching visual evidence of failures directly into the Extent Report — eliminating the guesswork in post-mortem defect analysis.

---

## 🛠 Tech Stack & Tools

| Component | Technology | Version | Purpose |
| :--- | :--- | :--- | :--- |
| **Language** | Java | 17+ | Core programming, OOP design, and lambda expressions |
| **Automation Engine** | Selenium WebDriver | 4.x | Cross-browser browser control and DOM manipulation |
| **Framework Runner** | TestNG | Latest | Suite management, grouping, parallel execution, and listeners |
| **BDD Layer** | Cucumber JVM | 7.x | Gherkin feature-to-step-definition mapping |
| **Build Tool** | Apache Maven | 3.x | Dependency resolution, lifecycle management, and CI integration |
| **Reporting** | Extent Reports + Cucumber HTML | Latest | Visual dashboards and BDD traceability |
| **Design Pattern** | Page Object Model | — | UI element encapsulation and maintainability |
| **IDE & Platform** | Eclipse IDE | macOS | Development, debugging, and run configuration |

---

## 📁 Project Structure

```text
OrangeHRM_Automation/
├── src/
│   └── test/
│       ├── java/
│       │   ├── runners/
│       │   │   └── TestRunner.java          # CucumberOptions, TestNG entry point
│       │   ├── stepdefinitions/
│       │   │   ├── LoginSteps.java          # Login / Authentication step glue
│       │   │   ├── EmployeeSteps.java       # PIM / Employee management step glue
│       │   │   ├── LeaveSteps.java          # Leave module step glue
│       │   │   ├── RecruitmentSteps.java    # Recruitment workflow step glue
│       │   │   └── CommonSteps.java         # Shared / background step definitions
│       │   ├── pages/
│       │   │   ├── LoginPage.java           # Login page locators and actions
│       │   │   ├── DashboardPage.java       # Dashboard navigation actions
│       │   │   ├── EmployeePage.java        # PIM module page objects
│       │   │   ├── LeavePage.java           # Leave module page objects
│       │   │   └── RecruitmentPage.java     # Recruitment module page objects
│       │   └── utils/
│       │       ├── DriverFactory.java       # WebDriver initialization and teardown
│       │       ├── WaitUtils.java           # Custom explicit and fluent wait wrappers
│       │       ├── ConfigReader.java        # config.properties parser and accessor
│       │       ├── ScreenshotUtils.java     # Failure screenshot capture and attachment
│       │       └── ExtentReportManager.java # Extent Reports lifecycle manager
│       └── resources/
│           ├── features/
│           │   ├── Login.feature            # Login and authentication scenarios
│           │   ├── Employee.feature         # Add / edit / delete employee scenarios
│           │   ├── Leave.feature            # Apply / approve / reject leave scenarios
│           │   └── Recruitment.feature      # Job vacancy and candidate workflows
│           └── config.properties            # Base URL, credentials, browser, timeouts
├── test-output/
│   ├── ExtentReport.html                    # Interactive visual execution report
│   └── cucumber-reports/                    # Cucumber HTML BDD traceability report
├── pom.xml                                  # Maven dependencies and Surefire plugin config
└── README.md                                # Project documentation
```

---

## 🌐 OrangeHRM Modules Under Test

| Module | Scenarios Covered |
| :--- | :--- |
| **Authentication** | Valid login, invalid credentials, session timeout, logout |
| **PIM — Employee Management** | Add employee, edit personal details, search, delete |
| **Leave Management** | Apply for leave, approve / reject, leave balance verification |
| **Recruitment** | Post job vacancy, add candidate, track application status |
| **Admin** | User role management, system configuration validation |

---

## ⚙️ Setup & Execution

### Prerequisites

Ensure the following are installed on your machine:

- Java JDK 17+
- Apache Maven 3.6+
- Google Chrome (latest) or Mozilla Firefox
- OrangeHRM instance running locally or accessible via network

### Clone the Repository

```bash
git clone https://github.com/your-username/OrangeHRM_Automation.git
cd OrangeHRM_Automation
```

### Configure the Environment

Open `src/test/resources/config.properties` and set your environment values:

```properties
base.url=https://opensource-demo.orangehrmlive.com
browser=chrome
admin.username=Admin
admin.password=admin123
implicit.wait=10
explicit.wait=20
```

### Run the Full Test Suite

```bash
mvn clean test
```

### Run by Tag

```bash
# Run only smoke tests
mvn clean test -Dcucumber.filter.tags="@smoke"

# Run regression suite
mvn clean test -Dcucumber.filter.tags="@regression"

# Run a specific module
mvn clean test -Dcucumber.filter.tags="@login or @employee"
```

---

## 📊 Reporting

After each execution, reports are generated automatically:

| Report Type | Output Path | Description |
| :--- | :--- | :--- |
| **Extent HTML Report** | `test-output/ExtentReport.html` | Visual dashboard with step details and screenshots |
| **Cucumber HTML Report** | `test-output/cucumber-reports/` | BDD-native scenario traceability |

Open `ExtentReport.html` in any browser to review the full execution summary, feature-level breakdown, and embedded failure screenshots.

---

## 🏗 Design Principles

### Separation of Concerns
Test logic (step definitions), UI interaction (page objects), and infrastructure (utilities) are cleanly separated into distinct layers. No layer has knowledge of another's internal implementation — only its public interface.

### DRY — Don't Repeat Yourself
Common background steps (`@Before`, `@After` hooks), shared wait utilities, and reusable page action methods ensure that code is authored once and reused everywhere.

### Fail Fast with Meaningful Errors
All assertions produce actionable failure messages. Combined with automatic screenshot capture on failure, every defect report contains sufficient context for immediate triage.

### Configuration-Driven
All environment-specific values (URLs, credentials, browser type, wait timeouts) are externalized to `config.properties`. No hard-coded values exist in the codebase — the framework is environment-agnostic by design.

---

## 🧩 Sample Gherkin Feature

```gherkin
@smoke @login
Feature: OrangeHRM Login Functionality
  As an HR administrator
  I want to authenticate securely into the OrangeHRM portal
  So that I can manage employee records and HR workflows

  Background:
    Given User navigates to the OrangeHRM login page

  @positive
  Scenario: Successful login with valid credentials
    When User enters username "Admin" and password "admin123"
    And User clicks the Login button
    Then User should be redirected to the Dashboard
    And The welcome message should display "Welcome Admin"

  @negative
  Scenario: Login failure with invalid credentials
    When User enters username "admin" and password "wrongpass"
    And User clicks the Login button
    Then An error message "Invalid credentials" should be displayed
    And User should remain on the Login page
```

---

## 👨‍💻 Author

**RB Chowdhury**
Software Developer | QA Automation Engineer

> *"Quality is not an act, it is a habit."* — Aristotle

---

## 📄 License

This project is licensed under the MIT License. See the `LICENSE` file for full details.
