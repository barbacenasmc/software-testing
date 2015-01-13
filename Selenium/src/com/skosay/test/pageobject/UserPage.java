package com.skosay.test.pageobject;

import org.openqa.selenium.*;

public class UserPage {

    private static WebElement element = null;
    
    public static WebElement txt_Name(WebDriver driver){
     element = driver.findElement(By.id("name"));
     return element;
     }
    
    public static WebElement txt_Email(WebDriver driver){
        element = driver.findElement(By.id("email"));
        return element;
        }
    
    public static WebElement txt_Password(WebDriver driver){
        element = driver.findElement(By.id("password"));
        return element;
        }
    
    public static WebElement cbo_AccountType(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/form/div[4]/select"));
        return element;
        }
    
    public static WebElement btn_Create(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/button[1]"));
        return element;
        }
    
    public static WebElement btn_Edit(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[5]/td[6]/div[1]/a/span"));
        return element;
        }
    
    public static WebElement txt_EditName(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[5]/td[2]/div/input"));
        return element;
        }
    
    public static WebElement txt_EditEmail(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[5]/td[3]/div/input"));
        return element;
        }
    
    public static WebElement cbo_EditType(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[5]/td[4]/div/label/select"));
        return element;
        }
    
    public static WebElement btn_EditSave(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[5]/td[6]/div[2]/a[1]/span"));
        return element;
        }
    
    public static WebElement btn_EditCancel(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[1]/td[6]/div[2]/a[2]/span"));
        return element;
        }
    
}
