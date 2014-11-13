package com.janernest.test.roles;

import com.janernest.test.login.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
import org.testng.annotations.*;

public class admin {
	
	public String baseURL= "http://freightbit-test.appspot.com/";
	public String dashboardTitle ="Main Dashboard";
	public WebDriver driver;
	
	@BeforeTest
	public void setBaseURL(){
		driver = new FirefoxDriver();
		driver.get(baseURL);
	}
	
	@Test
	public void testAdmin(){
		doubleLoginCorrect test1 = new doubleLoginCorrect();
		test1.loginCorrect();
		driver.findElement(By.linkText("Booking"));
		//Assert.ass
		
	}
	
}
