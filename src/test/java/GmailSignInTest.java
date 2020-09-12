import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class GmailSignInTest {
    WebDriver driver = new FirefoxDriver();
    @Test
    public void gmailValidLogin(){
        //1. Go to Gmail url
        driver.get("https://gmail.com");
        //2. Enter username
        WebElement usernameTextBox = driver.findElement(By.id("Email"));
        usernameTextBox.clear();
        usernameTextBox.sendKeys("tuserfortest1@gmail.com");
        //3. Enter password
        WebElement passwordTextBox = driver.findElement(By.id("Passwd"));
        passwordTextBox.clear();
        passwordTextBox.sendKeys("$tUserForTest1$");
        //4. Click sign in
        WebElement signInButton = driver.findElement(By.id("SignIn"));
        signInButton.click();
        //5. Verify that user signed in
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.partialLinkText("Inbox")));
        Assert.assertTrue("Inbox should exist", driver.findElements(By.partialLinkText("Inbox")).size()>0);
        //6. Click sign out
        WebElement profileButton = driver.findElement(By.cssSelector("span[class='gb_da gbii']"));
        profileButton.click();

        WebElement signOutButton = driver.findElement(By.id("gb_71"));
        signOutButton.click();
        //7. Verify that user signed out
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("signIn")));
        Assert.assertTrue("SignIn button should exist", driver.findElements(By.id("signIn")).size()>0);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
