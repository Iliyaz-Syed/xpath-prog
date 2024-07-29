package com.flipkart;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkart {
    private static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        chapter2();
//         chapter3();
        // chapter4();
        // chapter5();
        // chapter6();
        // chapter7();
//         chapter8();
        // chapter9();
    }

    public static void highlight(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
    }

    // Types of XPath
    public static void chapter2() {
        driver.get("https://www.flipkart.com/");

        // Wait until the element is clickable
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement mobilesLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-label='Mobiles']")));

        highlight(driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/a[2]")));
        
        
        // Additional code to interact with the next page can be added here
    }

    // XPath using Attributes
    public static void chapter3() {
        driver.get("https://www.flipkart.com/");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/a[4]/div/div/div/div"));
        highlight(loginButton);
        loginButton.click();
        
        // Additional code to interact with the login page can be added here
    }

    // XPath Operators
    public static void chapter4() {
        driver.get("https://www.flipkart.com/");
        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'_1AtVbE')]"));
        for (WebElement element : elements) {
            highlight(element);
        }
    }

    // XPath Conditions
    public static void chapter5() {
        driver.get("https://www.flipkart.com/");
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='_2kHMtA' and contains(.,'Samsung')]"));
        for (WebElement element : elements) {
            highlight(element);
        }
    }

    // XPath with Index
    public static void chapter6() {
        driver.get("https://www.flipkart.com/");
        highlight(driver.findElement(By.xpath("(//div[@class='_1AtVbE'])[2]")));
    }

    // XPath Functions
    public static void chapter7() {
        driver.get("https://www.flipkart.com/");
        highlight(driver.findElement(By.xpath("//span[text()='Cart']")));
        highlight(driver.findElement(By.xpath("//a[contains(text(),'Top Offers')]")));
        highlight(driver.findElement(By.xpath("//div[contains(@class,'_1YokD2')]")));
        highlight(driver.findElement(By.xpath("//a[starts-with(text(),'Grocery')]")));
        highlight(driver.findElement(By.xpath("//div[normalize-space(text())='Electronics']")));
        System.out.println(driver.findElements(By.xpath("(//div[@class='_1AtVbE'])[position()>2]")).size());
    }

    // XPath Axes
    public static void chapter8() {
        driver.get("https://www.flipkart.com/");
        highlight(driver.findElement(By.xpath("//a[text()='Login']/preceding-sibling::div")));
        highlight(driver.findElement(By.xpath("//div[text()='Mobiles']/following::div[1]")));
    }

    // XPath Shortcuts
    public static void chapter9() {
        driver.get("https://www.flipkart.com/");
        
        // text() -> .
        highlight(driver.findElement(By.xpath("//span[.='Cart']")));
        highlight(driver.findElement(By.xpath("//a[contains(.,'Offers')]")));
        highlight(driver.findElement(By.xpath("//div[starts-with(.,'Electronics')]")));
        highlight(driver.findElement(By.xpath("//div[normalize-space(.)='Mobiles']")));

        // child -> /
        highlight(driver.findElement(By.xpath("//div[@class='_1YokD2']/div")));

        // parent -> /..
        highlight(driver.findElement(By.xpath("//span[.='Cart']/..")));

        // descendant -> //
        List<WebElement> elements = driver.findElements(By.xpath("//div[@class='_1YokD2']//div"));
        for (WebElement element : elements) {
            highlight(element);
        }
    }
}
