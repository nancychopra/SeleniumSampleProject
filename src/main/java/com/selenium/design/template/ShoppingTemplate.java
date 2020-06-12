package com.selenium.design.template;

public abstract class ShoppingTemplate {

    public abstract void  launchSite();
    public abstract void  searchItem();
    public abstract void  selectItem();
    public abstract void  buy();

    public void shop(){
        launchSite();
        searchItem();
        selectItem();
        buy();
    }

}
