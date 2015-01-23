package com.officialskosay.test.pageobject;
import org.openqa.selenium.*;

public class StoresPage {
	
private static WebElement element = null;
    
    public static WebElement Mnu_Stores(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/nav/ul/li[3]/a"));
    	return element;
     }
    
    public static WebElement tab_Stores(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/a"));
    	return element;
    }
    
    public static WebElement btn_DeleteStore(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[2]/td[4]/div[1]/form/a/span"));
    	return element;
    }
    
    

}
