package awesomecucumber;

import awesomecucumber.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class MyHooks
{
    private WebDriver driver;

    @Before
    public void initialization(Scenario scenario)
    {
        System.out.println("BEFORE INITIALIZE: "+Thread.currentThread().getId()+"- "+
                scenario.getName());
        driver = DriverFactory.initializeDriver(System.getProperty("browser","CHROME"));
    }

    @After
    public void quit(Scenario scenario)
    {
        System.out.println("BEFORE INITIALIZE: "+Thread.currentThread().getId()+"- "+
                scenario.getName());
        driver.quit();
    }
}