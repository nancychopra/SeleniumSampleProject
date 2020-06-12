package com.selenium.design.srp.result;

import com.selenium.design.srp.common.SearchSuggestion;
import com.selenium.design.srp.common.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.sql.ResultSet;

public class GoogleResultPage {

    private WebDriver driver;

    private SearchWidget searchWidget;

    private SearchSuggestion searchSuggestion;

    private NavigationBar navigationBar;

    private ResultStat resultStat;

    public GoogleResultPage(final WebDriver driver){

        this.driver = driver;

        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
        this.navigationBar = PageFactory.initElements(driver, NavigationBar.class);
        this.resultStat = PageFactory.initElements(driver, ResultStat.class);

    }

    public NavigationBar getNavigationBar() {
        return navigationBar;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public ResultStat getResultStat() {
        return resultStat;
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }
}
