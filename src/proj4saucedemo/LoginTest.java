package proj4saucedemo;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseURL = "https://www.saucedemo.com/";

    @Before
    public void setup(){
        openBrowser(baseURL);
    }

    @Test
    public void loginWithValidCredential(){
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        WebElement verifyProduct = driver.findElement(By.className("title"));
        String actualText = verifyProduct.getText();
        String expectedText = "PRODUCTS";
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        // System.out.println("Expected = 6");
        List<WebElement> products= driver.findElements(By.className("inventory_item_name"));
        System.out.println("Number of Product displayed = "+products.size());
    }

    @After
    public void closeUp(){
        // closeBrowser();
    }
}
