import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShareLaneRegistrationTest {
    WebDriver driver;

    @Test
    public void fiveDigitsZipCodeTest() {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        driver = new ChromeDriver();
//        Open register page https://www.sharelane.com/cgi-bin/register.py
//        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.navigate().to("https://www.sharelane.com/cgi-bin/register.py");
//        Input 5 digits to zip code field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
//        Click Continue button
        driver.findElement(By.cssSelector("[value='Continue']")).click();
//        Check Register button
        WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
        Assert.assertTrue(registerButton.isDisplayed(), "Register button isn't displayed");
    }


}
