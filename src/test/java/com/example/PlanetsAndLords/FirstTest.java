package com.example.PlanetsAndLords;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstTest {
    public ChromeDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void firstTest1() {
        driver.get("http://localhost:8080");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (int i = 0; i<links.size(); i++) {
            System.out.println("Name of Link# " + i + " " + links.get(i).getText());
        }
        links.get(0).click();
        WebElement lordName = driver.findElement(By.name("name"));
        lordName.sendKeys("Vasya");
        WebElement lordAge = driver.findElement(By.name("age"));
        lordAge.sendKeys("49");
        lordAge.submit();
        if(driver.getCurrentUrl().equals("http://localhost:8080/addLord")){
            lordName = driver.findElement(By.name("name"));
            lordName.sendKeys("Masha");
            lordAge = driver.findElement(By.name("age"));
            lordAge.sendKeys("10");
            lordAge.submit();
            driver.get("http://localhost:8080");
        }
        links = driver.findElements(By.tagName("a"));
        links.get(1).click();
        WebElement planetName = driver.findElement(By.name("name"));
        planetName.sendKeys("Venera");
        planetName.submit();
        if(driver.getCurrentUrl().equals("http://localhost:8080/addPlanet")){
            planetName = driver.findElement(By.name("name"));
            planetName.sendKeys("Saturn");
            planetName.submit();
            driver.get("http://localhost:8080");
        }
        links = driver.findElements(By.tagName("a"));
        links.get(4).click();
        links = driver.findElements(By.tagName("a"));
        links.get(5).click();
        links = driver.findElements(By.tagName("a"));
        links.get(6).click();
    }

}
