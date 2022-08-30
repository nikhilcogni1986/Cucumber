package awesomecucumber.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory
{
    private static WebDriver driver;

    public static WebDriver initializeDriver(String browser)
    {
        switch (browser)
        {
            case "CHROME":
                WebDriverManager.chromedriver().cachePath("drivers").setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().cachePath("drivers").setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            default:
                throw new IllegalArgumentException("INVALID BROWSER INPUT");
        }

        return driver;
    }

    public static WebDriver getDriver()
    {
        return driver;
    }
}
