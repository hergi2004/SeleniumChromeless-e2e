package com.seleniumtesting.dobiDemo.SalesManage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.seleniumtesting.dobiDemo.SalesManage.addNewSales.setDRIVER;
import static com.seleniumtesting.dobiDemo.SalesManage.addNewSales.setTARGET_URL_HOME;

class addNewSalesTest {

    private String email;
    private String password;
    private WebDriver driver;
    private final String TARGET_HOME_INDEX="https://ontime.unisza.edu.my/dobidemo/index.php";

    private addNewSales add;

    @BeforeEach
    void setUp() {

        driver=new ChromeDriver();

        //credentials for login
        email="kumpulan6";
        password="t3r3n66anu";

        //set the Driver for addNewSales class with ChromeDriver
        setDRIVER(driver);
        //set the TARGET as the url of website we are going to visit
        setTARGET_URL_HOME(TARGET_HOME_INDEX);

        //defind addNewSales object to call methods
        add=new addNewSales();
        //login using email and password
        add.login(email,password);

        //Customer constructor
        //add a new Customer object here

    }

    @AfterEach
    void tearDown() {

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


    }
}