package com.northWesternMutual.step_definitions;

import com.northWesternMutual.utilites.Driver_utilities;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before ()
    public void setupLoginScenario(){
        System.out.println("BEFORE--Setting up browser with further details...");
    }



    @After
    public void tearDownScenario(Scenario scenario){

        if (scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot) Driver_utilities.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }

        System.out.println("AFTER--Teardown steps are being applied...");
        //Driver_utilities.closeDriver();
    }

//    @BeforeStep
//    public void setupStep(){
//        System.out.println("----setup applying for each step");
//    }
//
//    @AfterStep
//    public void afterStep(){
//        System.out.println("----teardown applying for each step");
//    }

}
