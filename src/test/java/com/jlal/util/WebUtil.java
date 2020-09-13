package com.jlal.util;

import com.jlal.pageobjects.UsernameSignInPage;
import com.jlal.pageobjects.UsernameSignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WebUtil {

    public static UsernameSignInPage goToSignInPage(WebDriver driver) {
        driver.get("https://gmail.com");
        return PageFactory.initElements(driver, UsernameSignInPage.class);
    }
}
