package com.policyexpert.app.config;

import java.util.Properties;

public class TestConfig {
    private String targetUrl;
    private String testEmail;
    private int timeout;
    private String webDriverLocation;

    public TestConfig(Properties p) {
        this.targetUrl = p.getProperty("test.targetUrl");
        this.testEmail = p.getProperty("test.testEmail");
        this.timeout = Integer.parseInt(p.getProperty("test.timeout"));
        this.webDriverLocation = p.getProperty("webdriver.chrome.driver");
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public String getTestEmail() {
        return testEmail;
    }

    public int getTimeout() {
        return timeout;
    }

    public String getWebDriverLocation() {
        return webDriverLocation;
    }
}
