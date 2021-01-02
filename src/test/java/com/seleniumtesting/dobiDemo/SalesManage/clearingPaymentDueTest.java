package com.seleniumtesting.dobiDemo.SalesManage;

import jdk.jfr.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class clearingPaymentDueTest {
    private static WebDriver driver;

    @BeforeAll
    static void setUP(){

        driver=new ChromeDriver();
        clearingPaymentDue a=new clearingPaymentDue();

        a.setDriver(driver);



    }

    @AfterAll
    static void tearDown(){

    }

    @Test
    @DisplayName("")
    @Description("")
    void update_paymentDueOfCustomer_pickup_GreaterThanPaymentDue() {

        
    }

    @Test
    @DisplayName("")
    @Description("")
    void update_paymentDueOfCustomer_pickup_LessThanPaymentDue(){


    }

    @Test
    @DisplayName("")
    @Description("")
    void update_paymentDueOfCusomter_pickup_EqualsToPaymentDue(){

    }

    @Test
    @DisplayName("")
    @Description("")
    void update_paymentDueOfCustomer_pickup_NegativeValue(){

    }

}