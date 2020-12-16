package com.seleniumtesting.demoblaze;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.LinkedList;

@TestInstance(value= TestInstance.Lifecycle.PER_CLASS)
public class UserSignUpOperationTest {

    private WebDriver driver;

    @BeforeAll
    void setUp() {

        driver=new ChromeDriver();

        final String TESTING_SITE_URL="https://www.demoblaze.com";
        driver.get(TESTING_SITE_URL);
    }

    @AfterAll
    void tearDown() {
        driver.close();
        driver.quit();
    }


    /**
     * @author YJX
     * Test Case Scenario TSU-SIGNUP
     * <h2>Testing on the Sign-Up module</h2>
     * Test Cases ID:  1. TSU-SIGNUP-TC01
     *                 2. TSU-SIGNUP-TC02
     *                 3. TSU-SIGNUP-TC03
     *
     * <h3> TSU-SIGNUP-TC01 Sign Up for an account on the website with username and password filled in the sign-up form.</h3>
     * <h3> TSU-SIGNUP-TC02 Sign Up for an account on the website with either username or password left out in the sign-up form</h3>
     * <h3> TSU-SIGNUP-TC03 Sign Up for an account on the website with both username or password are left out in the sign-up form</h3>
     *
     * <h4> Expected Result </h4>
     * <p> A string with length of N, and the set of alphabet in the string would be {“S”,”F”,"E"} when the N is the number of cases ran on the unit testing.
     * Let’s say there is 4 runs, with cases that complies with TC01, then TC02 for twice and lastly TC03. Then the return string would be “SFFF” implies
     * that first is a successful operation and the rest are all failed sign-up operation. The expected result “SFFF” is then compare with the actual result ,
     * it should be a match if the system is operating accordingly. </p>
     * <p>"E" would be appended to the string if there is already an user with the same username existed. </p>
     */
    @Test
    void signUpOperation() throws InterruptedException {

        StringBuilder expectedResult=new StringBuilder();
        StringBuilder testResult = new StringBuilder();

        //holder to the actual result , used for concatenation then forming the String testResult
        String temp;
        char SUCCESS='S';
        char FAILED='F';
        char FAILED_EXISTED='E';

        //username and password used to sign up operation
        //expect that this username and password not yet exist in the system
        String USERNAME="dasas1234sadf";
        String PASSWORD="dgafsgh32423dda";

        UserSignUpOperation testCaseSetup=new UserSignUpOperation();
        //pass the driver to the method as argument/parameter
        testCaseSetup.setDriver(driver);

        LinkedList <UserSignUpOperation> list=new LinkedList<>();

        list.add( new UserSignUpOperation(USERNAME,PASSWORD,"FULL"));
        //append expected result to the String,
        //this username is not yet in the system, therefore it should be a successful operation
        expectedResult.append(SUCCESS);

        //Fill up the form with username and password
        list.add( new UserSignUpOperation(USERNAME,PASSWORD,"FULL"));
        //append expected result to the String
        //the username has already existed in the system due to previous operation
        //therefore it should be unsuccessful to sign up using the same username
        expectedResult.append(FAILED_EXISTED);

        //Fill up the form with username only
        list.add( new UserSignUpOperation(USERNAME,PASSWORD,"USERNAME"));
        //append expected result to the String
        //only username will be fill in the form, therefore expect the operation will fail
        expectedResult.append(FAILED);

        //Fill up the form with password only
        list.add( new UserSignUpOperation(USERNAME,PASSWORD,"PASSWORD"));
        //append expected result to the String
        //only password will be fill in the form, therefore expect the operation will fail
        expectedResult.append(FAILED);

        //Fill up the form with neither username and password
        list.add( new UserSignUpOperation(USERNAME,PASSWORD,"EMPTY"));
        expectedResult.append(FAILED);

            //iterate through the list
            for (UserSignUpOperation user : list) {

                // "S" will be returned if the sign up was a successful operation and "F" is for the opposite case
                temp = testCaseSetup.signUpOperation(user);
                System.out.println(temp);

                //append "S" or "F" to the testResult according to the response from the website
                testResult.append(temp);
                testCaseSetup.refreshPage();


            }

        //StringBuilder object toString()
        String stringOf_testResult=testResult.toString();
        String stringOf_expectedResult=expectedResult.toString();

        System.out.println("Actual Result: " + testResult);
        System.out.println("Expected Result: " + expectedResult);

        //compare expected and actual result (String) not StringBuilder object
        assertEquals(stringOf_expectedResult,stringOf_testResult);


    }

}