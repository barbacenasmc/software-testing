
package com.skosay.test.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.miscellaneous.test.Miscellaneous;

public class ConsumerLogin  {

	public Miscellaneous misc1 = new Miscellaneous();
	
	@BeforeClass
	public void setUp(){
	misc1.driver = new FirefoxDriver();
	misc1.driver.get("http://devapp.skosay.com/");
	}
	
	@AfterClass
	public void tearDown(){
	misc1.driver.quit();
	}
	
	
	public void inputLogin(String email, String password){

		misc1. driver.findElement(By.name("email")).clear();
		misc1.driver.findElement(By.id("email")).sendKeys(email);
		misc1. driver.findElement(By.name("password")).clear();
	    misc1.driver.findElement(By.id("password")).sendKeys(password);
	    
	    
	}
	
	public void endTest(){
		misc1.endSession();
	}
	
	
	@Test
	public void testFindElements()throws Exception{
		inputLogin("consumer1@consumer.com", "consumer1");
	//find the About link
	WebElement login= misc1.driver.findElement
	(By.xpath("/html/body/div/div[1]/input"));
	 
	// click to the link
	login.click();
	 
	// wait for 5 seconds
	Thread.sleep(5000);
	 
	// write out the title of the page in console
	System.out.println(misc1.driver.getCurrentUrl());
	
	if (misc1.driver.getCurrentUrl().equals("http://devapp.skosay.com/location")) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	 
	}
 
}






  
