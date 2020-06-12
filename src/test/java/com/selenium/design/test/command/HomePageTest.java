package com.selenium.design.test.command;

import com.selenium.design.command.HomePage;
import com.selenium.design.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeTest
    public void setup(){
        homePage = new HomePage(driver);

    }

    @Test
    public void testHomePage(){

          /*
        Check Alert is displayed one by one
        Wait for 4 secs
        Check it is not displayed

        Similarly check dismissal is not displayed after click on close button.
         */
        homePage.goTo();
        homePage.getElementValidators().stream().parallel().map(e ->e.validate()).forEach(b-> Assert.assertTrue(b));


    }


//  Instead of streams same can be achieved by the following code
//    @Test(dataProvider = "getData", dependsOnMethods = "goTo")
//    public void homePageTest(ElementValidator elementValidator){
//        Assert.assertTrue(elementValidator.validate());
//    }
//
//    @DataProvider
//    public Object[] getData(){
//        return this.homePage.getElementValidators()
//                .toArray();
//    }
}
