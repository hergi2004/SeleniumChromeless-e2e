package com.seleniumtesting.dobiDemo.SalesManage;

import com.seleniumtesting.dobiDemo.basicOperration.stringManipulation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class viewSales {

    private WebDriver driver;
    private final String SALES_URL="https://ontime.unisza.edu.my/dobidemo/index.php?page=sales";

    public void viewSalesPage(WebDriver driver){

        //navigating to the website of SALES
        driver.get(SALES_URL);

    }

    public void setDriver(WebDriver driver){
        this.driver=driver;
    }

    public boolean sort_ByDate_DESC(){

        String customer_name_first_beforeSort=driver.findElement(By.xpath("/html/body/div/div[1]/section/div/div/div/div/div[2]/div/table/tbody/tr[1]/td[2]")).getText();
        String customer_name_last_beforeSort;

        int numberofEntries= Integer.parseInt
                                (stringManipulation.getNumberofEntries
                                        ( driver.findElement(By.xpath("/html/body/div/div[1]/section/div/div/div/div/div[3]/div[1]/div")).getText() ));
        String holder="/html/body/div/div[1]/section/div/div/div/div/div[2]/div/table/tbody/tr[" +numberofEntries +"]/td[2]";
        customer_name_last_beforeSort=driver.findElement(By.xpath(holder)).getText();

        //click the sort button
        driver.findElement(By.xpath("/html/body/div/div[1]/section/div/div/div/div/div[2]/div/table/thead/tr/th[1]")).click();

        String customer_name_first_afterSort=driver.findElement(By.xpath("/html/body/div/div[1]/section/div/div/div/div/div[2]/div/table/tbody/tr[1]/td[2]")).getText();
        String customer_name_last_afterSort=driver.findElement(By.xpath(holder)).getText();


        return customer_name_first_beforeSort.equals(customer_name_last_afterSort) && customer_name_last_beforeSort.equals(customer_name_first_afterSort);

        ///html/body/div/div[1]/section/div/div/div/div/div[2]/div/table/tbody/tr[2]/td[2]
        ///html/body/div/div[1]/section/div/div/div/div/div[2]/div/table/tbody/tr[1]/td[2]
        ///html/body/div/div[1]/section/div/div/div/div/div[2]/div/table/tbody/tr[1]/td[1]/a

    }
}
