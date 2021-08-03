package com.seleniumtesting.demoblaze;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

@TestInstance(value= TestInstance.Lifecycle.PER_CLASS)
public class UserSignUpOperationTest {

    private WebDriver driver;

    @BeforeAll
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
//         driver.navigate().to("https://the-internet.herokuapp.com/login");
        driver.navigate().to("http://demo.automationtesting.in");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.MILLISECONDS);
    }
    
     @Test (groups = {"group1"} )
    public void testIsThisReallyTrue() {
        assertTrue(true);
    }

    @Test (groups = {"group2"} )
    public void userLogin() throws InterruptedException
    {

//         WebElement usernameTxt = driver.findElement(By.id("username"));
//         usernameTxt.sendKeys("tomsmith");
//         WebElement passwordTxt = driver.findElement(By.id("password"));
//         passwordTxt.sendKeys("SuperSecretPassword!");
//         WebElement submitBtn = driver.findElement(By.className("radius"));
//         submitBtn.click();
        driver.findElement(By.id("email")).sendKeys("email@gmail.com");
        driver.findElement(By.id("enterimg")).click();
        Thread.sleep(3000);
        driver.quit();
//         System.out.println("Current URL is:" + driver.getCurrentUrl());
//         Assert.assertTrue(driver.getCurrentUrl().contains("secure"));
    }

    @AfterAll
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

    }
