package com.policyexpert.app.config;

public abstract class ContextLoader {

    protected TestContext testContext;

    public ContextLoader(TestContext testContext) {
        this.testContext = testContext;
    }
}
