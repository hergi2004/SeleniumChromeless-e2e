package com.seleniumtesting.dobiDemo.SalesManage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class clearingPaymentDue {

    private WebDriver driver;
    private String BASE_URL="https://ontime.unisza.edu.my/dobidemo/index.php";
    private String SALES_URL_TAIL="?page=sales";

    public void setDriver(WebDriver driver){
        this.driver=driver;
    }

    public boolean clearningPaymentDue_pickup(String customer_name,String sales_record_Identifier,String amount,String payment_m){

        //directing to page of sales record
        driver.get( BASE_URL.concat(SALES_URL_TAIL) );

        String cust_name_fromList;
        int counter=1;
        String cust_name_xpath;
        String href_xpath;

        //try to find first 10 entry for a match
        for(int i=0;i<10;i++) {

            cust_name_xpath = "/html/body/div/div[1]/section/div/div/div/div/div[2]/div/table/tbody/tr[" + counter + "]/td[2]";
            href_xpath="/html/body/div/div[1]/section/div/div/div/div/div[2]/div/table/tbody/tr[" + counter + "]/td[1]/a";
            cust_name_fromList = driver.findElement(By.xpath(cust_name_xpath)).getText();
            ///html/body/div/div[1]/section/div/div/div/div/div[2]/div/table/tbody/tr[2]/td[2]
            ///html/body/div/div[1]/section/div/div/div/div/div[2]/div/table/tbody/tr[1]/td[2]
            ///html/body/div/div[1]/section/div/div/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a

            if (cust_name_fromList.equals(customer_name)) {

                driver.findElement(By.xpath(href_xpath)).click();
                break;
            }
            counter+=1;

        }

        // click the "+payment+ to add payment to solve the payment due
        driver.findElement(By.xpath("/html/body/div/div[1]/section/div/div[2]/div[2]/center/a[1]")).click();

        //send Value to the Total Paid input field
        driver.findElement(By.id("payVal")).sendKeys(amount);

        //choose payment method
        if( payment_m.equals("cash")){
            driver.findElement(By.id("customRadio1")).click();
        }
        else if(payment_m.equals("bank")){
            driver.findElement(By.id("customRadio2")).click();
        }
        else{
            return false;
        }

        //click the save button
        driver.findElement(By.id("save_button")).click();

        return true;
    }

}
