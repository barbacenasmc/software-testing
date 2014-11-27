
package com.skosay.test.register;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import com.miscellaneous.test.Miscellaneous;

public class ConsumerRegister  {
	String loginurl = "http://devapp.skosay.com/";
	String errorurl = "http://devapp.skosay.com/register#errorMsg";

	public Miscellaneous misc1 = new Miscellaneous();
	
	@BeforeClass
	public void setUp(){
	misc1.setURL("http://devapp.skosay.com/register");
	misc1.driver.manage().window().maximize() ;
	}
	
	@AfterClass
	public void tearDown(){
	misc1.driver.quit();
	}
	
	
	public void inputRegister(String name, String email, String password, String confirm ){

		misc1. driver.findElement(By.name("nameField")).clear();
		misc1.driver.findElement(By.id("nameField")).sendKeys(name);
		misc1. driver.findElement(By.name("emailField")).clear();
	    misc1.driver.findElement(By.id("emailField")).sendKeys(email);
	    misc1. driver.findElement(By.name("passwordField")).clear();
	    misc1.driver.findElement(By.id("passwordField")).sendKeys(password);
	    misc1. driver.findElement(By.name("confirm-passwordField")).clear();
	    misc1.driver.findElement(By.id("confirm-passwordField")).sendKeys(confirm);
	    misc1.driver.findElement(By.xpath("/html/body/div/div[3]/input")).click();
	    
	    
	}
	
	public void endTest(){
		misc1.endSession();
	}
	
	/*
	@Test(priority = 0)
	//User fills-out the form with complete and correct details
	public void testValid()throws Exception{
		inputRegister("Juan Dela Cruz", "lacruz@gmail.com", "jdelacruz000", "jdelacruz000");
		misc1.driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		
	Thread.sleep(5000);
	
	if (misc1.driver.getCurrentUrl().equals(loginurl)) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		} 
	endTest();
	}
	
	
	@Test(priority = 1)
	//User fills-out the form with an email that was already in use
	public void testApplyUsedEmail()throws Exception{
		setUp();
		inputRegister("Juan Dela Cruz", "jdelacruz@gmail.com", "jdelacruz000", "jdelacruz000");
		misc1.driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
	
	if(misc1.driver.findElement(By.xpath("/html/body/div/form[2]/div/label/i[2]")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	misc1.driver.close();
	}
	
	
	@Test(priority = 2)
	//User fills-out the form and tried other valid email format
	public void testApplyOtherValidEmail()throws Exception{
		
		String [] validEmails = {"niceandsimple@example.com", "very.common@example.com", "a.little.lengthy.but.fine@dept.example.com", 
				"disposable.style.email.with+symbol@example.com", "other.email-with-dash@example.com", "user@localserver.com", "another_acceptable_example@server.com"};
		
		for(int i=0;i<validEmails.length;i++){
			inputRegister("Juan Dela Cruz", validEmails[i], "jdelacruz000", "jdelacruz000");
			misc1.driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
			
			Thread.sleep(5000);
			
			if (misc1.driver.getCurrentUrl().equals(loginurl)){
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ ":"+ validEmails[i]+ " Passed!");
			}else{
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +":"+ validEmails[i] + " Failed!");
			}
			misc1.driver.close();
			setUp();
		}	
		
	}
	

	@Test(priority = 3)
	//User fills-out the form and tried invalid email format
	public void testApplyInvalidEmails()throws Exception{
		
		String [] invalidEmails = {"Abc.example.com", "A@b@c@example.com","a\"b(c)d,e:f;g<h>i[j\\k]l@example.com", "just\"not\"right@example.com",
				"this is\"not\\allowed@example.com", "this\\ still\\\"not\\allowed@example.com","john..doe@example.com", "john.doe@example..com"};
		
		for(int i=0;i<invalidEmails.length;i++){
			//initialize();
			inputRegister("Juan Dela Cruz", invalidEmails[i], "jdelacruz000", "jdelacruz000");
			misc1.driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
			if(misc1.driver.findElement(By.xpath("/html/body/div/div[2]/div/center/h4/font")).isDisplayed()){
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ ":"+ invalidEmails[i]+ " Passed!");
			}else{
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +":"+ invalidEmails[i] + " Failed!");
			}
			misc1.driver.close();
			setUp();
		}	
	}
	
	
	
	@Test(priority = 4)
	//User fills-out the form with mismatched password and confirm password
	public void testApplyMismatchedPassword()throws Exception{
		setUp();
		inputRegister("Juan Dela Cruz", "jdelacruz1@gmail.com", "jdelacruz000", "jdelacruz012");
		misc1.driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		
	Thread.sleep(5000);
	
	if (misc1.driver.getCurrentUrl().equals(errorurl)){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	misc1.driver.close();
	}
	
	
	
	@Test(priority = 5)
	//User fills-out the form with password that is less than 7 characters
	public void testApplyShortPassword()throws Exception{
		setUp();
		inputRegister("Juan Dela Cruz", "jdelacruz@gmail.com", "jdela", "jdela");
		misc1.driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);

	Thread.sleep(5000);
	
	if (misc1.driver.getCurrentUrl().equals(errorurl)){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	misc1.driver.close();
	}
	*/
	
	
	@Test(priority = 6)
	//User did not enter a value on password field but entered a value on confirm password field
	public void testApplyNoValueOnPassword()throws Exception{
		//setUp();
		inputRegister("Juan Dela Cruz", "jdelacruz1@gmail.com", "", "jdelacruz000");
		misc1.driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
	
	if(misc1.driver.findElement(By.xpath("/html/body/div/div[3]/input")).isEnabled()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}
	misc1.driver.close();
	}
	
	
	/*
	@Test(priority = 7)
	//User enters a value on password field but did not enter a value on confirm password field
	public void testApplyNoValueOnConfirm()throws Exception{
		setUp();
		inputRegister("Juan Dela Cruz", "jdelacruz1@gmail.com", "jdelacruz000", "");
		misc1.driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
	
	if(misc1.driver.findElement(By.xpath("/html/body/div/div[3]/input")).isEnabled()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}
	misc1.driver.close();
	}
	
	
	
	@Test(priority = 8)
	//User did not enter values on password and confirm password field
	public void testApplyNoValueOnPasswordAndConfirm()throws Exception{
		setUp();
		inputRegister("Juan Dela Cruz", "jdelacruz1@gmail.com", "", "");
		misc1.driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
	
	if(misc1.driver.findElement(By.xpath("/html/body/div/div[3]/input")).isEnabled()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}
	misc1.driver.close();
	}
	*/
}