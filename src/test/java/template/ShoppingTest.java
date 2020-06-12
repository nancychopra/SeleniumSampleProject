package template;

import com.selenium.design.template.AmazonShopping;
import com.selenium.design.template.EbayShopping;
import com.selenium.design.template.ShoppingTemplate;
import com.selenium.design.test.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest {


    @Test(dataProvider = "getData")
    public void shoppingTest(ShoppingTemplate template){
        template.shop();

    }

    @DataProvider
    public Object[] getData(){
        return new Object[]{
                new AmazonShopping(driver,"samsung 4k"),
                new EbayShopping(driver,"samsung 4k")
        };
    }
}
