package com.selenium.design.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentOptionFactory {

    public static final Supplier<PaymentOption> CC = ()-> new CreditCard();
    public static final Supplier<PaymentOption> NB = ()-> new NetBanking();
    public static final Supplier<PaymentOption> PAYPAL = ()-> new PayPal();

    public static final Map<String, Supplier<PaymentOption>> MAP = new HashMap<>();

    static{

        MAP.put("CC",CC);
        MAP.put("NB",NB);
        MAP.put("PayPal",PAYPAL);

    }

    public static PaymentOption get(String option){
        return MAP.get(option).get();
    }
}
