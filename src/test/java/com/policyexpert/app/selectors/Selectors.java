package com.policyexpert.app.selectors;

import com.policyexpert.app.config.ContextLoader;
import com.policyexpert.app.config.TestContext;
import com.policyexpert.app.config.TestSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
    }
}

//    public void findFieldElement() {
//        List<WebElement> fields = testContext.getDriver().findElements(By.cssSelector("div[data-testid]"));
//
//        for (WebElement field : fields) {
//            if (field.getAttribute("data-testid").contains("question")) {
//                System.out.println("test");
//                try {
//                    fields.get(0).findElement(By.tagName("input"));
//                    field.click();
//                    field.sendKeys("test-data");
//                } catch (Exception e) {
//                    fields.get(0).findElement(By.tagName("select"));
//                    Select dropDown = new Select(fields.get(0).findElement(By.tagName("select")));
//                    dropDown.selectByIndex(1);
//                }
//            }
//        }
//    }
//}


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
