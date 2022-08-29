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
        System.out.println(System.getProperty("user.dir"));
        driver = DriverFactory.initializeDriver();
    }

    @After
    public void quit()
    {
        driver.quit();
    }
}