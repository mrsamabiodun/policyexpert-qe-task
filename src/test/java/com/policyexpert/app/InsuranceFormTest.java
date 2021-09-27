package com.policyexpert.app;

import com.policyexpert.app.config.TestSetup;
import com.policyexpert.app.functions.WaitFunction;
import com.policyexpert.app.selectors.Selectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;

public class InsuranceFormTest extends TestSetup {

    @Test
    @DisplayName("Policy Expert Insurance Form Test")
    public void insuranceFormTest() {
        WaitFunction waitFunction = new WaitFunction(testContext);
        waitFunction.waitUntilPageLoad();
        Selectors selectors = new Selectors(testContext);
        selectors.findFieldElement("select", "Mr");
        selectors.findFieldElement("input", "Jake");
        selectors.findFieldElement("input", "Masters");
        selectors.dateHandler("10", "April", "1993");
        selectors.findFieldElement("select", "Single");
        selectors.lookupHandler("Ar", "Arborist");
        selectors.buttonHandler("Yes");
        selectors.lookupHandler("Qua", "Quality Engineer");
        selectors.findFieldElement("input", "07976382732");
        selectors.findFieldElement("input", "vketipisz@qmetric.co.uk");
    }
}
