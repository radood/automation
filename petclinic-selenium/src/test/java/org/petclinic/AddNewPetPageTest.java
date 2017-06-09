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

public class AddNewPetPageTest {

    private String testUrl;
    private WebDriver driver;
    private String name;
    private String birthDate;

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

        List<WebElement> addNewPetButton = driver.findElements(By.xpath("/html/body/div/div/a[2]"));
         //Click the add new pet button
        addNewPetButton.get(0).click();

    }

    @Test
    public void testCreateNewPetForOwner() {
        
        name = "Test Pet name";
        birthDate = "2010/09/07";

        //Fill up each of the text fields
        List<WebElement> nameField = driver.findElements(By.xpath("//*[@id=\"name\"]"));
        nameField.get(0).sendKeys(name);

        List<WebElement> birthDateField = driver.findElements(By.xpath("//*[@id=\"birthDate\"]"));
        birthDateField.get(0).sendKeys(birthDate);
        
        //Choose the first type element
        List<WebElement> typeField = driver.findElements(By.xpath("//*[@id=\"type\"]/option[1]"));
        birthDateField.get(0).click();

        //Click add new pet button
        List<WebElement> addPetButton = driver.findElements(By.xpath("/html/body/div/div/form/div[2]/div/button"));
        addPetButton.get(0).click();
    }

    @After
    public void teardown() throws IOException {

        try {
            Thread.sleep(3000);
        } 
        catch(InterruptedException e){
             // this part is executed when an exception (in this example InterruptedException) occurs
        }
        driver.quit();
    }
}