# 🧪 RandomUser API Test Automation Framework

This project is an automated API testing framework built to test the [RandomUser API](https://randomuser.me/).  
It is implemented in **Java 21** using **RestAssured** for API automation, **TestNG** as the testing framework, and **Allure** for reporting.

---

## 📋 Project Overview

The **RandomUser API** provides random user data for testing and prototyping purposes.  
This test suite validates different endpoints and scenarios such as:

- ✅ **Happy Path Tests:** Successful requests returning valid user data.  
- ❌ **Unhappy Path Tests:** Invalid parameters and error handling validation.  
- ⚙️ **Common Utilities:** Config management, reusable API clients, and response validation helpers.

---

## 🧩 Tech Stack

| Component | Purpose |
|------------|----------|
| **Java 21** | Core language |
| **RestAssured** | API automation |
| **TestNG** | Test execution and assertions |
| **Maven** | Dependency and build management |
| **Allure** | Reporting and visualization |
| **GitHub Actions** | Continuous Integration (CI/CD) |

---

## ⚙️ Project Structure

```
randomuser-api-tests/
randomuser-api-tests/
│
├── src/
│   └── test/java/com/example/randomuser/
│       ├── core/
│       │   └── BaseTest.java
│       ├── utils/
│       │   ├── ApiClient.java
│       │   ├── ConfigManager.java
│       │   └── ResponseValidator.java
│       └── tests/
│           ├── HappyPathTests.java
│           └── UnhappyPathTests.java
│
├── config.properties
├── pom.xml
├── testng.xml
├── .github/workflows/ci.yml
└── README.md


```

## 🧾 Prerequisites

Make sure you have the following installed:

| Tool | Version | Download Link |
|------|----------|----------------|
| **Java JDK** | 21 or above | [Download JDK](https://adoptium.net/) |
| **Maven** | 3.9+ | [Download Maven](https://maven.apache.org/download.cgi) |
| **Allure CLI** | Latest | [Allure Installation Guide](https://docs.qameta.io/allure/#_installing_a_commandline) |
| **Git** | Latest | [Download Git](https://git-scm.com/downloads) |

---

## ▶️ How to Run Tests

### Option 1 — From Eclipse IDE

1. Right-click on `testng.xml`  
2. Choose **Run As → TestNG Suite**

### Option 2 — From Command Line

Open a terminal in the project directory and run:

```bash
mvn clean test
```

## This will:

Compile the project

Run TestNG tests

Generate Allure result files under target/allure-results/

### 📊 Viewing Test Reports

# Generate Allure Report

## To create an HTML report:
```
allure generate target/allure-results --clean -o target/allure-report
```
## Open the Report

```
allure serve target/allure-results
```

### Or open manually:

```
target/allure-report/index.html
```

If your results are stored elsewhere (e.g. C:\Users\DELL\Downloads\allure-results):

```
allure generate C:\Users\DELL\Downloads\allure-results --clean -o C:\Users\DELL\Downloads\allure-report
```

### 🚀 CI/CD Integration (GitHub Actions)

This project includes a CI/CD workflow using GitHub Actions that automatically:

1.Runs API tests on every push or pull request

2.Generates Allure results

3.Uploads reports as build artifacts

The configuration file is located at:
```
.github/workflows/ci.yml
```

## Workflow Overview
```
name: RandomUser API Tests
on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: 21
      - name: Run Tests
        run: mvn clean test
      - name: Generate Allure Report
        run: |
          npx allure generate target/allure-results --clean -o allure-report
      - name: Upload Allure Report
        uses: actions/upload-artifact@v4
        with:
          name: allure-report
          path: allure-report
```

### 📂 CI/CD Report Access

Once the workflow runs:

Go to your GitHub repository → Actions tab

Select the latest workflow run

Download the Allure Report from the Artifacts section

### 💡 Example Test Execution Output
```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.example.randomuser.tests.HappyPathTests
[INFO] Sending GET request to https://randomuser.me/api/
[PASS] Response code: 200
[PASS] Valid user data received
-------------------------------------------------------
BUILD SUCCESS
-------------------------------------------------------
```

## 👩‍💻 Maintainer

Author: Suganya K
📧 Email: [suganyablossom96@gmail.com]

🔗 GitHub: https://github.com/suganyak96/randomuser-api-tests

## 🏁 Summary
Feature	Description
✅ Automated API Testing	Using RestAssured + TestNG
⚙️ Configurable Setup	config.properties support
📊 Reporting	Allure HTML reports
🔁 CI/CD	GitHub Actions integration
☕ Java 21	Latest Java features supported

## 🎉 Ready to Use!

Clone, configure, and run your own API test suite effortlessly:
```
git clone https://github.com/suganyak96/randomuser-api-tests.git
cd randomuser-api-tests
mvn clean test
```

Then generate the Allure report to see your results in style! ✨


---

