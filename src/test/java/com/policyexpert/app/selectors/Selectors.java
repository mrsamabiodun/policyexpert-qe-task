package com.policyexpert.app.selectors;

import com.policyexpert.app.config.ContextLoader;
import com.policyexpert.app.config.TestContext;
import com.policyexpert.app.config.TestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;

public class Selectors extends ContextLoader {

    public Selectors(TestContext testContext) {
        super(testContext);
    }

//    @FindBy(className = "data-testid")
//    private WebElement field;

    int fieldsTally = testContext.getDriver().findElements(By.cssSelector("div[data-testid]")).size();
    int i = 0;

    public void findFieldElement(String fieldType, String... testData) {
//        int i = 0;
        List<WebElement> fields = testContext.getDriver().findElements(By.cssSelector("div[data-testid='question']"));

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
        int j = 0;
        List<WebElement> fields = testContext.getDriver().findElements(By.cssSelector("div[data-testid='date-dropdowns']"));

            List<WebElement> selectList = fields.get(j).findElements(By.tagName("select"));
            Select dayDropDown = new Select(selectList.get(0));
            dayDropDown.selectByValue(day);

            Select monthDropDown = new Select(selectList.get(1));
            monthDropDown.selectByVisibleText(month);

            Select yearDropDown = new Select(selectList.get(2));
            yearDropDown.selectByValue(year);

            j++;
            i++;
    }

    public void lookupHandler(String input, String testData) {
        List<WebElement> fields = testContext.getDriver().findElements(By.cssSelector("div[data-testid='question']"));

        WebElement field = fields.get(i).findElement(By.tagName("input"));
        field.click();
        field.sendKeys(input);

        new WebDriverWait(testContext.getDriver(), 5).until(ExpectedConditions.presenceOfElementLocated(By.className("list-group")));

//        fields.get(i).findElement(By.className("list-group-item")).click();

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
        List<WebElement> fields = testContext.getDriver().findElements(By.cssSelector("div[data-testid='question']"));

        List<WebElement> buttons = fields.get(i).findElements(By.tagName("button"));

            for (WebElement button : buttons) {
                if (button.getText().contains(option)) {
                    button.click();
                }
            }

        i++;
    }
}
