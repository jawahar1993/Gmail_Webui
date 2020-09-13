package com.jlal.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordSignInPage {
    public static void enterPassword(WebDriver driver, String s) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@autocomplete='current-password']")));
        WebElement passwordTextBox = driver.findElement(By.xpath("//input[@autocomplete='current-password']"));
        passwordTextBox.clear();
        passwordTextBox.sendKeys(s);
    }

    public static GmailHomePage clickPasswordNextButton(WebDriver driver) {
        WebElement nextButton = driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
        nextButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(@aria-label,'Inbox')]")));
        return PageFactory.initElements(driver, GmailHomePage.class);
    }
}
