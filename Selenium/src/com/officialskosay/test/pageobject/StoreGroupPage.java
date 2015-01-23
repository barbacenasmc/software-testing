package com.officialskosay.test.pageobject;
import org.openqa.selenium.*;

public class StoreGroupPage {
	
private static WebElement element = null;
    
    public static WebElement Mnu_Stores(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/nav/ul/li[3]/a"));
    	return element;
     }
    
    public static WebElement tab_StoreGroup(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[1]/ul/li[2]/a"));
    	return element;
     }
    
    public static WebElement txt_GroupName(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/form/div/input"));
        return element;
        }
    
    public static WebElement btn_Create(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/button[1]"));
        return element;
        }
    

    


}
