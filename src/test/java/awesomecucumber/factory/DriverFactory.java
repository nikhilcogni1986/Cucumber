package awesomecucumber.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory
{
    private static WebDriver driver;

    public static WebDriver initializeDriver()
    {
        WebDriverManager.chromedriver().cachePath("drivers").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver()
    {
        return driver;
    }
}
