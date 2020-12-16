package com.seleniumtesting.demoblaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public enum OPERATION {

    /**
     * ENUM LIST:
     * 1. FULL -- username and password are both filled up in the sign up form
     * 2. USERNAME -- username only, filled up in the sign up form
     * 3. PASSWORD -- password only , filled up it the sign up form
     * 4. EMPTY -- neither of the username and password are filled up in the sign up form
     *
     */


    FULL{
        //username and password are filled up
        @Override
        public String finalAction(WebDriver driver,UserSignUpOperation userSignUpOperation) throws InterruptedException {

            WebElement username = driver.findElement(By.id("sign-username"));
            WebElement password = driver.findElement(By.id("sign-password"));

            username.sendKeys(userSignUpOperation.getSign_username());
            password.sendKeys(userSignUpOperation.getSign_password());

            WebElement signUpButton=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/button[2]"));
            signUpButton.click();

            Thread.sleep(3000);

            String response=driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            System.out.println(response);

            //reverse lookup Enum based on its values( the responseMessage or the responseStatus)
            SIGNUP_STATUS status=SIGNUP_STATUS.get(response);


            //use the Enum to get the code either "S" if the sign up is successful or "F" if the operation failed
            return status.getCode();

        }

    },

    USERNAME{
        //only username is filled up
        @Override
        public String finalAction(WebDriver driver,UserSignUpOperation userSignUpOperation) throws InterruptedException {

            WebElement username = driver.findElement(By.id("sign-username"));
            username.sendKeys(userSignUpOperation.getSign_username());


            WebElement signUpButton=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/button[2]"));
            signUpButton.click();

            Thread.sleep(3000);

            String response=driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            System.out.println(response);

            SIGNUP_STATUS status=SIGNUP_STATUS.get(response);

            return status.getCode();
        }
    },

    PASSWORD{
        //only password is filled up
        @Override
        public String finalAction(WebDriver driver,UserSignUpOperation userSignUpOperation) throws InterruptedException {


            WebElement password = driver.findElement(By.id("sign-password"));
            password.sendKeys(userSignUpOperation.getSign_password());

            WebElement signUpButton=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/button[2]"));
            signUpButton.click();

            Thread.sleep(3000);

            String response=driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            System.out.println(response);

            SIGNUP_STATUS status=SIGNUP_STATUS.get(response);

            return status.getCode();
        }
    },

    EMPTY{
        //neither of the username and password are filled up
        @Override
        public String finalAction(WebDriver driver,UserSignUpOperation userSignUpOperation) throws InterruptedException {


            WebElement signUpButton=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/button[2]"));
            signUpButton.click();

            Thread.sleep(3000);

            String response=driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
            System.out.println(response);

            SIGNUP_STATUS status=SIGNUP_STATUS.get(response);

            return status.getCode();
        }
    };


    //abstract method that can be overridden based on the enum objects

    /**
     *
     * @param driver WebDriver
     * @param userSignUpOperation object to get the username and password and action when it is constructed
     * @return "S" or "F" from the enum SIGNUP_STATUS --> "S" if successful and "F" if failed
     */
    public abstract String finalAction(WebDriver driver, UserSignUpOperation userSignUpOperation) throws InterruptedException;


}
