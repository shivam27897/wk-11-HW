package proj2orange;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    String baseURL = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void ForgotPassword() {
        WebElement forgotpass = driver.findElement(By.className("orangehrm-login-forgot"));
        forgotpass.click();

        WebElement ForgotVerify =driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']"));
        String actualText = ForgotVerify.getText();
        String expectedText = "Reset Password";
        Assert.assertEquals(expectedText,actualText);
    }

    @After
    public void tearDown() {
        //closeBrowser();
    }
}
