package com.seleniumtesting.dobiDemo.SalesManage;

import com.seleniumtesting.dobiDemo.CustomerManage.Customer;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.seleniumtesting.dobiDemo.SalesManage.addNewSales.setDRIVER;
import static com.seleniumtesting.dobiDemo.SalesManage.addNewSales.setTARGET_URL_HOME;

class addNewSalesTest {

    private static WebDriver driver;
    private static final String TARGET_HOME_INDEX="https://ontime.unisza.edu.my/dobidemo/index.php";

    private static addNewSales add;
    private static Customer cust;
    private static String [] service_string_array;

    @BeforeAll
    static void setUp() {

        driver=new ChromeDriver();

        //credentials for login
        String email = "kumpulan6";
        String password = "t3r3n66anu";

        //preparing a Customer object, for the use of passing it into one of the parameters of method newSales() in addNewSales.java
        cust=new Customer("Afnan Ahmad","010-32423465","Sample text for description","28.00");

        //String array
        service_string_array= new String []{"a","b"};

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
    @DisplayName("Testing on adding new Sale for a new Customer with starting Balance of <A> and the Payment ")
    @Description("dsadasd")
    void addNewSalesTest_NewCustomer_StartingBalance_A_PaymentCash() {

        //TODO Complete the test script for "Add new sale"

        add.newSales("NEW",cust,service_string_array,"sample text for description","cash");

        //all add new customer will not work because of the defect in the system
    }

    @Test
    @Description("")
    void addNewSalesTest_NewCustomer_StartingBalance_B_PaymentCash(){

    }

    @Test
    void addNewSalesTest_NewCustomer_StartingBalance_A_PaymentBank(){

    }

    @Test
    void addNewSalesTest_NewCustomer_StartingBalance_B_PaymentBank(){

    }

    @Test
    @Description("")
    void addNewSalesTest_ExistingCustomer_PaymentCash(){

    }

    @Test
    @DisplayName("Testing on adding new Sale for an existing Customer and the Payment was done using bank.")
    @Description("dsadasd")
    void addNewSalesTest_ExistingCustomer_PaymentBank(){

    }


}