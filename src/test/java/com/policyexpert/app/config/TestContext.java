package com.policyexpert.app.config;

import org.openqa.selenium.WebDriver;

public class TestContext {
    private WebDriver driver;
    private TestConfig config;

    public TestContext(WebDriver driver, TestConfig config) {
        this.driver = driver;
        this.config = config;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public TestConfig getConfig() {
        return config;
    }
}
