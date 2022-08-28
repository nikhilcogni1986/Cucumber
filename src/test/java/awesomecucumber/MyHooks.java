package awesomecucumber;

import awesomecucumber.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyHooks
{
    private static WebDriver driver;
    @Before
    public void initialization()
    {
        System.out.println(System.getProperty("user.dir"));
    }

    @After
    public void quit()
    {
        driver.quit();
    }
}