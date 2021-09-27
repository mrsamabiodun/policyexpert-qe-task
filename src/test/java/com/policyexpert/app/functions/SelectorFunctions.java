package com.policyexpert.app.functions;

import com.policyexpert.app.config.ContextLoader;
import com.policyexpert.app.config.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SelectorFunctions extends ContextLoader {

    public SelectorFunctions(TestContext testContext) {
        super(testContext);
    }

    List<WebElement> fields = testContext.getDriver().findElements(By.cssSelector("div[data-testid='question']"));
    int i = 0;

    public void fieldHandler(String fieldType, String... testData) {

        if (fieldType.contains("select")) {
            fields.get(i).findElement(By.tagName("select"));
            Select dropDown = new Select(fields.get(i).findElement(By.tagName("select")));
            dropDown.selectByVisibleText(testData[0]);
            i++;
        } else if (fieldType.contains("input")) {
            WebElement field = fields.get(i).findElement(By.tagName("input"));
            field.click();
            field.sendKeys(testData);
            i++;
        }

    }

    public void dateHandler(String day, String month, String year) {

            List<WebElement> selectList = fields.get(i).findElements(By.tagName("select"));
            Select dayDropDown = new Select(selectList.get(0));
            dayDropDown.selectByValue(day);

            Select monthDropDown = new Select(selectList.get(1));
            monthDropDown.selectByVisibleText(month);

            Select yearDropDown = new Select(selectList.get(2));
            yearDropDown.selectByValue(year);

            i++;
    }

    public void lookupHandler(String input, String testData) {

        WebElement field = fields.get(i).findElement(By.tagName("input"));
        field.click();
        field.sendKeys(input);

        new WebDriverWait(testContext.getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.className("list-group")));

        List<WebElement> listItems = fields.get(i).findElements(By.className("list-group-item"));

        try {
            for (WebElement listItem : listItems) {
                if (listItem.getText().contains(testData))
                listItem.click();
            }
        } catch (StaleElementReferenceException e) {
            field.click();
        }
        i++;
    }

    public void buttonHandler(String option) {

        List<WebElement> buttons = fields.get(i).findElements(By.tagName("button"));

        try {
            for (WebElement button : buttons) {
                if (button.getText().contains(option)) {
                    button.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            i--;
        }

        fields = testContext.getDriver().findElements(By.cssSelector("div[data-testid='question']"));

        i++;
    }

    public void addressHandler(String input, String primaryTestData, String secondaryTestData) {

        WebElement field = fields.get(i).findElement(By.tagName("input"));
        field.click();
        field.sendKeys(input);

        new WebDriverWait(testContext.getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.className("list-group")));

        List<WebElement> primaryListItems = fields.get(i).findElements(By.className("list-group-item"));

        try {
            for (WebElement primaryListItem : primaryListItems) {
                if (primaryListItem.getText().contains(primaryTestData))
                    primaryListItem.click();
            }

            List<WebElement> secondaryListItems = fields.get(i).findElements(By.className("list-group-item"));

            for (WebElement secondaryListItem : secondaryListItems) {
                if (secondaryListItem.getText().contains(secondaryTestData))
                    secondaryListItem.click();
            }

        } catch (StaleElementReferenceException e) {
            field.click();
        }
        i++;
    }

}
