package stepDefinitions;

import Utilities.baseclass;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    baseclass sgp = new baseclass();
    WebDriver driver;

    @Given("User opens URL")
    public void user_opens_url() {
        driver = sgp.getDriver();
        driver.get("https://www.saucedemo.com/");
        System.out.println("URL opened");
    }

    @When("^User enters (.*) and (.*)$")
    public void user_enters_username_and_password(String Username, String Password) {
        driver = sgp.getDriver();
        driver.findElement(By.id("user-name")).sendKeys(Username);
        driver.findElement(By.id("password")).sendKeys(Password);
        System.out.println("Entered username and password");
    }

    @And("User clicks {string}")
    public void user_clicks(String buttonId) {
        driver = sgp.getDriver();
        driver.findElement(By.id("login-button")).click();
        System.out.println("Login button clicked");
    }

    @And("User clicks on {string}")
    public void user_clicks_on(String buttonId) {
        driver = sgp.getDriver();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        System.out.println("Menu button clicked");
    }

    @And("User clicks at {string}")
    public void user_clicks_at(String buttonId) {
        driver = sgp.getDriver();
        driver.findElement(By.id("logout_sidebar_link")).click();
        System.out.println("Logout button clicked");
    }
    public class Hooks {

        @After
        public void tearDown() {
            driver = sgp.getDriver();
            if (driver != null) {
                driver.quit();
                System.out.println("Driver closed after scenario");
            }
        }
    }
}

