package org.petclinic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
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

public class AddNewOwnerPageTest {

    private String testUrl;
    private WebDriver driver;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String telephone;

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

        //Go to Find Owners page from tab using xpath
        List<WebElement> searchTab = driver.findElements(By.xpath("//*[@id=\"main-navbar\"]/ul/li[3]/a/span[2]"));
         //Click the selected tab button
        searchTab.get(0).click();
        
        //Find the add new owner button
        List<WebElement>  addOwnerButton = driver.findElements(By.xpath("/html/body/div/div/a"));
        //Click the button
        addOwnerButton.get(0).click();
    }

    //This can be expanded into multiple tests and use VARIABLES instead of the constant send keys when testing the non happypath scenarios
    @Test
    public void testCreateNewOwner() {

        //Added current time to first and last name to make sure there are no duplicates
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

        firstName = "Test First Name" + timeStamp;
        lastName = "Test Last Name" + timeStamp;
        address = "Test Address";
        city = "Test City";
        telephone = "1234";



        //Fill up each of the text fields
        List<WebElement> firstNameField = driver.findElements(By.xpath("//*[@id=\"firstName\"]"));
        firstNameField.get(0).sendKeys(firstName);

        List<WebElement> lastNameField = driver.findElements(By.xpath("//*[@id=\"lastName\"]"));
        lastNameField.get(0).sendKeys(lastName);

        List<WebElement> addressField = driver.findElements(By.xpath("//*[@id=\"address\"]"));
        addressField.get(0).sendKeys(address);

        List<WebElement> cityField = driver.findElements(By.xpath("//*[@id=\"city\"]"));
        cityField.get(0).sendKeys(city);

        List<WebElement> telephoneField = driver.findElements(By.xpath("//*[@id=\"telephone\"]"));
        telephoneField.get(0).sendKeys(telephone);

        //Click the Add Owner button
        List<WebElement> addOwnerButton = driver.findElements(By.xpath("//*[@id=\"add-owner-form\"]/div[2]/div/button"));
        addOwnerButton.get(0).click();
    }

 @After
    public void teardown() {
        try {
            Thread.sleep(2000);
        } 
        catch(InterruptedException e){
             // this part is executed when an exception (in this example InterruptedException) occurs
        }
        driver.quit();
    }

}
