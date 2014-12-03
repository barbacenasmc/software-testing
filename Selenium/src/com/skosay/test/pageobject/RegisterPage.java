package com.skosay.test.pageobject;
 
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class RegisterPage {
 
        private static WebElement element = null;
 
    public static WebElement txt_Username(WebDriver driver){
         element = driver.findElement(By.id("nameField"));
         return element;
         }
 
     public static WebElement txt_Email(WebDriver driver){
         element = driver.findElement(By.id("emailField"));
         return element;
         }
     
     public static WebElement txt_Password(WebDriver driver){
         element = driver.findElement(By.id("passwordField"));
         return element;
         }
 
     public static WebElement txt_ConfirmPassword(WebDriver driver){
         element = driver.findElement(By.id("confirm-passwordField"));
         return element;
         }
 
     public static WebElement btn_LogIn(WebDriver driver){
         element = driver.findElement(By.xpath("/html/body/div/div[3]/input"));
         return element;
         }
}