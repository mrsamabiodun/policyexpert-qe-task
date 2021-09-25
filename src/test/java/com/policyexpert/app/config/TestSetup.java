package com.policyexpert.app.config;

import org.openqa.selenium.WebDriver;
import java.util.Properties;

public abstract class TestSetup {

    public TestContext testContext;
    static protected TestConfig testConfig;
    static public WebDriver webDriver;
    long waitTime = 10;

    {
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/test.properties"));
            testConfig = new TestConfig(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startTest() {

    }

    public void initializeWebDriver() {
        System.setProperty("webdriver.chrome.driver", testConfig.getWebDriverLocation());
    }

    public void endTest() {

    }

    public void beforeEachTest() {
        initializeWebDriver();
        testContext = new TestContext(webDriver, testConfig);
    }
}
