package com.officialskosay.test.pageobject;
import org.openqa.selenium.*;

public class UserManagentPage {
	
private static WebElement element = null;


    public static WebElement tab_UserManagement(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[1]/ul/li[2]/a"));
    	return element;
    }
    
    public static WebElement btn_Edit(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/table/tbody[2]/tr[2]/td[5]/div[1]/a/span"));
    	return element;
    }
    
    public static WebElement cbo_UserGroup(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/table/tbody[2]/tr[2]/td[4]/div/select"));
    	return element;
    }
    
    public static WebElement btn_EditSave(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/table/tbody[2]/tr[2]/td[5]/div[2]/a[1]/span"));
    	return element;
    }
    
    public static WebElement btn_EditCancel(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/table/tbody[2]/tr[2]/td[5]/div[2]/a[2]/span"));
    	return element;
    }
    
    
}
