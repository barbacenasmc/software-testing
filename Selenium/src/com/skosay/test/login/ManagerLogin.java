package com.skosay.test.login;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.miscellaneous.test.Miscellaneous;


public class ManagerLogin {
	
	String loginurl = "http://devapp.skosay.com/administrator";
	String successloginurl = "http://devapp.skosay.com/historypage";
	
public Miscellaneous misc1 = new Miscellaneous();
	
	@BeforeTest
	public void setUp(){
	misc1.setURL("http://devapp.skosay.com/administrator");
	}
	
	public void inputLogin(String email, String password){

		misc1.driver.findElement(By.name("email")).clear();
		misc1.driver.findElement(By.id("email")).sendKeys(email);
		misc1.driver.findElement(By.name("password")).clear();
	    misc1.driver.findElement(By.id("password")).sendKeys(password);
	    misc1.driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).click();
	  
	}
	
	public void endTest(){
		misc1.endSession();
	}
	
	@AfterTest
	public void tearDown(){
	misc1.driver.quit();
	}
	
	/*
	@Test(priority = 0)
	
	//User logged in with correct login details
		public void validLogin()throws Exception{
			inputLogin("manage1@manage.com", "manage1");
		 
		// write out the title of the page in console
		System.out.println(misc1.driver.getCurrentUrl());
		
		// wait for 5 seconds
		Thread.sleep(5000);
		
		if (misc1.driver.getCurrentUrl().equals("loginurl")) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
			}
		misc1.driver.close();
		}
	
	@Test(priority = 1)
		
	//User logged in with incorrect email but correct password
		public void invalidLoginIncorrectEmail()throws Exception{
			setUp();
			inputLogin("testcase@gmail.com", "manage1");
		 
		// write out the title of the page in console
		System.out.println(misc1.driver.getCurrentUrl());
		
		// wait for 5 seconds
		Thread.sleep(5000);
		
		if (misc1.driver.getCurrentUrl().equals("successloginurl")) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
			}
		}

	@Test(priority = 2)
	
	//User logged in with correct email but incorrect password
		public void invalidLoginIncorrectPassword()throws Exception{
			inputLogin("manage1@manage.com", "password");
		 
		// write out the title of the page in console
		System.out.println(misc1.driver.getCurrentUrl());
		
		// wait for 5 seconds
		Thread.sleep(5000);
		
		if (misc1.driver.getCurrentUrl().equals("successloginurl")) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
			}
		}

	@Test(priority = 3)

	//User logged in with both incorrect email and password
		public void invalidLogin()throws Exception{
			inputLogin("testcase@gmail.com", "password");
		 
		// write out the title of the page in console
		System.out.println(misc1.driver.getCurrentUrl());
		
		// wait for 5 seconds
		Thread.sleep(5000);
		
		if (misc1.driver.getCurrentUrl().equals("successloginurl")) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
			}
		}

	@Test(priority = 4)
		
	//User tried to login without input on email field but entered a correct value on password field
		public void noInputEmail()throws Exception{
			inputLogin("", "manage1");
		 
		// write out the title of the page in console
		System.out.println(misc1.driver.getCurrentUrl());
		
		// wait for 5 seconds
		Thread.sleep(5000);
		
		if (misc1.driver.getCurrentUrl().equals("successloginurl")) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
			}
		} */

	@Test(priority = 5)
	
	//User entered correct email but did not enter a value on password field
		public void noInputPassword()throws Exception{
			inputLogin("manage1@manage.com", "");
		 
		// write out the title of the page in console
		System.out.println(misc1.driver.getCurrentUrl());
		
		// wait for 5 seconds
		Thread.sleep(5000);
		
		if (misc1.driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).isEnabled()) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
			}
		}
	
/*
	@Test(priority = 6)
	
	//User tried to login without input on any field
		public void noInput()throws Exception{
			inputLogin("", "");
		 
		// write out the title of the page in console
		System.out.println(misc1.driver.getCurrentUrl());
		
		// wait for 5 seconds
		Thread.sleep(5000);
		
		if (misc1.driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).isEnabled()) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
			}
		misc1.driver.close();
		}*/
}




