package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class baseclass{
    private static WebDriver driver;

    public baseclass(){}

    public static WebDriver getDriver(){
        WebDriverManager.chromedriver().clearDriverCache().setup();
        if (driver == null){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-notifications=*");


   /*        Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.default_content_setting_values.notifications", 2);
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--disable-blink-features=AutomationControlled");*/
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Important to allow reinitialization
        }
    }
    public void setDriver(WebDriver driver) {
        baseclass.driver = driver;
    }
}