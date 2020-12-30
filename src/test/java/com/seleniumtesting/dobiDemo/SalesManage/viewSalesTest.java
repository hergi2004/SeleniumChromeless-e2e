package com.seleniumtesting.dobiDemo.SalesManage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.seleniumtesting.dobiDemo.SalesManage.addNewSales.setDRIVER;
import static com.seleniumtesting.dobiDemo.SalesManage.addNewSales.setTARGET_URL_HOME;

class viewSalesTest {

    private static WebDriver driver;
    private static viewSales view;

    @BeforeAll
    static void setUp() {

        driver=new ChromeDriver();
        view=new viewSales();

        String email="kumpulan6";
        String password="t3r3n66anu";

        String TARGET_HOME_INDEX="https://ontime.unisza.edu.my/dobidemo";

        setDRIVER(driver);
        setTARGET_URL_HOME(TARGET_HOME_INDEX);

        addNewSales a=new addNewSales();

        a.login(email,password);


    }

    @AfterAll
    static void tearDown() {

        //graceful shutdown of the WebDriver instance
        driver.quit();
        driver=null;

        //garbage collect
        System.gc();
    }

    @Test
    void viewSales() {

        view.viewSales(driver);



    }
}