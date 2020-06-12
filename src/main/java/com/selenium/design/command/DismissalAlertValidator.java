package com.selenium.design.command;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DismissalAlertValidator extends ElementValidator{
    private WebElement alert;

    public DismissalAlertValidator(WebElement alert){
        this.alert= alert;

    }

    @Override
    public boolean validate()
    {
        boolean result = alert.isDisplayed();//true
        this.alert.findElement(By.cssSelector("button.close")).click();
        boolean newResult = false;

        try{
            newResult=alert.isDisplayed();//false
        }catch(Exception e){
            //skip
        }
        return result && !newResult;

    }
}
