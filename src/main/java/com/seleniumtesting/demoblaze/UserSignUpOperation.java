package com.seleniumtesting.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class UserSignUpOperation {

    private WebDriver DRIVER;

    private String sign_username;
    private String sign_password;
    private String sign_action;

    private final String TESTING_SITE_URL="https://www.demoblaze.com";

    //test class use
    //set the Driver according to the setup in the Test Class
    public void setDriver(WebDriver driver){
        this.DRIVER=driver;
    }

    //constructor for the setDriver method, without arguments
    public UserSignUpOperation(){

    }

    //constructor with arguments
    public UserSignUpOperation(String sign_username,String sign_password,String action){
        this.sign_username=sign_username;
        this.sign_password=sign_password;
        this.sign_action=action;
    }

    //getters
    public String getSign_username() {
        return sign_username;
    }

    public String getSign_password(){
        return sign_password;
    }
    public String getAction(){
        return sign_action;
    }

    /**
     *
     * @param userSignUpOperation Object and passed to this method as an argument, so the the username,password and action can further passed to FormAction()
     * @return String return from the FormAction() method: "S" of the sign up operation is successful and "F" is the operation failed.
     */
    public String signUpOperation(UserSignUpOperation userSignUpOperation) throws InterruptedException {

        DRIVER.manage().window().maximize();
        DRIVER.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement signUpNavButton=DRIVER.findElement(By.xpath("/html/body/nav/div[1]/ul/li[8]/a"));

        System.out.println("Clicking Sign Up to view the Sign Up Form...");

        if(signUpNavButton != null){
            signUpNavButton.click();
        }
        else{
            return "X";
        }

        return FormAction(userSignUpOperation);

    }

    /*public void fillUp(UserSignUpOperation userSignUpOperation){

        WebElement username = DRIVER.findElement(By.id("sign-username"));
        WebElement password = DRIVER.findElement(By.id("sign-password"));

        username.sendKeys(userSignUpOperation.getSign_username());
        password.sendKeys(userSignUpOperation.getSign_password());

    }*/

    /**
     *
     * @param userSignUpOperation Object passed from the method signUpOperation()
     * @return String "S" of the sign up operation is successful and "F" is the operation failed.
     */
    public String FormAction(UserSignUpOperation userSignUpOperation) throws InterruptedException {

        //get the ACTION from the object
        String action=userSignUpOperation.getAction();

        //matching enum of OPERATION class
        OPERATION op=OPERATION.valueOf(action);

        //get the code of either "S" or "F" depending on the result of sign up operation
        return op.finalAction(DRIVER,userSignUpOperation);

    }

    public void refreshPage(){

        DRIVER.get(TESTING_SITE_URL);
    }


}
