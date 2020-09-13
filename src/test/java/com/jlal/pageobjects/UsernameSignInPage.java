package com.jlal.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsernameSignInPage {

    public static void enterUsername(WebDriver driver, String s) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@autocomplete='username']")));
        WebElement usernameTextBox = driver.findElement(By.xpath("//input[@autocomplete='username']"));
        usernameTextBox.clear();
        usernameTextBox.sendKeys(s);
    }

    public static PasswordSignInPage clickUsernameNextButton(WebDriver driver) {
        WebElement nextButton = driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']"));
        nextButton.click();

        return PageFactory.initElements(driver, PasswordSignInPage.class);
    }

    public boolean isSignedOut(WebDriver driver) {
        return driver.findElements(By.xpath("//div[text()='Signed out']")).size()>0;
    }
}
