# How to run InsuranceFormTest


### Prerequisites

These tests use **Selenium** and **chromedriver v94.0.4606.41 mac64**, and therefore requires **Google Chrome 94.0** to run.

If you are using a different version of Google Chrome or a different operating system, you can find the appropriate **chromedriver** version here: https://chromedriver.chromium.org/downloads

The **chromedriver** executable can be found in the *src/test/java/com/policyexpert/app/resources* directory, replace the existing **chromedriver** with the downloaded one if necessary.


### Test Instructions

This is a **Maven** project and has an available **pom.xml**. Prior to running the tests, run the below command to ensure all dependencies are installed.

> mvn clean install

The properties used for the test can be found in the *src/test/java/com/policyexpert/app/resources* directory, in the **test.properties** file. Any relevant changes to the properties can be made here.

The tests can be found in **InsuranceFormTest.java**. 

The tests can also be run using the below command:

> mvn test

