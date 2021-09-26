package com.policyexpert.app;

import com.policyexpert.app.config.TestSetup;
import com.policyexpert.app.functions.WaitFunction;
import com.policyexpert.app.selectors.Selectors;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;


/**
 * Unit test for simple App.
 */
public class AppTest extends TestSetup
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void sampleTest() {
        WaitFunction waitFunction = new WaitFunction(testContext);
        waitFunction.waitUntilPageLoad();
//        Selectors selectors = new Selectors();
//        selectors.findFieldElement();
    }
}
