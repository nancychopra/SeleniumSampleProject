package com.selenium.design.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserInformation {

    @FindBy(id="fn")
    private WebElement fstName;

    @FindBy(id="ln")
    private WebElement lstName;

    @FindBy(id="email")
    private WebElement email;


    public UserInformation(WebDriver driver){
        PageFactory.initElements(driver,this);

    }

    public void enterPersonalDetails(String firstName,String lastName,String email){
        this.fstName.sendKeys(firstName);
        this.lstName.sendKeys(lastName);
        this.email.sendKeys(email);
    }


}
