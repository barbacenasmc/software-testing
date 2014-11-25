
package com.skosay.test.register;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.miscellaneous.test.Miscellaneous;

public class ConsumerRegister  {

	public Miscellaneous misc1 = new Miscellaneous();
	
	@BeforeClass
	public void setUp(){
	misc1.driver = new FirefoxDriver();
	misc1.driver.get("http://devapp.skosay.com/register");
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
	    
	    
	}
	
	public void endTest(){
		misc1.endSession();
	}
	
	
	/*@Test(priority = 0)
	public void testValid()throws Exception{
		inputRegister("Juan Dela Cruz", "jdelacruz@gmail.com", "jdelacruz000", "jdelacruz000");
		misc1.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	WebElement register= misc1.driver.findElement
	(By.xpath("/html/body/div/div[3]/input"));
	register.click();
	Thread.sleep(5000);
	 
	System.out.println(misc1.driver.getCurrentUrl());
	
	if (misc1.driver.getCurrentUrl().equals("http://devapp.skosay.com/")) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		} 
	}
	*/
	
	/*@Test(priority = 1)
	public void testApplyUsedEmail()throws Exception{
		inputRegister("Juan Dela Cruz", "jdelacruz@gmail.com", "jdelacruz000", "jdelacruz000");
		misc1.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	WebElement register= misc1.driver.findElement
	(By.xpath("/html/body/div/div[3]/input"));
	register.click();
	Thread.sleep(5000);
	
	if(misc1.driver.findElement(By.xpath("/html/body/div/form[2]/div/label/i[2]")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	}
	*/
	
	
	/*@Test(priority = 2)
	public void testApplyOtherValidEmail()throws Exception{
		
		String [] validEmails = {"niceandsimple@example.com", "very.common@example.com", "a.little.lengthy.but.fine@dept.example.com", 
				"disposable.style.email.with+symbol@example.com", "other.email-with-dash@example.com", "user@localserver.com", "another_acceptable_example@server.com"};
		
		for(int i=0;i<validEmails.length;i++){
			//initialize();
			inputRegister("Juan Dela Cruz", validEmails[i], "jdelacruz000", "jdelacruz000");
			if(misc1.driver.findElement(By.xpath("/html/body/div/div[3]/input")).isEnabled()){
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ ":"+ validEmails[i]+ " Passed!");
			}else{
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +":"+ validEmails[i] + " Failed!");
			}
			misc1.driver.close();
		}	
		
	}
	*/
	
	
	/*@Test(priority = 3)
	public void testApplyInvalidEmails()throws Exception{
		
		String [] invalidEmails = {"Abc.example.com", "A@b@c@example.com","a"b(c)d,e:f;g<h>i[j\k]l@example.com", "just"not"right@example.com",
				"this is"not\allowed@example.com", "this\ still\"not\\allowed@example.com ","john..doe@example.com", "john.doe@example..com"};
		
		for(int i=0;i<invalidEmails.length;i++){
			//initialize();
			inputRegister("Juan Dela Cruz", invalidEmails[i], "jdelacruz000", "jdelacruz000");
			if(misc1.driver.findElement(By.xpath("/html/body/div/form[2]/div/label/i[2]")).isDisplayed()){
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ ":"+ invalidEmails[i]+ " Passed!");
			}else{
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +":"+ invalidEmails[i] + " Failed!");
			}
			misc1.driver.close();
		}	
	}
	*/
	
	
	/*@Test(priority = 4)
	public void testApplyMismatchedPassword()throws Exception{
		inputRegister("Juan Dela Cruz", "jdelacruz1@gmail.com", "jdelacruz000", "jdelacruz012");
		misc1.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	WebElement register= misc1.driver.findElement
	(By.xpath("/html/body/div/div[3]/input"));
	register.click();
	Thread.sleep(5000);
	
	if (misc1.driver.getCurrentUrl().equals("http://devapp.skosay.com/register#errorMsg")){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	}
	*/
	
	
	/*@Test(priority = 5)
	public void testApplyShortPassword()throws Exception{
		inputRegister("Juan Dela Cruz", "jdelacruz@gmail.com", "jdela", "jdela");
		misc1.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	WebElement register= misc1.driver.findElement
	(By.xpath("/html/body/div/div[3]/input"));
	register.click();
	Thread.sleep(5000);
	
	if (misc1.driver.getCurrentUrl().equals("http://devapp.skosay.com/register#errorMsg")){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	}
	*/
	
	
	/*@Test(priority = 6)
	public void testApplyNoValueOnPassword()throws Exception{
		inputRegister("Juan Dela Cruz", "jdelacruz1@gmail.com", "", "jdelacruz000");
		misc1.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	WebElement register= misc1.driver.findElement
	(By.xpath("/html/body/div/div[3]/input"));
	register.click();
	Thread.sleep(5000);
	
	if(misc1.driver.findElement(By.xpath("/html/body/div/div[3]/input")).isEnabled()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}
	}
	*/
	
	
	/*@Test(priority = 7)
	public void testApplyNoValueOnConfirm()throws Exception{
		inputRegister("Juan Dela Cruz", "jdelacruz1@gmail.com", "jdelacruz000", "");
		misc1.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	WebElement register= misc1.driver.findElement
	(By.xpath("/html/body/div/div[3]/input"));
	register.click();
	Thread.sleep(5000);
	
	if(misc1.driver.findElement(By.xpath("/html/body/div/div[3]/input")).isEnabled()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}
	}
	*/
	
	
	@Test(priority = 8)
	public void testApplyNoValueOnPasswordAndConfirm()throws Exception{
		inputRegister("Juan Dela Cruz", "jdelacruz1@gmail.com", "", "");
		misc1.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	WebElement register= misc1.driver.findElement
	(By.xpath("/html/body/div/div[3]/input"));
	register.click();
	Thread.sleep(5000);
	
	if(misc1.driver.findElement(By.xpath("/html/body/div/div[3]/input")).isEnabled()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}
	}
	
}