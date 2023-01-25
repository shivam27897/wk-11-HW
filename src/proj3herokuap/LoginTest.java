package proj3herokuap;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseURL = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup(){
        openBrowser(baseURL);
    }

    @Test
    public void loginWithValidCredentials(){
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        WebElement login = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        login.click();

        WebElement verifyLogin = driver.findElement(By.xpath("//h2[text()=' Secure Area']"));
        System.out.println(verifyLogin);
        String actualText = verifyLogin.getText();
        String expectedText = "Secure Area";
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void verifyUsernameErrorMessage(){
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith1");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        WebElement login = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        login.click();

        WebElement verifyErrorMsg = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualText = verifyErrorMsg.getText().substring(0,25);
        String expectedText = "Your username is invalid!";
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void verifyPasswordMessage(){
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword");

        WebElement login = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        login.click();

        WebElement verifyErrorMsg = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualText = verifyErrorMsg.getText().substring(0,25);
        String expectedText = "Your password is invalid!";
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void tearDown() {
        //closeBrowser();
    }
}
