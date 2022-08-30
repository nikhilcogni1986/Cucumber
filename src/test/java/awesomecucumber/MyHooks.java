package awesomecucumber;

import awesomecucumber.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class MyHooks
{
    private static WebDriver driver;
    @Before
    public void initialization()
    {
        driver = DriverFactory.initializeDriver(System.getProperty("browser","CHROME"));
    }

    @After
    public void quit()
    {
        driver.quit();
    }
}