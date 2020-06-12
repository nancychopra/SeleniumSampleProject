package com.selenium.design.test.factory;

import com.selenium.design.factory.GoogleFactory;
import com.selenium.design.factory.GooglePage;
import com.selenium.design.test.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    private GooglePage googlePage;

    @Test(dataProvider = "dataProvider")
    public void searchTest(String language,String keyword){
        this.googlePage= GoogleFactory.get(language,this.driver);
        this.googlePage.launch();
        this.googlePage.search(keyword);
        int results =this.googlePage.getResultCount();
        System.out.println(results);


    }

    @DataProvider
    public Object[][] dataProvider(){
        return new Object[][]{
                {"ENG","selenium"},
                {"FR","docker"},
                {"SA","kubernetes"},
                {"ES","kubernetes"}

        };
    }
}
