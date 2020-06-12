package com.selenium.design.command;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class NotificationValidator  extends ElementValidator{

    private WebElement button;
    private WebElement alert;

    public NotificationValidator(WebElement button, WebElement notificationAlert){
        this.button= button;
        this.alert= notificationAlert;

    }

    @Override
    public boolean validate()
    {
        this.button.click();
        boolean result = this.alert.isDisplayed();//true
        Uninterruptibles.sleepUninterruptibly(4, TimeUnit.SECONDS);
        boolean newresult = this.alert.isDisplayed();//false

        return result && !newresult;

    }
}
