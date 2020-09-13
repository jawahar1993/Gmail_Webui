package com.jlal.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailHomePage {
    public UsernameSignInPage signOut(WebDriver driver) {
        WebElement profileButton = driver.findElement(By.xpath("//img[@class='gb_La gbii']"));
        profileButton.click();

        WebElement signOutButton = driver.findElement(By.xpath("//a[@id='gb_71']"));
        signOutButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[text()='Signed out']")));
        return PageFactory.initElements(driver, UsernameSignInPage.class);
    }

    public boolean isInboxExist(WebDriver driver) {
        return driver.findElements(By.xpath("//a[contains(@aria-label,'Inbox')]")).size()>0;
    }
}
