package com.janernest.test.login;

import java.util.concurrent.TimeUnit;

import com.janernest.test.Miscellaneous;
import org.openqa.selenium.By;
//import org.testng.Assert;
import org.testng.annotations.*;

public class loginTestCases {
	public Miscellaneous misc1 = new Miscellaneous();
	public String dashboardTitle = "Main Dashboard";
	
	@BeforeTest
	public void initialize(){
		misc1.setURL("http://freightbit-test.appspot.com/");		
	}
	
	public void login(String username, String password,int i/*, String scenario*/){
		int num = i;
		
		for(;num>0;num--){
		misc1.driver.findElement(By.id("username")).clear();
		misc1.driver.findElement(By.id("username")).sendKeys(username);
		misc1.driver.findElement(By.id("password")).clear();
		misc1.driver.findElement(By.id("password")).sendKeys(password);
		misc1.driver.findElement(By.id("_execute")).click();
		misc1.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		}
		/*if (scenario == "Valid"){
		Assert.assertEquals("dashboardTitle", misc1.driver.getTitle());
		}else{
			Assert.assertNotEquals("dashboardTitle", misc1.driver.getTitle());
		}*/
	}
	@Test
	public void testLoginValid(){
		login("admin", "password", 2);
		if(misc1.driver.getTitle().equals(dashboardTitle)){
			System.out.println("Passed!");
		}else{
			System.out.println("Failed!");
		}
	}
	
	@AfterTest
	public void endTest(){
		misc1.endSession();
	}
	
	
	
}
