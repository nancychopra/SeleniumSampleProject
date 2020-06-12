package com.selenium.design.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GoolgeES extends GoogleEnglish {

    @FindBy(css="div#gws-output-pages-elements-homepage_additional_languages__als a")
    private WebElement language;

    public GoolgeES(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launch(){
        this.driver.get("https://google.es");
        this.language.click();

    }
}
