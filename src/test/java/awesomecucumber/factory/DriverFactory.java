package awesomecucumber.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory
{
    private static WebDriver driver;

    public static WebDriver getDriver()
    {
        System.setProperty("webdriver.chrome.driver","F:\\CucumberFramework\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
