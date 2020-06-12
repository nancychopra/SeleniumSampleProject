package com.selenium.design.srp.common;

import com.google.common.util.concurrent.Uninterruptibles;
import com.selenium.design.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class SearchWidget extends AbstractComponent {


    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchBox;

    public SearchWidget(final WebDriver driver){

     super(driver);

    }

    public void enter(String term){
        this.searchBox.clear();
        for (char ch : term.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(ch + "");
        }

    }

    // wait untilsearch box is displayed, only then interact with this component.
    @Override
    public boolean isDisplayed() {
        this.wait.until(ExpectedConditions.visibilityOf(searchBox));
        return this.searchBox.isDisplayed();
    }
}
