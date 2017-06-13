package org.petclinic;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.json.*;
import org.skyscreamer.jsonassert.*;
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

public class VeterinariansPageTest {

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

        //Go to Veterinarians page from tab using xpath
        List<WebElement> vetTab = driver.findElements(By.xpath("//*[@id=\"main-navbar\"]/ul/li[4]/a/span[2]"));
         //Click the selected tab button
        vetTab.get(0).click();
    }

    @Test
    public void viewXMLTest() {
    	List<WebElement> viewXml = driver.findElements(By.xpath("/html/body/div/div/table[2]/tbody/tr/td[1]/a"));
         //Click the selected tab button
        viewXml.get(0).click();	
    }

    @Test
    public void viewJSONTest() {
    	List<WebElement> viewJson = driver.findElements(By.xpath("/html/body/div/div/table[2]/tbody/tr/td[2]/a"));
         //Click the selected tab button
        viewJson.get(0).click();	

        //JSONObject data = getRESTData("/vets.json");
        //String expected = "{\"vetList\":[{\"id\":1,\"firstName\":\"James\",\"lastName\":\"Carter\",\"specialties\":[],\"nrOfSpecialties\":0,\"new\":false},{\"id\":2,\"firstName\":\"Helen\",\"lastName\":\"Leary\",\"specialties\":[{\"id\":1,\"name\":\"radiology\",\"new\":false}],\"nrOfSpecialties\":1,\"new\":false},{\"id\":3,\"firstName\":\"Linda\",\"lastName\":\"Douglas\",\"specialties\":[{\"id\":3,\"name\":\"dentistry\",\"new\":false},{\"id\":2,\"name\":\"surgery\",\"new\":false}],\"nrOfSpecialties\":2,\"new\":false},{\"id\":4,\"firstName\":\"Rafael\",\"lastName\":\"Ortega\",\"specialties\":[{\"id\":2,\"name\":\"surgery\",\"new\":false}],\"nrOfSpecialties\":1,\"new\":false},{\"id\":5,\"firstName\":\"Henry\",\"lastName\":\"Stevens\",\"specialties\":[{\"id\":1,\"name\":\"radiology\",\"new\":false}],\"nrOfSpecialties\":1,\"new\":false},{\"id\":6,\"firstName\":\"Sharon\",\"lastName\":\"Jenkins\",\"specialties\":[],\"nrOfSpecialties\":0,\"new\":false}]}";
		//JSONAssert.assertEquals(expected, data, false);
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