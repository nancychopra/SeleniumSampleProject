package com.selenium.design.test.srp;

import com.selenium.design.srp.main.GoogleMainPage;
import com.selenium.design.srp.result.GoogleResultPage;
import com.selenium.design.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

    private GoogleMainPage mainPage;
    private GoogleResultPage resultPage;

    @BeforeTest
    public void setupPages(){
        this.mainPage = new GoogleMainPage(this.driver);
        this.resultPage = new GoogleResultPage(this.driver);

    }

    @Test(dataProvider = "getData")
    public void test(String keyword, int index){

        mainPage.goTo();
        Assert.assertTrue(mainPage.getSearchWidget().isDisplayed());

        mainPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(mainPage.getSearchSuggestion().isDisplayed());

        mainPage.getSearchSuggestion().clickSuggestionByIndex(index);
        Assert.assertTrue(resultPage.getNavigationBar().isDisplayed());

        resultPage.getNavigationBar().goToImages();
        resultPage.getNavigationBar().goToNews();

        Assert.assertTrue(resultPage.getResultStat().isDisplayed());
        System.out.println(resultPage.getResultStat().getStat());


    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {"selenium",3},
                {"docker",2}

        };

    }


}
