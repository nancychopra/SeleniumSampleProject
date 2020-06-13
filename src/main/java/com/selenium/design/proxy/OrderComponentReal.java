package com.selenium.design.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderComponentReal implements OrderComponent {

    @FindBy(id="buy")
    private WebElement buy;

    @FindBy(id="ordernumber")
    private WebElement ordernumber;

    @FindBy(id="email")
    private WebElement email;

    public OrderComponentReal(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @Override
    public String order(){
        this.buy.click();
        return this.ordernumber.getText();
    }
}
