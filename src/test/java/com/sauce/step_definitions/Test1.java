package com.sauce.step_definitions;

import com.sauce.utilities.BrowserUtils;
import com.sauce.utilities.Driver;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Test1 {
    private WebElement elem;
    private WebDriverWait wait;
    private WebDriver driver;


//    @BeforeAll
//    public static void setUp(){
//        RestAssured.baseURI="https";
//    }

    @Test
    public void test11() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.multiformis.com/");
        driver.findElement(By.linkText("Contact us")).click();
        WebElement logo = driver.findElement(By.cssSelector("[class='page-heading bottom-indent']"));
        wait.until(ExpectedConditions.visibilityOf(logo));

    }


    @Test
    public void test4() {
//        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(4));
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.multiformis.com/");
        driver.findElement(By.linkText("Contact us")).click();

        WebElement logo = Driver.get().findElement(By.xpath("//*[@class='page-subheading']"));
        BrowserUtils.waitForVisibility(logo,4);
//        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(4));
//        wait.until(ExpectedConditions.visibilityOf(logo));

//        WebElement contact = Driver.get().findElement(By.id("id_contact"));
//        Select select = new Select(contact);
//        select.selectByVisibleText("Webmaster");
//        driver.findElement(By.id("email")).sendKeys("test@toptal.com");
//        driver.findElement(By.id("id_order")).sendKeys("R108");
//        driver.findElement(By.id("message")).sendKeys("Complaint about order R108");
//
//        WebElement upload = Driver.get().findElement(By.id("fileUpload"));
//        upload.click();
//        String path = System.getProperty("user.dir");
//
//        upload.sendKeys("Goksal/Desktop/Only edit option.png");
//        driver.findElement(By.xpath("//span[text='Send']")).click();



    }







}
