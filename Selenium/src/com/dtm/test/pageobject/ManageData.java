package com.dtm.test.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ManageData {
	private static WebElement element = null;
	
public static WebElement btn_Add(WebDriver driver){
	    element = driver.findElement(By.xpath("//button[@type='button']"));
	    return element;
	    }
public static WebElement link_NewAgency(WebDriver driver){
		element = driver.findElement(By.linkText("New Agency"));
		return element;
	}
	 
}

