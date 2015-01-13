package com.skosay.test.datamanagement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.skosay.test.pageobject.offcialLogin;;

public class Login extends CreateUser {
	String empty = "";
	String login = "http://app.skosay.com/webService";
	
	
    private static WebDriver driver = null;

	@BeforeTest
	public void setUp(){
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get(login);
    }
	
	public void inputLogin(String email, String password){
		offcialLogin.txt_Email(driver).clear();
		offcialLogin.txt_Email(driver).sendKeys(email);
		offcialLogin.txt_Password(driver).clear();
		offcialLogin.txt_Password(driver).sendKeys(password);
		offcialLogin.btn_LogIn(driver).click();
	}
	
	@AfterTest
	public void quit(){
		driver.quit();
	}
	
	@Test(priority = 0)
	public void log()throws Exception{
		inputLogin("admin1@admin.com","admin1");
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if (driver.getCurrentUrl().equals("http://app.skosay.com/webService")) {
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	}

}
