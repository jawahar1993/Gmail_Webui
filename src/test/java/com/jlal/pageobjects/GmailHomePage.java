package com.jlal.pageobjects;

import com.jlal.util.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailHomePage {
    public UsernameSignInPage signOut(WebDriver driver) {
        WebUtil.click(driver, By.xpath("//img[@class='gb_La gbii']"));

        WebUtil.click(driver, By.xpath("//a[@id='gb_71']"));

        WebUtil.waitForElementVisibile(driver, By.xpath("//div[text()='Signed out']"));

        return PageFactory.initElements(driver, UsernameSignInPage.class);
    }

    public boolean isInboxExist(WebDriver driver) {
        return WebUtil.isElementExist(driver, By.xpath("//a[contains(@aria-label,'Inbox')]"));

    }
}
