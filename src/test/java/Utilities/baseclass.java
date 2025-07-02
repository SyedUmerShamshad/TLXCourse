package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class baseclass{
    private static WebDriver driver;

    public baseclass(){}

    public static WebDriver getDriver(){
        WebDriverManager.chromedriver().clearDriverCache().setup();
        if (driver == null){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public void setDriver(WebDriver driver) {
        baseclass.driver = driver;
    }
}