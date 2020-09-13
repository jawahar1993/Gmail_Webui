package com.jlal.util;

import com.jlal.pageobjects.UsernameSignInPage;
import com.jlal.pageobjects.UsernameSignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtil {
    final static int wait_time_out = 30;

    public static UsernameSignInPage goToSignInPage(WebDriver driver) {
        driver.get("https://gmail.com");
        return PageFactory.initElements(driver, UsernameSignInPage.class);
    }

    public static void click(WebDriver driver, By xpath) {
        WebElement element = driver.findElement(xpath);
        element.click();
    }

    public static void waitForElementVisibile(WebDriver driver, By xpath) {
        WebDriverWait wait = new WebDriverWait(driver, wait_time_out);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpath));
    }

    public static boolean isElementExist(WebDriver driver, By xpath) {
        return driver.findElements(xpath).size()>0;
    }

    public static void clearAndSendKeys(WebDriver driver, By xpath, String s) {
        WebElement elementTextBox = driver.findElement(xpath);
        elementTextBox.clear();
        elementTextBox.sendKeys(s);
    }
}
