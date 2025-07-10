package stepDefinitions;

import org.example.pages.LoginPage;
import Utilities.ConfigReader;
import Utilities.JsonReader;
import Utilities.baseclass;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import com.github.javafaker.Faker;


public class Login {
    baseclass sgp = new baseclass();
    WebDriver driver;
    LoginPage loginPage;
    Faker faker = new Faker();
    List<Map<String, String>> testDataList = JsonReader.getTestData("src/test/resources/testData.json");
    String username;
    String password;
    String usernamef;
    String passwordf;

    @Given("User opens URL")
    public void user_opens_url() {
        String timestamp = new SimpleDateFormat("HH_mm_ss").format(new Date());
        driver = sgp.getDriver();
        loginPage = new LoginPage(driver);
        ConfigReader.loadProperties("config.properties"); // Load once at the start
        String url = ConfigReader.getProperty("app.url");
        driver.get(url);
        System.out.println("URL opened " + url);
        File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(f.toPath(), new File("D:\\SeleniumTraining\\learnSelenium\\Screenshots\\Test_"+timestamp+".jpg").toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @When("User enters invalid User and Pass")
    public void user_enters_invalid_user_and_pass() {

        driver = sgp.getDriver();
        usernamef = faker.name().username();
        passwordf = faker.internet().password(8, 16);

        loginPage.enterUsername(usernamef);
        loginPage.enterPassword(passwordf);

        System.out.println("Random username: " + usernamef);
        System.out.println("Random password: " + passwordf);
        try {
            Thread.sleep(5000);;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Given("User loads test data at index {int}")
    public void user_loads_test_data_at_index(int index) {
        Map<String, String> userData = testDataList.get(index);
        username = userData.get("username");
        password = userData.get("password");
        System.out.println("Loaded data: " + username + " / " + password);
    }


    @When("User enters username and password from JSON")
    public void user_enters_username_and_password() {

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        System.out.println("Entered username " + username + " and password " + password);
    }

    @And("User clicks {string}")
    public void user_clicks(String buttonId) {
        driver = sgp.getDriver();
        loginPage.clickLogin();
        System.out.println("Login button clicked");
    }

    @And("User clicks on {string}")
    public void user_clicks_on(String buttonId) {
        driver = sgp.getDriver();
        loginPage.openMenu();
        System.out.println("Menu button clicked");
    }

    @And("User clicks at {string}")
    public void user_clicks_at(String buttonId) {
        driver = sgp.getDriver();
        loginPage.clickLogout();
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

