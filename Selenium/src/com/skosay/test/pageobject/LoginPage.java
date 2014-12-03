package com.skosay.test.pageobject;
 
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class LoginPage {
 
        private static WebElement element = null;
 
    public static WebElement txt_Email(WebDriver driver){
         element = driver.findElement(By.id("email"));
         return element;
         }
 
     public static WebElement txt_Password(WebDriver driver){
         element = driver.findElement(By.id("password"));
         return element;
         }
 
     public static WebElement btn_LogIn(WebDriver driver){
         element = driver.findElement(By.xpath("/html/body/div/div[1]/input"));
         return element;
         }
}