package com.policyexpert.app;

import com.policyexpert.app.config.TestSetup;
import com.policyexpert.app.functions.WaitFunction;
import com.policyexpert.app.functions.SelectorFunctions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InsuranceFormTest extends TestSetup {

    /**
     * This first test performs a set of actions and demonstrates how the insurance form can be filled out
     * using the various methods that have been created.
     */

    @Test
    @DisplayName("Policy Expert Insurance Form Test")
    public void insuranceFormTest() {
        WaitFunction waitFunction = new WaitFunction(testContext);
        waitFunction.waitUntilPageLoad();
        SelectorFunctions selectorFunctions = new SelectorFunctions(testContext);
        selectorFunctions.fieldHandler("select", "Mr");
        selectorFunctions.fieldHandler("input", "Jake");
        selectorFunctions.fieldHandler("input", "Masters");
        selectorFunctions.dateHandler("10", "April", "1993");
        selectorFunctions.fieldHandler("select", "Single");
        selectorFunctions.lookupHandler("Ar", "Arborist");
        selectorFunctions.buttonHandler("Yes");
        selectorFunctions.lookupHandler("Qua", "Quality Engineer");
        selectorFunctions.fieldHandler("input", "07976382732");
        selectorFunctions.fieldHandler("input", "vketipisz@qmetric.co.uk");
        selectorFunctions.buttonHandler("No");
        selectorFunctions.addressHandler("EC2N 4AY", "EC2N 4AY", "Policy Expert Ltd");
    }

    /**
     * This second test performs a different set of actions and demonstrates the robustness of the function methodology
     * and how the framework can adjust to a change in input data without failing.
     */

    @Test
    @DisplayName("Policy Expert Insurance Form Test 2")
    public void insuranceFormTest2() {
        WaitFunction waitFunction = new WaitFunction(testContext);
        waitFunction.waitUntilPageLoad();
        SelectorFunctions selectorFunctions = new SelectorFunctions(testContext);
        selectorFunctions.fieldHandler("select", "Mr");
        selectorFunctions.fieldHandler("input", "Jake");
        selectorFunctions.fieldHandler("input", "Masters");
        selectorFunctions.dateHandler("10", "April", "1993");
        selectorFunctions.fieldHandler("select", "Single");
        selectorFunctions.lookupHandler("Ar", "Arborist");
        selectorFunctions.buttonHandler("No"); // Input data changes from this point forward
        selectorFunctions.fieldHandler("input", "07976382732");
        selectorFunctions.fieldHandler("input", "vketipisz@qmetric.co.uk");
        selectorFunctions.buttonHandler("Yes");
        selectorFunctions.buttonHandler("No");
        selectorFunctions.buttonHandler("Yes");
        selectorFunctions.fieldHandler("select", "1");
    }
}
