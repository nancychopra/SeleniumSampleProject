package com.selenium.design.test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.selenium.design.factory.DriverFactory;
import com.selenium.design.factory.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;


    @BeforeTest
    public void setupDriver(){
        this.driver = DriverFactory.get(DriverType.FIREFOX);

    }

    @AfterTest
    public void quitDriver(){

        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        this.driver.quit();
    }



}
