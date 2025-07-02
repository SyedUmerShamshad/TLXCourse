package stepDefinitions;

import io.cucumber.java.After;
import Utilities.baseclass;
import org.openqa.selenium.WebDriver;

public class Hooks {

    @After
    public void tearDown() {
        baseclass.quitDriver();  // Quits and sets to null
        System.out.println("Driver closed after scenario");
    }
    }
