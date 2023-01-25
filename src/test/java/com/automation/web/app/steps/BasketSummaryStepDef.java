package com.automation.web.app.steps;

import com.automation.web.app.pages.BasketSummary;
import com.automation.web.app.pages.CommonAcrossAllPages;
import com.google.inject.Inject;
import io.cucumber.java.en.And;

public class BasketSummaryStepDef {

    private final BasketSummary basketSummary;

    private final CommonAcrossAllPages commonAcrossAllPages;

    @Inject
    public BasketSummaryStepDef(BasketSummary basketSummary, CommonAcrossAllPages commonAcrossAllPages) {
        this.basketSummary = basketSummary;
        this.commonAcrossAllPages = commonAcrossAllPages;
    }

    @And("^customer verifies all added products (.*) displayed in basket summary screen$")
    public void verifyProductsAdded(String stockNumbersOfProductsAdded) {
        basketSummary.verifyProductsAdded(stockNumbersOfProductsAdded);
    }

    @And("^customer clicks on Checkout securely$")
    public void checkOutSecurely() {
        basketSummary.clickOnCheckOutSecurely();
    }

    @And("^customer chooses Guest checkout after entering email address (.*)$")
    public void guestCheckout(String emailAddress) {
        basketSummary.enterEmailAddressAndGuestCheckout(emailAddress);
    }

    @And("^check customer basket and empty basket if there are items$")
    public void emptyCustomerBasket() {
        if (commonAcrossAllPages.numberOfItemsInBasket() > 0) {
            commonAcrossAllPages.clickOnBasketIcon();
            basketSummary.emptyBasket();
        }
    }
}
