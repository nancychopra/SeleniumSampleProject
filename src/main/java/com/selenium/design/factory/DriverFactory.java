package com.selenium.design.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private static String userdir=System.getProperty("user.dir");

    private static final Map<DriverType,Supplier<WebDriver>> map = new HashMap<>();

    private static final Supplier<WebDriver> chromeDriverSupplier = ()->{
        System.setProperty("webdriver.chrome.driver",userdir + "//chromedriver");
        return new ChromeDriver();

    };

    private static final Supplier<WebDriver> firefoxDriverSupplier = ()->{
        System.setProperty("webdriver.chrome.driver",userdir + "//geckodriver");
        return new FirefoxDriver();
    };

    static{
        map.put(DriverType.CHROME,chromeDriverSupplier);
        map.put(DriverType.FIREFOX,firefoxDriverSupplier);
    }

    public static WebDriver get(DriverType type){
        return map.get(type).get();

    }
}
