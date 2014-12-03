package com.skosay.test.register;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.skosay.test.pageobject.RegisterPage;

 
public class ConsumerRegister {
	String loginurl = "http://devapp.skosay.com/";
	String errorurl = "http://devapp.skosay.com/register#errorMsg";
 
     private static WebDriver driver = null;
 
	@BeforeTest
	public void setUp(){
     driver = new FirefoxDriver();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     driver.get("http://devapp.skosay.com/register");
     }
	
	public void inputRegister(String name, String email, String password, String confirm){
		RegisterPage.txt_Username(driver).clear();
		RegisterPage.txt_Username(driver).sendKeys(name);
		RegisterPage.txt_Email(driver).clear();
		RegisterPage.txt_Email(driver).sendKeys(email);
		RegisterPage.txt_Password(driver).clear();
		RegisterPage.txt_Password(driver).sendKeys(password);
		RegisterPage.txt_ConfirmPassword(driver).clear();
		RegisterPage.txt_ConfirmPassword(driver).sendKeys(confirm);
		RegisterPage.btn_LogIn(driver).click();
	}

	   
	@AfterTest
	public void quit(){
		driver.quit();
	}
	
	
	@Test(priority = 0)
	//User fills-out the form with complete and correct details
	public void testValid()throws Exception{
		inputRegister("Juan Dela Cruz", "juancruz@gmail.com", "jdelacruz000", "jdelacruz000");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		
	Thread.sleep(5000);
	
	if (driver.getCurrentUrl().equals(loginurl)) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		} 
	driver.navigate().refresh();
	}
	
	
	@Test(priority = 1)
	//User fills-out the form with an email that was already in use
	public void testApplyUsedEmail()throws Exception{
		inputRegister("Juan Dela Cruz", "jdelacruz@gmail.com", "jdelacruz000", "jdelacruz000");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
	
	if(driver.findElement(By.xpath("/html/body/div/form[2]/div/label/i[2]")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	driver.navigate().refresh();
	}
	
	
	@Test(priority = 2)
	//User fills-out the form and tried other valid email format
	public void testApplyOtherValidEmail()throws Exception{
		
		String [] validEmails = {"nicensimple@example.com", "very.commn@example.com", "a.little.lengthy.but.fine@dept.example.com", 
				"disposable.style.email.with+symbol@example.com", "other.email-with-dash@example.com", "user@localserver.com", "another_acceptable_example@server.com"};
		
		for(int i=0;i<validEmails.length;i++){
			inputRegister("Juan Dela Cruz", validEmails[i], "jdelacruz000", "jdelacruz000");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
			
			Thread.sleep(5000);
			
			if (driver.getCurrentUrl().equals(loginurl)){
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ ":"+ validEmails[i]+ " Passed!");
			}else{
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +":"+ validEmails[i] + " Failed!");
			}
			driver.navigate().refresh();
		}	
		
	}
	

	@Test(priority = 3)
	//User fills-out the form and tried invalid email format
	public void testApplyInvalidEmails()throws Exception{
		
		String [] invalidEmails = {"Abc.example.com", "A@b@c@example.com","a\"b(c)d,e:f;g<h>i[j\\k]l@example.com", "just\"not\"right@example.com",
				"this is\"not\\allowed@example.com", "this\\ still\\\"not\\allowed@example.com","john..doe@example.com", "john.doe@example..com"};
		
		for(int i=0;i<invalidEmails.length;i++){
			inputRegister("Juan Dela Cruz", invalidEmails[i], "jdelacruz000", "jdelacruz000");
			Thread.sleep(5000);
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
			if(driver.findElement(By.xpath("/html/body/div/div[2]/div/center/h4/font")).isDisplayed()){
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ ":"+ invalidEmails[i]+ " Passed!");
			}else{
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +":"+ invalidEmails[i] + " Failed!");
			}
			driver.navigate().refresh();
		}	
	}
	
	
	
	@Test(priority = 4)
	//User fills-out the form with mismatched password and confirm password
	public void testApplyMismatchedPassword()throws Exception{
		inputRegister("Juan Dela Cruz", "jdelacruz1@gmail.com", "jdelacruz000", "jdelacruz012");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
		
	Thread.sleep(5000);
	
	if (driver.getCurrentUrl().equals(errorurl)){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	driver.navigate().refresh();
	}
	
	
	
	@Test(priority = 5)
	//User fills-out the form with password that is less than 7 characters
	public void testApplyShortPassword()throws Exception{
		inputRegister("Juan Dela Cruz", "jdelacruz@gmail.com", "jdela", "jdela");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);

	Thread.sleep(5000);
	
	if (driver.getCurrentUrl().equals(errorurl)){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	driver.navigate().refresh();
	}
	
	
	
	@Test(priority = 6)
	//User did not enter a value on password field but entered a value on confirm password field
	public void testApplyNoValueOnPassword()throws Exception{
		inputRegister("Juan Dela Cruz", "jdelacruz1@gmail.com", "", "jdelacruz000");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
	
	if(driver.findElement(By.xpath("/html/body/div/div[3]/input")).isEnabled()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}
	driver.navigate().refresh();
	}
	
	
	
	@Test(priority = 7)
	//User enters a value on password field but did not enter a value on confirm password field
	public void testApplyNoValueOnConfirm()throws Exception{
		inputRegister("Juan Dela Cruz", "jdelacruz1@gmail.com", "jdelacruz000", "");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
	
	if(driver.findElement(By.xpath("/html/body/div/div[3]/input")).isEnabled()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}
	driver.navigate().refresh();
	}
	
	
	
	@Test(priority = 8)
	//User did not enter values on password and confirm password field
	public void testApplyNoValueOnPasswordAndConfirm()throws Exception{
		inputRegister("Juan Dela Cruz", "jdelacruz1@gmail.com", "", "");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
	
	if(driver.findElement(By.xpath("/html/body/div/div[3]/input")).isEnabled()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}
	driver.navigate().refresh();
	}
	
}