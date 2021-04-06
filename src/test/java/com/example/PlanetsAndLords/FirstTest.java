package com.example.PlanetsAndLords;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.opera.OperaDriver;

import java.io.File;

public class FirstTest {
    @Test
    public void firstTest(){
        System.setProperty("webdriver.chrome.driver","C:\\webdrivers\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080");
    }

}
