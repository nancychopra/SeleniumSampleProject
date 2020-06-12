package com.selenium.design.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

 public class GoogleArabic extends GoogleEnglish{

    @FindBy(css="div#gws-output-pages-elements-homepage_additional_languages__als a")
    private WebElement language;

    @FindBy(css="span.hOoLGe")
    private WebElement keyboardBtn;

    @FindBy(id="kbd")
    private WebElement keyboard;

    public GoogleArabic(WebDriver driver) {
        super(driver);
    }
    @Override
    public void launch(){
        this.driver.get("https://www.google.com.sa");
        this.language.click();
    }
    @Override
    public void search(String keyword){
        this.wait.until((d)->this.keyboardBtn.isDisplayed());
        this.keyboardBtn.click();
        this.wait.until((d)->this.keyboard.isDisplayed());
        super.search(keyword);//from here on follow the parent google english class template


    }
}
