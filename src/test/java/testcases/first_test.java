package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import base.baseTest;

public class first_test extends baseTest {
    
    ExtentReports extent;
    ExtentTest test;
    
    @BeforeMethod
    public void setUpExtent() {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
    
    @Test(dataProvider = "testdata")
    public void login(String name, String pass) throws InterruptedException {
        test = extent.createTest("Login Test - " + name);
        try {
            driver.manage().window().maximize();
            driver.findElement(By.id("user-name")).sendKeys("standard_user");//will use name here
            Thread.sleep(3000);
            driver.findElement(By.id("password")).sendKeys("secret_sauce");//  will use pass here
            driver.findElement(By.id("login-button")).click();
            
            test.log(Status.PASS, "Login successful for: " + name);
        } catch (Exception e) {
            test.log(Status.FAIL, "Login failed for: " + name );
        }
    }
    
    @AfterMethod
    public void tearDownExtent() {
        extent.flush();
    }
    
    @DataProvider(name = "testdata")
    public Object[][] data() {
        return new Object[][] {
            { "pragya@yopmail.com", "Pragya@123" },
            { "p@yopmail.com", "Pragya@123" }
            
        };
    }
}
