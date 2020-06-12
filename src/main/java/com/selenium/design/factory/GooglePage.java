package com.selenium.design.factory;

public abstract class GooglePage {
    public abstract void launch();
    public abstract void search(String keyword);
    public abstract int getResultCount();

}
