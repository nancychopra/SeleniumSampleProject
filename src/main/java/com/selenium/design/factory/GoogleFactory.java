package com.selenium.design.factory;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class GoogleFactory {

    public static final Function<WebDriver,GooglePage> ENG = (d)->new GoogleEnglish(d);
    public static final Function<WebDriver,GooglePage> FR = (d)->new GoogleFrench(d);
    public static final Function<WebDriver,GooglePage> SA = (d)->new GoogleArabic(d);
    public static final Function<WebDriver,GooglePage> ES = (d)->new GoolgeES(d);

    public static final Map<String,Function<WebDriver,GooglePage>> map = new HashMap<>();

    static{
        map.put("ENG",ENG);
        map.put("SA",SA);
        map.put("FR",FR);
        map.put("ES",ES);
    }

    public static GooglePage get(String language, WebDriver driver){

        return map.get(language).apply(driver);

    }

}
