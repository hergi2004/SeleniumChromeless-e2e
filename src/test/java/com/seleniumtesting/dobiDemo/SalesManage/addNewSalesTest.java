package com.seleniumtesting.dobiDemo.SalesManage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.seleniumtesting.dobiDemo.SalesManage.addNewSales.setDRIVER;
import static com.seleniumtesting.dobiDemo.SalesManage.addNewSales.setTARGET_URL_HOME;

class addNewSalesTest {

    private static WebDriver driver;
    private static final String TARGET_HOME_INDEX="https://ontime.unisza.edu.my/dobidemo/index.php";

    private static addNewSales add;

    @BeforeAll
    static void setUp() {

        driver=new ChromeDriver();

        //credentials for login
        String email = "kumpulan6";
        String password = "t3r3n66anu";

        //set the Driver for addNewSales class with ChromeDriver
        setDRIVER(driver);
        //set the TARGET as the url of website we are going to visit
        setTARGET_URL_HOME(TARGET_HOME_INDEX);

        //create an object of addNewSales class
        add=new addNewSales();
        //login using email and password
        add.login(email, password);

        //Customer constructor
        //add a new Customer object here

    }

    @AfterAll
    static void tearDown() {

        add=null;

        //graceful shutdown of the WebDriver instance
        driver.quit();
        driver=null;

        //garbage collect
        System.gc();
    }

    /**
     *  Test Scenario TSU-SALES-R1
     *  All Test Case to test the Requirement S2.1 (Sales Managerial)
     */
    @Test
    void newSales() {

        //TODO Complete the test script for "Add new sale"
    }
}