package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StorePage extends BasePage
{
    @FindBy(css="a[title='View cart']")
    private WebElement viewCartBtn;

    @FindBy(css = "button[value='Search']")
    private WebElement searchBtn;

    @FindBy(css = "#woocommerce-product-search-field-0")
    private WebElement searchFld;

    private By title = By.cssSelector(".woocommerce-products-header h1");

    public StorePage(WebDriver driver)
    {
        super(driver);
    }

    public StorePage enterTextInSearchFld(String searchTxt)
    {
        WebElement txtSearch = waitForElementToBeClickable(searchFld);
        txtSearch.clear();
        txtSearch.sendKeys(searchTxt);
        return this;
    }

    public void clickSearchBtn()
    {
        waitForElementToBeClickable(searchBtn).click();
    }

    public StorePage search(String txt)
    {
        enterTextInSearchFld(txt).
        clickSearchBtn();
        return this;
    }

    private By getAddCartToBtn(String productName)
    {
        return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
    }

    public void addCartToBtn(String productName)
    {
        System.out.println(productName);
        waitForElementToBeClickable(getAddCartToBtn(productName));
        driver.findElement(getAddCartToBtn(productName)).click();
        waitForElementToBeClickable(viewCartBtn).click();
    }

    public String getTitle(String expectedTitle)
    {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.textToBe(title, expectedTitle));
        return driver.findElement(title).getText();
    }
}