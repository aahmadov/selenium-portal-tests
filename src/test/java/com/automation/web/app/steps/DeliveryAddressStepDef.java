package com.automation.web.app.steps;

import com.automation.web.app.pages.DeliveryAddress;
import com.google.inject.Inject;
import io.cucumber.java.en.And;

public class DeliveryAddressStepDef {

    private final DeliveryAddress deliveryAddress;

    @Inject
    public DeliveryAddressStepDef(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @And("^customer fills in Delivery with Title (.*), FirstName (.*), SurName (.*) and ContactNumber (.*)$")
    public void fillDeliveryContactDetails(String title, String firstName, String surName, String contactNumber) {
        deliveryAddress.enterPersonalAndContactDetails(title, firstName, surName, contactNumber);
    }

    @And("^fill address with Name (.*), TradingName (.*), AddressLine1 (.*), AddressLine2(.*), Town (.*), County(.*) and PostCode (.*) and continue to payment$")
    public void fillDeliveryAddressAndContinueToPayment(String name, String tradingName, String addressLine1, String addressLine2, String town, String County, String postCode) {
        deliveryAddress.enterDeliveryAddress(name, tradingName, addressLine1, addressLine2, town, County, postCode);
        deliveryAddress.clickOnContinueToPayment();
    }

    @And("^verify customer has delivery address and continue to payment$")
    public void verifyDeliveryAddressIsSelected() {
        deliveryAddress.verifyDeliveryAddressIsSelectedForCustomer();
        deliveryAddress.clickOnContinueToPayment();
    }

}
