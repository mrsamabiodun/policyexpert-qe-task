package com.policyexpert.app.config;

import java.util.Properties;

public class TestConfig {
    private String targetUrl;
    private String webDriverLocation;

    public TestConfig(Properties p) {
        this.targetUrl = p.getProperty("test.targetUrl");
        this.webDriverLocation = p.getProperty("webdriver.chrome.driver");
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public String getWebDriverLocation() {
        return webDriverLocation;
    }
}
