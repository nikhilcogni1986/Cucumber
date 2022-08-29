package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage
{
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath="//a[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckoutBtn;

    @FindBy(css = "td[class='product-name']>a")
    private WebElement productName;

    @FindBy(css = "input[title='Qty']")
    private WebElement productQuantity;

    public CartPage(WebDriver driver)
    {
        super(driver);
    }

    public String getProductName()
    {
        return waitForElementToBeVisible(productName).getText();
    }

    public int getProductQuantity()
    {
        return Integer.parseInt(waitForElementToBeVisible(productQuantity).getAttribute("value"));
    }

    public void checkout()
    {
        waitForElementToBeClickable(proceedToCheckoutBtn).click();
    }
}