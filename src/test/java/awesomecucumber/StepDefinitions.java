package awesomecucumber;

import awesomecucumber.constants.Myconstants;
import awesomecucumber.domainobjects.BillingDetails;
import awesomecucumber.domainobjects.Product;
import awesomecucumber.factory.DriverFactory;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.CheckoutPage;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;

public class StepDefinitions {
    private WebDriver driver;
    private BillingDetails billingDetails;

    @Given("I'm on store page")
    public void i_m_on_store_page() throws FileNotFoundException {
        System.out.println("STORE PAGE");
        System.out.println(System.getProperty("user.dir"));
        driver = DriverFactory.getDriver();
        new StorePage(driver).load(Myconstants.STORE);
    }

    @When("I add {product} to the cart")
    public void i_add_to_the_cart(Product product) {
        new StorePage(driver).addCartToBtn(product.getName());
    }

    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(int expectedQuantity, Product product) {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(expectedQuantity, cartPage.getProductQuantity());
        Assert.assertEquals(product.getName(), cartPage.getProductName());
    }

    @Given("I'm a guest customer")
    public void i_m_a_guest_customer() throws FileNotFoundException {
        driver = DriverFactory.getDriver();
        new StorePage(driver).load(Myconstants.STORE);
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
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
    public void i_provide_the_billing_details() {

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setBillingAddress(billingDetails);
    }

    @When("I place an order")
    public void i_place_an_order() {
        new CheckoutPage(driver).placeOrder();
    }

    @Then("order should be placed successfully")
    public void order_should_be_placed_successfully()
    {
        Assert.assertEquals(new CheckoutPage(driver).getNotice(),"Thank you. Your order has been received.");
    }
}