package com.selenium.design.srp.result;

import com.selenium.design.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultStat extends AbstractComponent {

    @FindBy(id = "result-stats")
    private WebElement stat;

    public ResultStat(final WebDriver driver){
        super(driver);

    }

    public String getStat(){
        return this.stat.getText();
    }


    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.stat.isDisplayed());
    }
}
