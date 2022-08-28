package awesomecucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class StepDefinitions
{
    private WebDriver driver;
    @Given("I'm on store page")
    public void i_m_on_store_page() {
        System.out.println("STORE PAGE");
        System.out.println(System.getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver","F:\\CucumberFramework\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
         driver.get("https://askomdch.com/store");

    }

    @When("I add {string} to the cart")
    public void i_add_to_the_cart(String productName) throws InterruptedException {
        driver.findElement(By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[title='View cart']")).click();
    }

    @Then("I should see {int} {string} in the cart")
    public void i_should_see_in_the_cart(int expectedQuantity, String expectedProductName)
    {
        String actualProductName = driver.findElement(By.cssSelector("td.product-name a")).getText();
        String productQuantity = driver.findElement(By.cssSelector("input[title='Qty']")).getAttribute("value");

        Assert.assertEquals(String.valueOf(expectedQuantity),productQuantity);
        Assert.assertEquals(expectedProductName,actualProductName);
    }

    @Given("I'm a guest customer")
    public void i_m_a_guest_customer()
    {
        System.setProperty("webdriver.chrome.driver","F:\\CucumberFramework\\src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://askomdch.com/store/");
    }
    @When("I have a product in the cart")
    public void i_have_a_product_in_the_cart() throws InterruptedException {
        driver.findElement(By.cssSelector("a[aria-label='Add “Blue Shoes” to your cart']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("a[title='View cart']")).click();
    }
    @When("I'm on the checkout page")
    public void i_m_on_the_checkout_page() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Proceed to checkout')]")).click();
        Thread.sleep(2000);
    }
    @When("I provide the billing details")
    public void i_provide_the_billing_details(List<Map<String,String>> billingDetails)
    {
        driver.findElement(By.id("billing_first_name")).clear();
        driver.findElement(By.id("billing_first_name")).sendKeys(billingDetails.get(0).get("firstname"));

        driver.findElement(By.id("billing_last_name")).clear();
        driver.findElement(By.id("billing_last_name")).sendKeys(billingDetails.get(0).get("lastname"));

        driver.findElement(By.id("billing_address_1")).clear();
        driver.findElement(By.id("billing_address_1")).sendKeys(billingDetails.get(0).get("address_line1"));

        driver.findElement(By.id("billing_city")).clear();
        driver.findElement(By.id("billing_city")).sendKeys(billingDetails.get(0).get("city"));

        Select stateDropDown = new Select(driver.findElement(By.id("billing_state")));
        stateDropDown.selectByVisibleText(billingDetails.get(0).get("state"));

        driver.findElement(By.id("billing_postcode")).clear();
        driver.findElement(By.id("billing_postcode")).sendKeys(billingDetails.get(0).get("zip"));

        driver.findElement(By.id("billing_email")).clear();
        driver.findElement(By.id("billing_email")).sendKeys(billingDetails.get(0).get("email"));

    }
    @When("I place an order")
    public void i_place_an_order() throws InterruptedException {
        driver.findElement(By.id("place_order")).click();
        Thread.sleep(2000);
    }
    @Then("order should be placed successfully")
    public void order_should_be_placed_successfully()
    {
        String actualText = driver.findElement(By.cssSelector("div[class='woocommerce-order'] p")).getText();
        Assert.assertEquals("Thank you. Your order has been received.",actualText);
    }
}