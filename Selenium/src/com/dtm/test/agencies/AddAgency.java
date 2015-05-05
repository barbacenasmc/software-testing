package com.dtm.test.agencies;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.dtm.test.pageobject.ManageData;

public class AddAgency {
	
	private static WebDriver driver = null;
	
	@BeforeTest
	public void setUp(){
		driver = new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("localhost:8000");   
	     
	}
	
	public void openAddAgencyForm(){
		ManageData.btn_Add(driver).click();
		ManageData.link_NewAgency(driver).click();
	}


}
