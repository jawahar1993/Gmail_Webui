import com.jlal.pageobjects.GmailHomePage;
import com.jlal.pageobjects.PasswordSignInPage;
import com.jlal.pageobjects.UsernameSignInPage;
import com.jlal.util.WebUtil;
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
        UsernameSignInPage usernameSignInPage = WebUtil.goToSignInPage(driver);

        //2. Enter username
        usernameSignInPage.enterUsername(driver, "tuserfortest1@gmail.com");

        //3. Click next button
        PasswordSignInPage passwordSignInPage = usernameSignInPage.clickUsernameNextButton(driver);

        //4. Enter password
        passwordSignInPage.enterPassword(driver, "$tUserForTest1$");

        //5. Click next button
        GmailHomePage gmailHomePage = passwordSignInPage.clickPasswordNextButton(driver);

        //6. Verify that user signed in
        Assert.assertTrue("Inbox should exist", gmailHomePage.isInboxExist(driver));

        //7. Click sign out
        usernameSignInPage= gmailHomePage.signOut(driver);

        //8. Verify that user signed out
        Assert.assertTrue("SignedOut button should exist", usernameSignInPage.isSignedOut(driver));

    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
