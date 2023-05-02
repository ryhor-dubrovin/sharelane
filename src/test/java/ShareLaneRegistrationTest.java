import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShareLaneRegistrationTest extends BaseTest{

    @Test
    public void fiveDigitsZipCodeTest() {

        driver.navigate().to("https://www.sharelane.com/cgi-bin/register.py");
//        Input 5 digits to zip code field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
//        Click Continue button
        driver.findElement(By.cssSelector("[value='Continue']")).click();
//        Check Register button
        WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
        Assert.assertTrue(registerButton.isDisplayed(), "Register button isn't displayed");

    }

    @Test
    public void fourDigitsZipCodeTest() {
//        Open register page https://www.sharelane.com/cgi-bin/register.py
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
//        Input 4 digits to zip code field
        driver.findElement(By.name("zip_code")).sendKeys("1234");
//        Click Continue button
        driver.findElement(By.cssSelector("[value='Continue']")).click();
//        Check Continue button
        WebElement continueButton = driver.findElement(By.cssSelector("[value='Continue']"));
        Assert.assertTrue(continueButton.isDisplayed(), "Continue button isn't displayed");
//        Check message
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message isn't displayed");
    }

    @Test
    public void sixDigitsZipCodeTest() {
//        Open register page https://www.sharelane.com/cgi-bin/register.py
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
//        Input 6 digits to zip code field
        driver.findElement(By.name("zip_code")).sendKeys("123456");
//        Click Continue button
        driver.findElement(By.cssSelector("[value='Continue']")).click();
//        Check Continue button
        WebElement continueButton = driver.findElement(By.cssSelector("[value='Continue']"));
        Assert.assertTrue(continueButton.isDisplayed(), "Continue button isn't displayed");
//        Check message
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message isn't displayed");

    }

    @Test
    public void registerUserTest() {
//        Open register page https://www.sharelane.com/cgi-bin/register.py
        driver.navigate().to("https://www.sharelane.com/cgi-bin/register.py");
//        Input 5 digits to zip code field
        driver.findElement(By.name("zip_code")).sendKeys("12345");
//        Check Continue button
        WebElement continueButton = driver.findElement(By.cssSelector("[value='Continue']"));
        Assert.assertTrue(continueButton.isDisplayed(), "Continue button isn't displayed");
//        Click Continue button
        driver.findElement(By.cssSelector("[value='Continue']")).click();
//        Check Register button
        WebElement registerButton = driver.findElement(By.cssSelector("[value='Register']"));
        Assert.assertTrue(registerButton.isDisplayed(), "Register button isn't displayed");
//        Input first name
        driver.findElement(By.name("first_name")).sendKeys("Test");
//        Input last name
        driver.findElement(By.name("last_name")).sendKeys("User");
//        Input email
        driver.findElement(By.name("email")).sendKeys("mail@email.com");
//        Input password
        driver.findElement(By.name("password1")).sendKeys("!QWE123rty@");
//        Confirm password
        driver.findElement(By.name("password2")).sendKeys("!QWE123rty@");
//        Click Register button
        driver.findElement(By.cssSelector("[value='Register']")).click();
//        Check message
        WebElement confirmationMessage = driver.findElement(By.className("confirmation_message"));
        Assert.assertTrue(confirmationMessage.isDisplayed(), "Confirmation message isn't displayed");

    }

    @Test
    public void userLoginTest() throws InterruptedException {
        registerUserTest();
//        Find email
        WebElement elementEmail = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b"));
        String email = elementEmail.getText();
//        Find password
        WebElement elementPassword = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]"));
        String password = elementPassword.getText();

//        Open main page https://www.sharelane.com/cgi-bin/main.py
        driver.navigate().to("https://www.sharelane.com/cgi-bin/main.py");
//        Input email
        driver.findElement(By.name("email")).sendKeys(email);
//        Input password
        driver.findElement(By.name("password")).sendKeys(password);
//        Click Login button
        driver.findElement(By.cssSelector("[value='Login']")).click();

        Thread.sleep(3000);
//        Check Logout button
        WebElement logoutButton = driver.findElement(By.cssSelector("[href='./log_out.py']"));
        Assert.assertTrue(logoutButton.isDisplayed(), "Logout button isn't displayed");
    }
}