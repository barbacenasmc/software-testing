package com.officialskosay.test.pageobject;
import org.openqa.selenium.*;

public class UsersPage {
	
private static WebElement element = null;
    

	//Create User Account

    public static WebElement Mnu_UsersAccounts(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/nav/ul/li[2]/a"));
    	return element;
     }
    
    public static WebElement tab_Users(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[1]/ul/li[1]/a"));
    	return element;
    }
    
    public static WebElement txt_AddUserName(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/form/div[1]/input"));
    	return element;
    }
    
    public static WebElement txt_AddUserEmail(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/form/div[2]/input"));
    	return element;
    }
    
    public static WebElement txt_AddUserPassword(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/form/div[3]/input"));
    	return element;
    }
    
    public static WebElement cbo_AddUserAccountType(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/form/div[4]/select"));
    	return element;
    }
    
    public static WebElement cbo_AddUserGroup(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/form/div[5]/select"));
    	return element;
    }
    
    public static WebElement btn_CreateNewAccount(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/button[1]"));
    	return element;
    }
    
    
    //Update User Account
    
    public static WebElement btn_Edit(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[2]/td[6]/div[1]/a/span"));
    	return element;
    }
    
    public static WebElement txt_EditUserName(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[2]/td[2]/div/input"));
    	return element;
    }

    public static WebElement txt_EditUserEmail(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[2]/td[3]/div/input"));
    	return element;
    }
    
    public static WebElement cbo_EditUserAccountType(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[2]/td[4]/div/label/select"));
    	return element;
    }
    
    public static WebElement btn_EditSave(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[2]/td[6]/div[2]/a[1]/span"));
    	return element;
    }
    
    public static WebElement btn_EditCancel(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[2]/td[6]/div[2]/a[2]/span"));
    	return element;
    }
    
    //Delete user account
    
    public static WebElement btn_Page4(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/center/ul/li[5]/a"));
    	return element;
    }
    
    public static WebElement btn_DeleteUserAcct(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[4]/td[6]/div[1]/form/a/span"));
    	return element;
    }
    
    
    
}

