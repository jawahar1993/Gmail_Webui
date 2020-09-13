package com.jlal.pageobjects;

import com.jlal.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordSignInPage {
    public static void enterPassword(WebDriver driver, String s) {
        WebUtil.waitForElementVisibile(driver, By.xpath("//input[@autocomplete='current-password']"));

        WebUtil.clearAndSendKeys(driver, By.xpath("//input[@autocomplete='current-password']"), s);
    }

    public static GmailHomePage clickPasswordNextButton(WebDriver driver) {
        WebUtil.click(driver, By.xpath("//div[@class='VfPpkd-RLmnJb']"));

        WebUtil.waitForElementVisibile(driver, By.xpath("//a[contains(@aria-label,'Inbox')]"));

        return PageFactory.initElements(driver, GmailHomePage.class);
    }
}
