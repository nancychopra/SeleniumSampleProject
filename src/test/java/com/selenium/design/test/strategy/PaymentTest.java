package com.selenium.design.test.strategy;

import com.google.common.util.concurrent.Uninterruptibles;
import com.selenium.design.strategy.*;
import com.selenium.design.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PaymentTest extends BaseTest {

    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setup(){
        this.paymentScreen= new PaymentScreen(this.driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(String option, Map<String,String> paymentDetails){
        paymentScreen.goTo();
        paymentScreen.getUserInformation().enterPersonalDetails("Nancy","Chopra","nn@nn.com");
        paymentScreen.setPaymentOption(PaymentOptionFactory.get(option));
        paymentScreen.getPaymentOption().enterPaymentInformatin(paymentDetails);
        String orderNo= paymentScreen.getOrder().order();
        System.out.println(orderNo);
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

    }

    @DataProvider
    public Object[][] getData(){
        Map<String,String> cc = new HashMap<>();
        cc.put("cc","123233444");
        cc.put("year","1980");
        cc.put("cvv","123");

        Map<String,String> nb = new HashMap<>();
        nb.put("bank","WELLS FARGO");
        nb.put("acc_number","19454545580");
        nb.put("pin","2233");

        Map<String,String> paypal = new HashMap<>();
        paypal.put("username","nchopra");
        paypal.put("password","something");

        return new Object[][]{
                {"CC",cc},
                {"NB",nb},
                {"PayPal",paypal}
        };

    }
}
