package proj2orange;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseURL = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){openBrowser(baseURL);}

    @Test
    public void LoginWithValidCredintial(){
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']"));
        loginButton.click();

        WebElement dashboard = driver.findElement(By.className("oxd-topbar-header-breadcrumb"));
        String actualText = dashboard.getText();
        String expectedText = "Dashboard";
        Assert.assertEquals(expectedText,actualText);
    }

    @After
    public void tearDown() {
        //closeBrowser();
    }
}
