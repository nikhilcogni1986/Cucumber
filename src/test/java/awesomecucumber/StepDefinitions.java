package awesomecucumber;

import awesomecucumber.factory.DriverFactory;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.CheckoutPage;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class StepDefinitions {
    private WebDriver driver;

    @Given("I'm on store page")
    public void i_m_on_store_page() {
        System.out.println("STORE PAGE");
        System.out.println(System.getProperty("user.dir"));
        driver = DriverFactory.getDriver();
        new StorePage(driver).load("https://askomdch.com/store");
    }

    @When("I add {string} to the cart")
    public void i_add_to_the_cart(String productName) {
        new StorePage(driver).addCartToBtn(productName);
    }

    @Then("I should see {int} {string} in the cart")
    public void i_should_see_in_the_cart(int expectedQuantity, String expectedProductName) {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(expectedQuantity, cartPage.getProductQuantity());
        Assert.assertEquals(expectedProductName, cartPage.getProductName());
    }

    @Given("I'm a guest customer")
    public void i_m_a_guest_customer() {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load("https://askomdch.com");
    }

    @When("I have a product in the cart")
    public void i_have_a_product_in_the_cart() {
        new StorePage(driver).addCartToBtn("Blue Shoes");
    }

    @When("I'm on the checkout page")
    public void i_m_on_the_checkout_page() {
        new CartPage(driver).checkout();
    }

    @When("I provide the billing details")
    public void i_provide_the_billing_details(List<Map<String, String>> billingDetails) {

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.enterFirstName(billingDetails.get(0).get("firstname"));
        checkoutPage.enterLastName(billingDetails.get(0).get("lastname"));
        checkoutPage.enterAddressLineOne(billingDetails.get(0).get("address_line1"));
        checkoutPage.enterCity(billingDetails.get(0).get("city"));
        checkoutPage.selectState(billingDetails.get(0).get("state"));
        checkoutPage.enterZipcode(billingDetails.get(0).get("zip"));
        checkoutPage.enterEmailAddress(billingDetails.get(0).get("email"));
    }

    @When("I place an order")
    public void i_place_an_order() {
        new CheckoutPage(driver).placeOrder();
    }

    @Then("order should be placed successfully")
    public void order_should_be_placed_successfully() {
        String actualText = driver.findElement(By.cssSelector("div[class='woocommerce-order'] p")).getText();
        Assert.assertEquals("Thank you. Your order has been received.", actualText);
    }
}