package com.selenium.design.template;

import com.selenium.design.template.pages.AmazonProductPage;
import com.selenium.design.template.pages.AmazonResultsPage;
import com.selenium.design.template.pages.AmazonSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AmazonShopping extends ShoppingTemplate {

    private WebDriver driver;
    private String product;

    private AmazonProductPage productPage;
    private AmazonResultsPage resultsPage;
    private AmazonSearchPage searchPage;


    public AmazonShopping(WebDriver driver, String product){
        this.driver= driver;
        this.product= product;
        this.productPage= PageFactory.initElements(driver,AmazonProductPage.class);
        this.resultsPage= PageFactory.initElements(driver,AmazonResultsPage.class);
        this.searchPage= PageFactory.initElements(driver,AmazonSearchPage.class);

    }


    @Override
    public void launchSite() {
        this.searchPage.goTo();

    }

    @Override
    public void searchItem() {
        this.searchPage.search(this.product);

    }

    @Override
    public void selectItem() {
        this.resultsPage.selectProduct();

    }

    @Override
    public void buy() {
        this.productPage.buy();

    }
}
