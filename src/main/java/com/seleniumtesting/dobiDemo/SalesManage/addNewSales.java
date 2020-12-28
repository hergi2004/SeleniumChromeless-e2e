package com.seleniumtesting.dobiDemo.SalesManage;

import com.seleniumtesting.dobiDemo.CustomerManage.Customer;
import com.seleniumtesting.dobiDemo.Enum.SELECT_CUST;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.seleniumtesting.dobiDemo.basicOperration.sleep.sleep;

public class addNewSales {

    //WebDriver object, can be accessed by all methods in this class
    private static WebDriver DRIVER;

    private static String TARGET_URL_HOME;

    //can be used together with String TARGET_URL_HOME by concatenation of both String that will form a URL that direct to page creating new Sale
    private static String newSales="?page=new_sale";


    //all methods in this class can use the same DRIVER instance
    public static void setDRIVER(WebDriver driver){
        DRIVER=driver;
    }
    public static void setTARGET_URL_HOME(String URL){
        TARGET_URL_HOME=URL;
    }

    /**
     * Perform login on the website with passed email and password
     * <p>
     * This method would use the email and password passed to , to fill up the corresponding input fields in the website.
     * Lastly, submit the login form by clicking the login button on the website.
     * </br>
     * @param email Email, to fill up the login input field with id of "email"
     * @param password Password, to fill up the login input field with id of "password"
     * <p>This method will first visit the @Variable "TARGET_URL_HOME", then clicked the login button on the nav bar. Filling up the login form with input fields
     * of email and password with @param of "email" and "password" </p>
     *
     */
    public void login(String email,String password){

        //visit the home page of the website
        DRIVER.get(TARGET_URL_HOME);
        System.out.println("Visiting : " + TARGET_URL_HOME);
        sleep(2000);

        //click login button on the nav bar , find Element using full xpath
        //DRIVER.findElement(By.xpath("/html/body/div/nav/ul[2]/li[3]/a/i")).click();

        //find the input field for username and password
        WebElement loginForm_fill_email=DRIVER.findElement(By.id("email"));
        WebElement loginForm_fill_password=DRIVER.findElement(By.id("password"));

        //sendKeys to fill up the input fields
        loginForm_fill_email.sendKeys(email);
        loginForm_fill_password.sendKeys(password);
        System.out.println("Filling up login input fields with Username of : " + email + " and Password of : "+ password);

        //click the submit button for login, find Element using full xpath
        DRIVER.findElement(By.xpath("/html/body/div/div[2]/div/form/div[3]/div[2]/button")).click();
        System.out.println("Logging in...");

        

    }

    /**
     *
     * <p></p>
     *  </br>
     * @param CUST_NEW_EXISTED accept String then used for Enum in SELECT_CUST.java, do decide creating new customer or select existing customer
     * @param customer Customer object that is constructed with Name,Phone Number, Description and Starting balance ( used when the CUST_NEW_EXISTED enum is creating new customer)
     * @param service_string_array Items of the Sale
     * @param description description for the Service selected
     * @param discount Discount applied to the Sale
     * @param PAYMENT_M Payment Method of the Sale, "cash" or "bank" (actual values of the input field)
     * @param PAYMENT Payment ( Full, partial upon Customer sending their items or payment on pickup of items
     *
     * @return Status Code so the the Unit Testing of this method can be evaluated
     */
    public String newSales(String CUST_NEW_EXISTED,
                           Customer customer,
                           String[] service_string_array,
                           String description,
                           String discount,
                           String PAYMENT_M,
                           String PAYMENT){
        //declaration without initialization
        String quantity;

        //navigate to the page of creating new Sale
        //concatenating the String of TARGET URL and sub page URL
        DRIVER.get( TARGET_URL_HOME.concat(newSales) );

        //NEW or EXISTED customer, to create the Sale on
        SELECT_CUST select= SELECT_CUST.valueOf(CUST_NEW_EXISTED);

        //called the method of matched Enum object
        select.selectCustomer(DRIVER, customer);

        //add items for the sale, after selecting a existing customer or creating a new customer
        DRIVER.findElement(By.id("add_item")).click();
        sleep(2000);

        for( String service_string : service_string_array ) {

            selectServices(service_string);

            //for the testing purpose, all description would be the same as it @variable description was used repeatedly
            // enhanced for loop only supporting use one collection, while in this case , the [] service_string_array
            DRIVER.findElement(By.id("itemSelect_desc")).sendKeys(description);

            //same case for the quantity
            // another option is that the quantity is updated using Math.random in range of 6
            quantity = String.valueOf(Math.random() * 6);
            DRIVER.findElement(By.id("itemSelect_quantity")).sendKeys(quantity);

            DRIVER.findElement(By.id("addItem")).click();
            sleep(2000);

        }

        // "cash" or "bank"
        DRIVER.findElement(By.id("paymentTypeVal")).sendKeys(PAYMENT_M);

        String totalAmount=DRIVER.findElement(By.xpath("/html/body/div/div[1]/section/div/div[2]/div[1]/div/div[2]/table/tbody/tr[4]/input")).getText();
        System.out.println("Total amount is : " + totalAmount );

        //ensure that the totalAmount is in correct format and special characters other from numbers are escaped
        //TODO 1. escape String for conversion to BigDecimal

        //TODO 2. prevent the discount is greater that @variable totalAmount
        //BigDecimal totalAmount_BDouble= new BigDecimal(totalAmount);


        DRIVER.findElement(By.id("discount")).sendKeys(discount);
        DRIVER.findElement(By.id("amountPaid")).sendKeys(PAYMENT);

        //change pending
        return "S";
    }

    public void selectServices(String string_service ){

            //click the "add items" button to add items into Sale of a Customer
            DRIVER.findElement(By.xpath("/html/body/div/div[1]/section/div/div[2]/div[1]/div/div[1]/div/a")).click();

            WebElement service_selection = DRIVER.findElement(By.xpath("//span[.='" + string_service + "']"));

            if (service_selection != null) {

                service_selection.click();

            }
            //retry if no selection can be done
            else {
                //addItemsofSales(s,description);
            }

    }

}
