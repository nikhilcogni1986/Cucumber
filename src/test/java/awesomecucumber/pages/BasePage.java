package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage
{
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void load(String baseUrl)
    {
        driver.get(baseUrl);
    }

    public WebElement waitForElementToBeVisible(WebElement element)
    {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeClickable(WebElement element)
    {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementToBeClickable(By by)
    {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForOverlaysToDisappear(By overlay)
    {
        List<WebElement> overlay_element = driver.findElements(overlay);
        if(overlay_element.size()>0)
        {
            System.out.println("Overlay elements: "+overlay_element.size());
            wait.until(ExpectedConditions.invisibilityOfAllElements(overlay_element));
            System.out.println("OVERLAYS ARE INVISIBLE");
        }
        else
            System.out.println("NO OVERLAYS FOUND");
    }

    public void clickForcefully(WebElement element)
    {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
}