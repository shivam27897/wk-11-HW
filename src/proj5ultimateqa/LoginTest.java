package proj5ultimateqa;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseURL = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseURL);
    }

    @Test
    public void loginPage(){
        WebElement login = driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        login.click();

        WebElement verifyMsg = driver.findElement(By.xpath("//h2[@class='page__heading']"));
        String actualMsg = verifyMsg.getText();
        String expectedMsg = "Welcome Back!";
        Assert.assertEquals(expectedMsg,actualMsg);
    }

    @Test
    public void verifyErrorMsg(){
        WebElement login = driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        login.click();

        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("shivam123@gmail.com");

        WebElement passField = driver.findElement(By.id("user[password]"));
        passField.sendKeys("123456");

        WebElement loginButton = driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']"));
        loginButton.click();

        WebElement verifyMsg = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualMsg = verifyMsg.getText();
        String expectedMsg = "Invalid email or password.";
        Assert.assertEquals(expectedMsg,actualMsg);
    }

    @After
    public void closeUp(){
        // closeBrowser();
    }
}
