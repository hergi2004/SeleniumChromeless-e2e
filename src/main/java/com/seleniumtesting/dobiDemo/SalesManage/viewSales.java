package com.seleniumtesting.dobiDemo.SalesManage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class viewSales {

    private final String SALES_URL="https://ontime.unisza.edu.my/dobidemo/index.php?page=sales";

    public void viewSales(WebDriver driver){

        //navigating to the website of SALES
        driver.get(SALES_URL);




    }
}
