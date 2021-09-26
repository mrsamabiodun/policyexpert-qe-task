package com.policyexpert.app.selectors;

import com.policyexpert.app.config.TestContext;
import com.policyexpert.app.config.TestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class Selectors extends TestSetup {

//    @FindBy(className = "data-testid")
//    private WebElement field;

    public void findFieldElement() {
        List<WebElement> fields = testContext.getDriver().findElements(By.cssSelector("div[data-testid]"));

        for (WebElement field : fields) {
            if (field.getAttribute("data-testid").contains("question")) {
                System.out.println("test");
            }
        }

        }
    }


//try {
//        fields.get(0).findElement(By.tagName("input"));
//
//        } catch (Exception e) {
//        fields.get(0).findElement(By.tagName("select"));
//Select dropDown = new Select(fields.get(0).findElement(By.tagName("select")));
//    dropDown.selectByIndex(1);
//        }


//    List<WebElement> fields = testContext.getDriver().findElements(By.cssSelector("div[data-testid='question']"));

//try {
//        fields.get(0).findElement(By.tagName("input"));
//
//        } catch (Exception e) {
//        fields.get(0).findElement(By.tagName("select"));
//        Select dropDown = new Select(fields.get(0).findElement(By.tagName("select")));
//        dropDown.selectByIndex(1);
//        }
