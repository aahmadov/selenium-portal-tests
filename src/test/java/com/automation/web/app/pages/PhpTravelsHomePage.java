package com.automation.web.app.pages;

import com.automation.web.helpers.BasePage;
import com.google.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhpTravelsHomePage extends BasePage {

    @Inject
    public PhpTravelsHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Sign up")
    private WebElement signUp;

    public void ClickOnSignUp()
    {
        signUp.click();
    }
}
