package org.petclinic;

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

public class VisitCreationPageTest {

    private String testUrl;
    private WebDriver driver;
    private String date;
    private String description;

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
        //Go to the Find owner button using xpath
        List<WebElement> searchButton = driver.findElements(By.xpath("//*[@id=\"search-owner-form\"]/div[2]/div/button"));
        //Click the Find owner search button
        searchButton.get(0).click();
        //Find the first owner using xpath
        List<WebElement> firstOwner = driver.findElements(By.xpath("//*[@id=\"vets\"]/tbody/tr[1]/td[1]/a"));
         //Click the first owner
        firstOwner.get(0).click();
        List<WebElement> addVisitButton = driver.findElements(By.xpath("/html/body/div/div/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td[2]/a"));
         //Click the add visit button
        addVisitButton.get(0).click();
    }

    @Test
    public void testAddVisitButton() {

        description = "Test description";
        date = "2010/09/07";

        List<WebElement> dateField = driver.findElements(By.xpath("//*[@id=\"date\"]"));
        dateField.get(0).sendKeys(date);

        List<WebElement> descriptionField = driver.findElements(By.xpath("//*[@id=\"description\"]"));
        descriptionField.get(0).sendKeys(description);

        List<WebElement> addVisit = driver.findElements(By.xpath("/html/body/div/div/form/div[2]/div/button"));
        addVisit.get(0).click();
    }

    @After
    public void teardown() throws IOException {

        try {
            Thread.sleep(1000);
        } 
        catch(InterruptedException e){
             // this part is executed when an exception (in this example InterruptedException) occurs
        }
        driver.quit();
    }
}