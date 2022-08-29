package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {

    @FindBy(id="billing_first_name")
    private WebElement firstNameFld;

    @FindBy(id="billing_last_name")
    private WebElement lastNameFld;

    @FindBy(id="billing_address_1")
    private WebElement addressLineOneFld;

    @FindBy(id="billing_city")
    private WebElement billingCityFld;

    @FindBy(id="select2-billing_state-container")
    private WebElement billingStateFld;

    @FindBy(id="billing_postcode")
    private WebElement billingZipcodeFld;

    @FindBy(id="billing_email")
    private WebElement billingEmailFld;

    @FindBy(id="place_order")
    private WebElement finalOrderBtn;

    @FindBy(id="payment_method_bacs")
    private WebElement directBankTransferRadioBtn;

    @FindBy(id="payment_method_cod")
    private WebElement cashOnDeliveryRadioBtn;

    @FindBy(css = "div[class='woocommerce-order'] p")
    private WebElement successNotice;

    @FindBy(id="select2-billing_country-container")
    private WebElement alternateCountryDropDown;

    @FindBy(id="select2-billing_state-container")
    private WebElement alternateStateDown;

    @FindBy(id="a[class='showlogin']")
    private WebElement clickHereToLoginLink;

    @FindBy(id="username")
    private WebElement usernameFld;

    @FindBy(id="password")
    private WebElement passwordFld;

    @FindBy(id="button[value='Login']")
    private WebElement loginBtn;

    private final By overlays = By.cssSelector("blockUI blockOverlay");

    public CheckoutPage(WebDriver driver)
    {
         super(driver);
    }

    public CheckoutPage enterFirstName(String firstName)
    {
        WebElement txt_firstName = waitForElementToBeVisible(firstNameFld);
        txt_firstName.clear();
        txt_firstName.sendKeys(firstName);
        return this;
    }

    public CheckoutPage enterLastName(String lastName)
    {
        WebElement txt_lastName = waitForElementToBeVisible(lastNameFld);
        txt_lastName.clear();
        txt_lastName.sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterAddressLineOne(String address)
    {
        WebElement txt_address = waitForElementToBeVisible(addressLineOneFld);
        txt_address.clear();
        txt_address.sendKeys(address);
        return this;
    }

    public CheckoutPage selectCountry(String country)
    {
        waitForElementToBeClickable(alternateCountryDropDown).click();
        WebElement e = waitForElementToBeClickable(By.xpath("//li[text()='"+country+"']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",e);
        e.click();
        return this;
    }

    public CheckoutPage selectState(String state)
    {
        waitForElementToBeClickable(alternateStateDown).click();
        WebElement e = waitForElementToBeClickable(By.xpath("//li[text()='"+state+"']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",e);
        e.click();
        return this;
    }

    public CheckoutPage enterCity(String city)
    {
        WebElement txt_City = waitForElementToBeVisible(billingCityFld);
        txt_City.clear();
        txt_City.sendKeys(city);
        return this;
    }

    public CheckoutPage enterZipcode(String zipcode)
    {
        WebElement txt_Zipcode = waitForElementToBeVisible(billingZipcodeFld);
        txt_Zipcode.clear();
        txt_Zipcode.sendKeys(zipcode);
        return this;
    }

    public CheckoutPage enterEmailAddress(String emailAddress)
    {
        WebElement txt_Email = waitForElementToBeVisible(billingEmailFld);
        txt_Email.clear();
        txt_Email.sendKeys(emailAddress);
        return this;
    }

    public CheckoutPage selectDirectBankTransfer()
    {
        WebElement e = waitForElementToBeClickable(directBankTransferRadioBtn);
        if(!e.isSelected())
            e.click();
        return this;
    }

//    public CheckoutPage setBillingAddress(BillingAddress billingAddress)
//    {
//        return
//                enterFirstName(billingAddress.getFirstName()).
//                enterLastName(billingAddress.getLastName()).
//                enterAddressLineOne(billingAddress.getAddressLineOne()).
//                selectCountry(billingAddress.getCountry()).
//                enterCity(billingAddress.getCity()).
//                selectState(billingAddress.getState()).
//                enterZipcode(billingAddress.getPostcode()).
//                enterEmailAddress(billingAddress.getEmail());
//    }

    public CheckoutPage placeOrder()
    {
        waitForOverlaysToDisappear(overlays);
        clickForcefully(finalOrderBtn);
        waitForOverlaysToDisappear(overlays);
        return this;
    }

    public CheckoutPage enterUserName(String userName)
    {
        WebElement txt_username = waitForElementToBeVisible(usernameFld);
        txt_username.clear();
        txt_username.sendKeys(userName);
        return this;
    }

    public CheckoutPage enterPassword(String password)
    {
        WebElement txt_Password = waitForElementToBeVisible(passwordFld);
        txt_Password.clear();
        txt_Password.sendKeys(password);
        return this;
    }

    public CheckoutPage clickHereToLogin()
    {
        waitForElementToBeClickable(clickHereToLoginLink).click();
        return this;
    }

    public CheckoutPage clickLogin()
    {
        waitForElementToBeClickable(loginBtn).click();
        return this;
    }
//
//    public CheckoutPage login(User user)
//    {
//        return
//                enterUserName(user.getUsername()).
//                enterPassword(user.getPassword()).
//                clickLogin();
//    }

    public String getNotice()
    {
        return waitForElementToBeVisible(successNotice).getText();
    }
}