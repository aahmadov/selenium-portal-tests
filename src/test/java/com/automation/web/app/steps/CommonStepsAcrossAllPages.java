package com.automation.web.app.steps;

import com.automation.web.app.pages.CommonAcrossAllPages;
import com.google.inject.Inject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CommonStepsAcrossAllPages {

    private final CommonAcrossAllPages commonAcrossAllPages;

    @Inject
    public CommonStepsAcrossAllPages(CommonAcrossAllPages commonAcrossAllPages) {
        this.commonAcrossAllPages = commonAcrossAllPages;
    }

    @And("^customer clicks on (.*) with in (.*) for (.*)$")
    public void clickOnFinalProductType(String finalProductType, String subProductType, String mainProductType) {
        commonAcrossAllPages.clickOnFinalProductForGivenMainProductAndSubProduct(mainProductType, subProductType, finalProductType);
    }

    @And("^customer clicks product link (.*) with in (.*) for (.*)$")
    public void clickOnProductLinkInBrandScreen(String finalProductType, String subProductType, String mainProductType) {
        commonAcrossAllPages.clickOnFinalProductTypeLinkWithMainProductAndSubProduct(mainProductType, subProductType, finalProductType);
    }

    @And("^customer adds (.*) to cart from list of products$")
    public void addProductsToCartFromProductList(String listOfProducts) {
        commonAcrossAllPages.addGivenProductsToCartFromProductListScreen(listOfProducts);
    }

    @And("^customer clicks on shopping basket icon on top right corner of screen to checkout$")
    public void clickOnBasketIcon() {
        commonAcrossAllPages.clickOnBasketIcon();
    }

    @Then("^customer should see Payment screen$")
    public void verifyPaymentScreenIsDisplayed() {
        commonAcrossAllPages.verifyPaymentScreen();
    }

    @And("^customer click on each product (.*) and click Add to basket$")
    public void clickOnProduct(String rsStockNumber) {
        commonAcrossAllPages.clickOnSpecificProduct(rsStockNumber);
        commonAcrossAllPages.addToBasketOnProductScreen();
    }

    @And("^customer clicks on view basket to checkout$")
    public void clickOnViewBasketOnProductScreen() {
        commonAcrossAllPages.viewBasketFromProductScreen();
    }
}
