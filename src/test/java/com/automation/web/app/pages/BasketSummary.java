package com.automation.web.app.pages;

import com.automation.web.helpers.BasePage;
import com.google.inject.Inject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasketSummary extends BasePage {
    @Inject
    public BasketSummary(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "checkoutSecurelyAndPuchBtn")
    private WebElement checkOutSeccurelyButton;

    @FindBy(className = "emailAddress")
    private WebElement guestEmailAdderss;

    @FindBy(id = "guestCheckoutForm:guestCheckout")
    private WebElement guestCheckOutButton;

    @FindBy(id = "alreadyRegisteredForm:continue")
    private List<WebElement> alreadyRegisteredGuestContinueButtonExist;

    @FindBy(id = "alreadyRegisteredForm:continue")
    private WebElement alreadyRegisteredGuestContinueButton;

    @FindBy(id = "clearBasketButton")
    private WebElement clearAllItemsInBasketButton;

    @FindBy(id = "confirmDeleteContinue")
    private WebElement confirmDeleteButton;


    public void verifyProductsAdded(String stockNumbersOfProductsAdded) {
        closeSurveyPopUpIfExist(driver);
        sleep(500);
        if (stockNumbersOfProductsAdded.trim().contains(",")) {
            String multiProductList[] = stockNumbersOfProductsAdded.split((","));
            int index = 1;
            for (String stockNumber : multiProductList) {
                verifyGivenMultipleStockNumbersPresentInBasketSummary(stockNumber, index);
                index += 1;
            }
        } else {
            verifyGivenStockNumberPresentInBasketSummary(stockNumbersOfProductsAdded);
        }

    }

    private void verifyGivenMultipleStockNumbersPresentInBasketSummary(String stockNumber, int index) {
        closeSurveyPopUpIfExist(driver);
        Assert.assertTrue(driver.findElement(By.xpath("(//span[@class='labelText right5']/following-sibling::span[@class='textTitle'])[" + index + "]")).getText().equalsIgnoreCase(stockNumber));
    }

    private void verifyGivenStockNumberPresentInBasketSummary(String stockNumber) {
        closeSurveyPopUpIfExist(driver);
        Assert.assertTrue(driver.findElement(By.cssSelector(".labelText + .textTitle")).getText().equalsIgnoreCase(stockNumber));
    }

    public void clickOnCheckOutSecurely() {
        closeSurveyPopUpIfExist(driver);
        checkOutSeccurelyButton.click();
    }

    public void enterEmailAddressAndGuestCheckout(String emailAddress) {
        guestEmailAdderss.sendKeys(emailAddress);
        guestCheckOutButton.click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        if (alreadyRegisteredGuestContinueButtonExist.size() > 0) alreadyRegisteredGuestContinueButton.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void emptyBasket() {
        closeSurveyPopUpIfExist(driver);
        clearAllItemsInBasketButton.click();
        confirmDeleteButton.click();
    }


}
