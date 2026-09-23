# Demo Web Shop Automation Testing Project

## Project Name

**Demo Web Shop Automation Framework**

## Application

https://demowebshop.tricentis.com/

## Description

This project is created to automate the **Demo Web Shop application** using Selenium WebDriver with Java.

I have developed this project using **Page Object Model (POM)** and **Page Factory** concepts.

The framework is designed to automate different functionalities of the Demo Web Shop application and generate automation reports.

## Technologies Used

* Java
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)
* Page Factory
* Apache POI
* Excel
* Extent Reports
* Log4j2
* WebDriverManager
* Git & GitHub

## Framework Structure

```text
src/main/java
│
├── base
├── constants
├── driver
├── listeners
├── pages
├── reports
├── retry
└── utilities

src/test/java
│
├── login
├── register
└── other test classes
```

## Features

* Browser automation using Selenium
* Page Object Model
* Page Factory
* Data Driven Testing
* Excel test data
* TestNG annotations
* TestNG DataProvider
* Retry mechanism
* Extent HTML reports
* Screenshot capture
* Explicit wait
* Implicit wait
* WebDriver utilities
* Configuration properties
* Log4j2 logging
* Chrome and Edge browser support

## Test Cases

### Register

* Verify valid registration
* Verify registration with existing email
* Verify registration with empty fields
* Verify registration with invalid email
* Verify password mismatch validation

### Login

* Verify valid login
* Verify invalid login
* Verify empty username
* Verify empty password
* Verify logout

### Product

* Search product
* Select product
* Verify product details
* Add product to cart

### Cart

* Verify added product
* Update product quantity
* Remove product from cart
* Verify cart details

## Test Data

Test data is maintained in Excel files and is supplied to TestNG test cases using `@DataProvider`.

## Retry Mechanism

The framework uses a custom Retry Analyzer.

If a test fails, it will be retried automatically.

```text
Attempt 1 → Failed
Attempt 2 → Retry
Attempt 3 → Final Attempt
```

## Extent Report

Extent Reports are used to generate HTML automation reports.

The report contains:

* Test execution status
* Pass/Fail status
* Failure details
* Exception details
* Screenshots for final failures

## How to Run

1. Clone the repository.
2. Import the project into Eclipse.
3. Update Maven dependencies.
4. Open the required `.xml` TestNG suite.
5. Right-click the XML file.
6. Select **Run As → TestNG Suite**.

Example:

```text
register.xml
```

or

```text
testng.xml
```

## Browser

Default browser:

```text
Chrome
```

The browser can also be changed through the TestNG XML parameter.

## Author

**Muthupandiyan K**

B.E. Computer Science and Engineering

## Purpose

This project is created for **learning, practice, and demonstrating Selenium automation testing skills**.
