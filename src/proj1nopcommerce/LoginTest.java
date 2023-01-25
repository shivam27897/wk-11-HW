package proj1nopcommerce;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseURL = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){openBrowser(baseURL);}
    @Test
    public void Test1login(){
        WebElement login =driver.findElement(By.className("ico-login"));
        login.click();

        WebElement welcomeMsg=driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualText=welcomeMsg.getText();
        String expectedText="Welcome, Please Sign In!";
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void Test2validCredential(){
        WebElement login =driver.findElement(By.className("ico-login"));
        login.click();

        WebElement emailIdField=driver.findElement(By.id("Email"));
        emailIdField.sendKeys("shivam123@gmail.com");

        WebElement passwordField=driver.findElement(By.name("Password"));
        passwordField.sendKeys("12345678");

        WebElement loginButton=driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();

        WebElement logOutLink=driver.findElement(By.className("ico-logout"));
        String actualText=logOutLink.getText();
        String expectedText="Log out";
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void Test3inValidCredential(){
        WebElement login =driver.findElement(By.className("ico-login"));
        login.click();

        WebElement emailIdField=driver.findElement(By.id("Email"));
        emailIdField.sendKeys("shivam111@gmail.com");

        WebElement passwordField=driver.findElement(By.name("Password"));
        passwordField.sendKeys("12345");

        WebElement loginButton=driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();

        WebElement errorMsg = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String actualText = errorMsg.getText().substring(0,23);
        String expectedText = "Login was unsuccessful.";
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void closeUp(){
        //closeBrowser();
    }
}