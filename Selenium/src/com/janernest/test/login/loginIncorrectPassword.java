package com.janernest.test.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class loginIncorrectPassword {

	public String baseURL= "http://freightbit-test.appspot.com/";
	public String dashboardTitle ="Main Dashboard";
	public WebDriver driver;
	
	@BeforeTest
	public void setBaseURL(){
		driver = new FirefoxDriver();
		driver.get(baseURL);
	}
	
	@Test
	public void testLoginIncorrectPassword(){
		driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("admin");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("incorrectPassword");
	    driver.findElement(By.id("_execute")).click();
	    Assert.assertNotEquals(dashboardTitle, driver.getTitle());
	}
	
	@AfterTest
	public void endSession(){
		driver.close();
		System.exit(0);
	}
}
