package com.jlal.pageobjects;

import com.jlal.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsernameSignInPage {

    public static void enterUsername(WebDriver driver, String s) {
        WebUtil.waitForElementVisibile(driver, By.xpath("//input[@autocomplete='username']"));

        WebUtil.clearAndSendKeys(driver, By.xpath("//input[@autocomplete='username']"), s);
    }

    public static PasswordSignInPage clickUsernameNextButton(WebDriver driver) {
        WebUtil.click(driver, By.xpath("//div[@class='VfPpkd-RLmnJb']"));

        return PageFactory.initElements(driver, PasswordSignInPage.class);
    }

    public boolean isSignedOut(WebDriver driver) {
        return WebUtil.isElementExist(driver, By.xpath("//div[text()='Signed out']"));

    }
}
