package com.selenium.design.proxy;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrderComponentProxy implements OrderComponent {

    public static final List<String> EXCLUDED = Arrays.asList("prod","staging");
    private OrderComponent orderComponent;

    public OrderComponentProxy(WebDriver driver){

        if (!EXCLUDED.contains(System.getProperty("env"))){
            this.orderComponent = new OrderComponentReal(driver);
        }

    }

    @Override
    public String order()
    {
        if (Objects.nonNull(orderComponent)){
            return orderComponent.order();
        }else{
            return "SKIPPED";
        }
    }
}
