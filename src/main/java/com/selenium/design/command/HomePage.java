package com.selenium.design.command;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "div.button-box button.btn-info")
    private WebElement infoBtn;

    @FindBy(css = "div.button-box button.btn-warning")
    private WebElement warnBtn;

    @FindBy(css = "div.button-box button.btn-success")
    private WebElement successBtn;

    @FindBy(css = "div.button-box button.btn-danger")
    private WebElement dangerBtn;

    //notifications
    @FindBy(css = "div.jq-icon-info")
    private WebElement infoAlert;

    @FindBy(css = "div.jq-icon-warning")
    private WebElement warnAlert;

    @FindBy(css = "div.jq-icon-success")
    private WebElement successAlert;

    @FindBy(css = "div.jq-icon-error")
    private WebElement dangerAlert;

    //dismissal alert
    @FindBy(css = "div.row > div.col-lg-4:nth-child(2) div.alert.alert-info")
    private WebElement dismissInfoAlert;

    @FindBy(css = "div.row > div.col-lg-4:nth-child(2) div.alert.alert-success")
    private WebElement dismissSuccessAlert;

    @FindBy(css = "div.row > div.col-lg-4:nth-child(2) div.alert.alert-danger")
    private WebElement dismissDangerAlert;

    @FindBy(css = "div.row > div.col-lg-4:nth-child(2) div.alert.alert-warning")
    private WebElement dismissWarnAlert;

    public HomePage(final WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
        PageFactory.initElements(driver,this);

    }

    public void goTo(){
        driver.get("https://www.wrappixel.com/demos/admin-templates/admin-pro/main/ui-notification.html");
        Uninterruptibles.sleepUninterruptibly(20, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(this.infoBtn));

    }

    public List<ElementValidator> getElementValidators(){

        return  Arrays.asList(
                new NotificationValidator(infoBtn,infoAlert),
                new NotificationValidator(warnBtn,warnAlert),
                new NotificationValidator(successBtn,successAlert),
                new NotificationValidator(dangerBtn,dangerAlert),
                new DismissalAlertValidator(dismissInfoAlert),
                new DismissalAlertValidator(dismissSuccessAlert),
                new DismissalAlertValidator(dismissDangerAlert),
                new DismissalAlertValidator(dismissWarnAlert)

        );

    }



}
