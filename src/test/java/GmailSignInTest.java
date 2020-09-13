import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
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
    public WebDriver driver;

    @Before
    public void startBrowser(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thoughtpooladmin\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void gmailValidLogin(){
        //1. Go to Gmail url
        driver.get("https://gmail.com");
        //2. Enter username
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@autocomplete='username']")));
        WebElement usernameTextBox = driver.findElement(By.xpath("//input[@autocomplete='username']"));
        usernameTextBox.clear();
        usernameTextBox.sendKeys("tuserfortest1@gmail.com");
        //3. Click next button
        WebElement usernameNextButton = driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
        usernameNextButton.click();
        //4. Enter password
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@autocomplete='current-password']")));
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@autocomplete='current-password']"));
        passwordTextBox.clear();
        passwordTextBox.sendKeys("$tUserForTest1$");
        //5. Click next button
        WebElement passwordNextButton = driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
        passwordNextButton.click();
        //6. Verify that user signed in
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(@aria-label,'Inbox')]")));
        Assert.assertTrue("Inbox should exist", driver.findElements(By.xpath("//a[contains(@aria-label,'Inbox')]")).size()>0);
        //7. Click sign out
        WebElement profileButton = driver.findElement(By.xpath("//img[@class='gb_La gbii']"));
        profileButton.click();

        WebElement signOutButton = driver.findElement(By.xpath("//a[@id='gb_71']"));
        signOutButton.click();
        //8. Verify that user signed out
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Signed out']")));
        Assert.assertTrue("SignedOut button should exist", driver.findElements(By.xpath("//div[text()='Signed out']")).size()>0);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
