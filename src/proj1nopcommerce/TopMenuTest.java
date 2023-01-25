package proj1nopcommerce;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseURL = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){openBrowser(baseURL);}
    @Test
    public void Test1Computer(){
        WebElement Computer = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Computers ']"));
        Computer.click();

        WebElement CompTitle = driver.findElement(By.className("page-title"));
        String actualText=CompTitle.getText();
        String expectedText="Computers";
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void Test2Electronics(){
        WebElement Electronics = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Electronics ']"));
        Electronics.click();

        WebElement ElectTitle = driver.findElement(By.className("page-title"));
        String actualText=ElectTitle.getText();
        String expectedText="Electronics";
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void Test3Apparel(){
        WebElement Apparel = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Apparel ']"));
        Apparel.click();

        WebElement AppTitle = driver.findElement(By.className("page-title"));
        String actualText=AppTitle.getText();
        String expectedText="Apparel";
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void Test4DigitalDownloads(){
        WebElement DD = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Digital downloads ']"));
        DD.click();

        WebElement DDTitle = driver.findElement(By.className("page-title"));
        String actualText=DDTitle.getText();
        String expectedText = "Digital downloads";
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void Test5Books(){
        WebElement Books = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Books ']"));
        Books.click();

        WebElement BooksTitle = driver.findElement(By.className("page-title"));
        String actualText=BooksTitle.getText();
        String expectedText = "Books";
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void Test6Jewelry(){
        WebElement Jewelery = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Jewelry ']"));
        Jewelery.click();

        WebElement JeweleryTitle = driver.findElement(By.className("page-title"));
        String actualText = JeweleryTitle.getText();
        String expectedText="Jewelry";
        Assert.assertEquals(expectedText,actualText);
    }

    @Test
    public void Test7GiftCards(){
        WebElement Gift = driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[text()='Gift Cards ']"));
        Gift.click();

        WebElement GiftTitle = driver.findElement(By.className("page-title"));
        String actualText = GiftTitle.getText();
        String expectedText = "Gift Cards";
        Assert.assertEquals(expectedText,actualText);
    }

    @After
    public void tearDown() {
        //closeBrowser();
    }
}
