package com.selenium.design.strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class PayPal implements PaymentOption {

    @FindBy(id="paypal_username")
    private WebElement uname;

    @FindBy(id="paypal_password")
    private WebElement pass;

    @Override
    public void enterPaymentInformatin(Map<String, String> paymentDetails) {

        this.uname.sendKeys(paymentDetails.get("username"));
        this.pass.sendKeys(paymentDetails.get("password"));

    }
}
