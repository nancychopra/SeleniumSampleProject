package com.selenium.design.strategy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class NetBanking implements PaymentOption {

    @FindBy(id="bank")
    private WebElement bank;

    @FindBy(id="acc_number")
    private WebElement acc_number;

    @FindBy(id="pin")
    private WebElement pin;




    @Override
    public void enterPaymentInformatin(Map<String, String> paymentDetails) {
        Select bank = new Select(this.bank);
        bank.selectByValue(paymentDetails.get("bank"));
        this.acc_number.sendKeys(paymentDetails.get("acc_number"));
        this.pin.sendKeys(paymentDetails.get("pin"));

    }
}
