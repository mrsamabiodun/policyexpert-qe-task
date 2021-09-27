package com.policyexpert.app.functions;

import com.policyexpert.app.config.ContextLoader;
import com.policyexpert.app.config.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFunction extends ContextLoader {

    public WaitFunction(TestContext testContext) {
        super(testContext);
    }

    public void waitUntilPageLoad() {
        try {
            new WebDriverWait(testContext.getDriver(), 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[data-testid='heading']")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
