package com.skosay.test.pageobject;
 
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
 
 public class ManagerHomePage {
 
    private static WebElement element = null;
 
 public static WebElement btn_MyAccount(WebDriver driver){
    element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/a"));
    return element;
    }
 
 public static WebElement btn_LogOut(WebDriver driver){
    element = driver.findElement(By.xpath("/html/body/nav/ul/li/a"));
    return element;
    }

}