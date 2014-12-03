package com.skosay.test.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.skosay.test.pageobject.ManagerHomePage;
import com.skosay.test.pageobject.ManagerLoginPage;
 
public class ManagerLogin {
 
     private static WebDriver driver = null;
 
	@BeforeTest
	public void setUp(){
     driver = new FirefoxDriver();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     driver.get("http://devapp.skosay.com/administrator");
     }
	
	public void inputLogin(String email, String password){
		ManagerLoginPage.txt_Email(driver).clear();
		ManagerLoginPage.txt_Email(driver).sendKeys(email);
		ManagerLoginPage.txt_Password(driver).clear();
		ManagerLoginPage.txt_Password(driver).sendKeys(password);
		ManagerLoginPage.btn_LogIn(driver).click();
	}

	public void logout(){
		ManagerHomePage.btn_MyAccount(driver).click();
	    ManagerHomePage.btn_LogOut(driver).click(); 
	}
	   
	@AfterTest
	public void quit(){
		driver.quit();
	}
	
	
	@Test(priority = 0)
	
		public void validLogin()throws Exception{
		inputLogin("manage1@manage.com", "manage1");
		Thread.sleep(5000);
		
		if (driver.getCurrentUrl().equals("http://devapp.skosay.com/historypage")) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
			}
		logout();
		}
	
	@Test(priority = 1)
		
		public void invalidLoginIncorrectEmail()throws Exception{
			inputLogin("testcase@gmail.com", "manage1");
		Thread.sleep(5000);
		
		if (driver.findElement(By.xpath("/html/body/div/div/div[2]")).isDisplayed()) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
			}
		driver.navigate().refresh();
		}

	@Test(priority = 2)
	
		public void invalidLoginIncorrectPassword()throws Exception{
			inputLogin("manage1@manage.com", "password");
		Thread.sleep(5000);
		
		if (driver.findElement(By.xpath("/html/body/div/div/div[2]")).isDisplayed()) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
			}
		driver.navigate().refresh();
		}

	@Test(priority = 3)

		public void invalidLogin()throws Exception{
			inputLogin("testcase@gmail.com", "password");
		Thread.sleep(5000);
		
		if (driver.findElement(By.xpath("/html/body/div/div/div[2]")).isDisplayed()) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
			}
		driver.navigate().refresh();
		}
	
	@Test(priority = 4)
		
		public void noInputEmail()throws Exception{
			inputLogin("", "manage1");
		Thread.sleep(5000);
		
		if (driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).isEnabled()) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
			}
		driver.navigate().refresh();
		}

	@Test(priority = 5)
	
		public void noInputPassword()throws Exception{
			inputLogin("manage1@manage.com", "");
		Thread.sleep(5000);
		
		if (driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).isEnabled()) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + "Failed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
			}
		driver.navigate().refresh();
		}
	
	@Test(priority = 6)
	
		public void noInput()throws Exception{
			inputLogin("", "");
		Thread.sleep(5000);
		
		if (driver.findElement(By.xpath("/html/body/div/div/div[1]/input")).isEnabled()) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
			}
		quit();
		}
}




