package com.policyexpert.app.config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class TestSetup {

    public TestContext testContext;
    static protected TestConfig testConfig;
    static public WebDriver webDriver;
    long waitTime = 10;

    {
        Properties properties = new Properties();
        try {
            String workingDirectory = System.getProperty("user.dir");
            String relativePropertiesPath = "/src/test/java/com/policyexpert/app/resources/test.properties";
            properties.load(new FileInputStream(workingDirectory + relativePropertiesPath));
            testConfig = new TestConfig(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startTest() {
    }

    public void initializeWebDriver() {
        System.setProperty("webdriver.chrome.driver", testConfig.getWebDriverLocation());
        ChromeOptions options = new ChromeOptions();
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        this.webDriver = new ChromeDriver(options);
    }

    @AfterEach
    public void endTest() {
        testContext.getDriver().close();
    }

    @BeforeEach
    public void beforeEachTest() {
        initializeWebDriver();
        testContext = new TestContext(webDriver, testConfig);
        testContext.getDriver().manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
        testContext.getDriver().navigate().to(testConfig.getTargetUrl());
    }
}
