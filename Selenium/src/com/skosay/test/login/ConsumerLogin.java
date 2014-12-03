package com.skosay.test.login;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.skosay.test.pageobject.HomePage;
import com.skosay.test.pageobject.LoginPage;
 
public class ConsumerLogin {
 
     private static WebDriver driver = null;
 
	@BeforeTest
	public void setUp(){
     driver = new FirefoxDriver();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     driver.get("http://devapp.skosay.com/");
     }
	
	public void inputLogin(String email, String password){
		LoginPage.txt_Email(driver).clear();
		LoginPage.txt_Email(driver).sendKeys(email);
		LoginPage.txt_Password(driver).clear();
		LoginPage.txt_Password(driver).sendKeys(password);
		LoginPage.btn_LogIn(driver).click();
	}

	public void logout(){
		HomePage.btn_MyAccount(driver).click();
	    HomePage.btn_LogOut(driver).click(); 
	}
	   
	@AfterTest
	public void quit(){
		driver.quit();
	}
  
   @Test(priority = 0)
	public void validLogin()throws Exception{
	inputLogin("consumer1@consumer.com","consumer1");
	Thread.sleep(5000);
	
	if (driver.getCurrentUrl().equals("http://devapp.skosay.com/location")) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	logout();
	}
   
   @Test(priority = 1)
	public void invalidLoginAccountNotConfirmed()throws Exception{
	inputLogin("testcase@gmail.com", "password");
	Thread.sleep(5000);
	
	if (driver.getCurrentUrl().equals("http://devapp.skosay.com/")) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	driver.navigate().refresh();
	}


	@Test(priority = 2)
	public void invalidLoginIncorrectEmail()throws Exception{
	inputLogin("testcase@gmail.com", "consumer1");
	Thread.sleep(5000);
	
	if (driver.findElement(By.xpath("/html/body/div/div[1]")).isDisplayed()) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	driver.navigate().refresh();
	}
	
	
	@Test(priority = 3)
	public void invalidLoginIncorrectPassword()throws Exception{
	inputLogin("consumer1@consumer.com", "password");
	Thread.sleep(5000);
	
	if (driver.findElement(By.xpath("/html/body/div/div[1]")).isDisplayed()) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	driver.navigate().refresh();
	}
	
	
	@Test(priority = 4)
	public void invalidLogin()throws Exception{
	inputLogin("testcase@gmail.com", "password");
	Thread.sleep(5000);
	
	if (driver.findElement(By.xpath("/div/center/h4/font")).isDisplayed()) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	driver.navigate().refresh();
	}
	
	
	@Test(priority = 5)
	public void noInputEmail()throws Exception{
	inputLogin("", "consumer1");
	Thread.sleep(5000);
	
	if (driver.findElement(By.xpath("/html/body/div/div[1]/input")).isEnabled()) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}
	driver.navigate().refresh();
	}
	
	
	@Test(priority = 6)
	public void noInputPassword()throws Exception{
	inputLogin("consumer1@consumer.com", "");
	Thread.sleep(5000);
	
	if (driver.findElement(By.xpath("/html/body/div/div[1]/input")).isEnabled()) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}
	driver.navigate().refresh();
	}
	
	@Test(priority = 7)
	public void noInput()throws Exception{
	inputLogin("", "");
	Thread.sleep(5000);
	
	if (driver.findElement(By.xpath("/html/body/div/div[1]/input")).isEnabled()) {
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}
	quit();
	}
	
}