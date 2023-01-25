package proj1nopcommerce;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest extends BaseTest {
    String baseURL = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){openBrowser(baseURL);}
    @Test
    public void RegisterPage(){
        WebElement Register = driver.findElement(By.className("ico-register"));
        Register.click();
        WebElement RegisterTitle = driver.findElement(By.className("page-title"));
        String actualText = RegisterTitle.getText();
        String expectedText = "Register";
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void RegisterAccount(){
        WebElement Register = driver.findElement(By.className("ico-register"));
        Register.click();

        WebElement Gender = driver.findElement(By.id("gender-male"));
        Gender.click();

        WebElement Firstname = driver.findElement(By.id("FirstName"));
        Firstname.sendKeys("Shivam");

        WebElement Lastname = driver.findElement(By.id("LastName"));
        Lastname.sendKeys("Patel");

        WebElement Day = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        Select select = new Select(Day);
        select.selectByValue(String.valueOf(27));

        WebElement Month = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        Select select1 = new Select(Month);
        select1.selectByValue(String.valueOf(8));

        WebElement Year = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        Select select2 = new Select(Year);
        select2.selectByValue(String.valueOf(1997));

        WebElement Email = driver.findElement(By.id("Email"));
        Email.sendKeys("shivam000@gmail.com");

        WebElement CompanyName = driver.findElement(By.id("Company"));
        CompanyName.sendKeys("Elite");

        WebElement News = driver.findElement(By.id("Newsletter"));
        News.click();

        WebElement Password = driver.findElement(By.id("Password"));
        Password.sendKeys("Shivam@123");

        WebElement PasswordConfirm = driver.findElement(By.id("ConfirmPassword"));
        PasswordConfirm.sendKeys("Shivam@123");

        WebElement FinalRegister = driver.findElement(By.id("register-button"));
        FinalRegister.click();

        WebElement Continue = driver.findElement(By.xpath("//a[text()='Continue']"));
        Continue.click();

    }
    @After
    public void tearDown() {
        //closeBrowser();
    }
}
