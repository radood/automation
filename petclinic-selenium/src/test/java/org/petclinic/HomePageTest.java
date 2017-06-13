package org.petclinic;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Assert;
//import java.net.HttpStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class HomePageTest {

    private String testUrl;
    private WebDriver driver;

    @Before
    public void prepare() {
        //setup chromedriver
        System.setProperty(
                "webdriver.chrome.driver",
                "/home/radood/automation/chromedriver");

        testUrl = "localhost:8080";

        // Create a new instance of the Chrome driver
        driver = new ChromeDriver();

        //maximize window
        driver.manage().window().maximize();

        // And now use this to visit the page
        // Alternatively the same thing can be done like this
        // driver.navigate().to(testUrl);
        driver.get(testUrl);

    }

    @Test
    public void homePageShowsUpNoErrors() {
        List<WebElement> hpTab = driver.findElements(By.xpath("//*[@id=\"main-navbar\"]/ul/li[2]/a"));
         //Click the selected tab button
        hpTab.get(0).click();
        //Assert.assertEquals(HttpStatus.OK_200,response.getStatus());
    }

    @After
    public void teardown() {
        try {
            Thread.sleep(1000);
        } 
        catch(InterruptedException e){
             // this part is executed when an exception (in this example InterruptedException) occurs
        }
        driver.quit();
    }

}