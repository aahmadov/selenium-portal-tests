package com.automation.web.app.pages;

import com.automation.web.helpers.BasePage;
import com.google.inject.Inject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResults extends BasePage {

    @Inject
    public SearchResults(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'top-categories-container')]")
    private WebElement topCategoryGrid;

    @FindBy(xpath = "//span[@class='icon icon-rs_23-cross close-icon']")
    private WebElement closeSubCategoryFilterIcon;

    @FindBy(xpath = "//button[text() = 'Apply filters']")
    private WebElement applyFilterButtonOnMainScreen;

    @FindBy(xpath = "//rs-apply-button / button[@class='btn btn-primary matches-btn active']")
    private WebElement applyFilterButtonOnFilterPopUp;

    @FindBy(xpath = "//div[contains(@class, 'paginationMessage')]")
    private WebElement resultsMessage;

    @FindBy(id = "sidebar")
    private WebElement searchResultsCategoriesOnLeftSideMenu;

    public void clickOnGivenTopCategoryInSearchResults(String searchResultTopCategory) {
        closeSurveyPopUpIfExist(driver);
        topCategoryGrid.findElement(By.xpath("//a[contains(@href, '" + searchResultTopCategory + "')]")).click();
        closeSurveyPopUpIfExist(driver);
    }

    public void closeSubFilterPopUp() {
        closeSubCategoryFilterIcon.click();
        sleep(200);
    }

    public void clickApplyFiltersOnMainScreen() {
        applyFilterButtonOnMainScreen.click();
        sleep(1000);
        closeSurveyPopUpIfExist(driver);
    }

    public void printResultsMessage() {
        System.out.println("********* Search Results: " + resultsMessage.getText());
    }

    public void applyFilterFromFilterPopUp() {
        applyFilterButtonOnFilterPopUp.click();
        sleep(1000);
        closeSurveyPopUpIfExist(driver);
    }

    public void applyGivenMainFilterCategory(String mainFilterType) {
        closeSurveyPopUpIfExist(driver);
        driver.findElement(By.xpath("//a[text() = '" + mainFilterType + "']")).click();
        sleep(200);
    }

    public void applyGivenFilterSubCategory(String subFilterType) {
        driver.findElement(By.xpath("//span[@class='filterCheckboxLabelText']/span[text() = '" + subFilterType + "']")).click();
        sleep(200);
    }

    public void selectProductCategoryFromSideMenuSearchResults(String productCategory) {
        closeSurveyPopUpIfExist(driver);
        searchResultsCategoriesOnLeftSideMenu.findElement(By.xpath("//span[text() = '" + productCategory + "']")).click();
        sleep(500);
    }
}
