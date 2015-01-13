package com.skosay.test.pageobject;


import org.openqa.selenium.*;

public class offcialLogin {
	
	  private static WebElement element = null;
	  
	    public static WebElement txt_Email(WebDriver driver){
	         element = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/form/div[1]/input"));
	         return element;
	         }
	 
	     public static WebElement txt_Password(WebDriver driver){
	         element = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/form/div[2]/input"));
	         return element;
	         }
	 
	     public static WebElement btn_LogIn(WebDriver driver){
	         element = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/button[1]"));
	         return element;
	         }

}
