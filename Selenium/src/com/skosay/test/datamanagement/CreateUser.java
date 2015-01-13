package com.skosay.test.datamanagement;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.skosay.test.pageobject.UserPage;
 
public class CreateUser{
	String empty = "";
	String login = "http://app.skosay.com/webService";

	
     private static WebDriver driver = null;
 
	@BeforeTest
	public void setUp(){
     driver = new FirefoxDriver();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     driver.get(login);
     }

	public void registerUser(String name, String email, String password, String type){
		UserPage.txt_Name(driver).clear();
		UserPage.txt_Name(driver).sendKeys(name);
		UserPage.txt_Email(driver).clear();
		UserPage.txt_Email(driver).sendKeys(email);
		UserPage.txt_Password(driver).clear();
		UserPage.txt_Password(driver).sendKeys(password);
		UserPage.cbo_AccountType(driver).click();
		UserPage.cbo_AccountType(driver).sendKeys(type);
		UserPage.btn_Create(driver).click();
	}


	   
	@AfterTest
	public void quit(){
		driver.quit();
	}


	@Test(priority = 1)
	//User fills-out the form with correct details
	
	public void successReg()throws Exception{
	registerUser("Name","name22@email.com","password","Consumer");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
	}
}
	
	@Test(priority = 2)
	//Admin tried to create user with no input in the name field
	public void testApplyNoName()throws Exception{
		registerUser("", "jdelacruz@gmail.com", "jdelacruz000", "Consumer");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}
	driver.navigate().refresh();
	}
	
	@Test(priority = 3)
	//Admin tried to create user with no input in the email field
	public void testApplyNoEmail()throws Exception{
		registerUser("Juan Dela Cruz", "", "jdelacruz000", "Consumer");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	driver.navigate().refresh();
	}
	
	@Test(priority = 4)
	//Admin tried create user with no input in the password field
	public void testApplyNoPass()throws Exception{
		registerUser("Juan Dela Cruz", "jdelacruz@email.com", "", "Consumer");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	driver.navigate().refresh();
	}
	
	@Test(priority = 5)
	//Admin tried create user with no input in all fields
	public void testApplyNoInput()throws Exception{
		registerUser("", "", "","");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	driver.navigate().refresh();
	}
	
	@Test(priority = 6)
	//User fills-out the form and tried other types of valid email address formats
	public void testApplyOtherValidEmail()throws Exception{
		
		String [] validEmails = {"niceandsimple@example.com",
								"very.common@example.com",
								"a.little.lengthy.but.fine@dept.example.com",
								"disposable.style.email.with+symbol@example.com",
								"other.email-with-dash@example.com",
								"much.more unusual@example.com",
								"very.unusual.@.unusual.com@example.com",
								"very.(),:;<>[].VERY.very@ very.unusual@strange.example.com",
								"!#$%&'*+-/=?^_`{}|~@example.org",
								"()<>[]:,;@\\\"!#$%&'*+-/=?^_`{}| ~.a@example.org",
								" @example.org"};
		
		for(int i=0;i<validEmails.length;i++){
			registerUser("Juan Dela Cruz", validEmails[i], "jdelacruz000", "Consumer");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			Thread.sleep(5000);
			
			if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ ":"+ validEmails[i]+ " Passed!");
			}else{
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +":"+ validEmails[i] + " Failed!");
			}
			driver.navigate().refresh();
		}
	}
	
	@Test(priority = 7)
	//User fills-out the form and tried invalid email address formats
	public void testApplyInvalidEmail()throws Exception{
		
		String [] invalidEmails = {"Abc.example.com",
									"A@b@c@example.com",
									"justnotright@example.com",
									"this isnotallowed@example.com",
									"this stillnotallowed@example.com",
									"john..doe@example.com",
									"john.doe@example..com",
									" leadingspace@email.com"};
		
		for(int i=0;i<invalidEmails.length;i++){
			registerUser("Juan Dela Cruz", invalidEmails[i], "jdelacruz000", "Consumer");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			Thread.sleep(5000);
			
			if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ ":"+ invalidEmails[i]+ " Passed!");
			}else{
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +":"+ invalidEmails[i] + " Failed!");
			}
			driver.navigate().refresh();
		}
	}
	
	@Test(priority = 8)
	//User tried to create account with used email address
	public void testApplyUsedEmail()throws Exception{
		registerUser("Name", "admin2@admin.com", "password", "Administrator");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	driver.navigate().refresh();
	}
	
	@Test(priority = 9)
	//User tried to create an account correct with details but input only blank space in the Name Field 
	public void testApplyBlankSpaceName()throws Exception{
		registerUser(" ", "name@email.com", "password", "Consumer");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}
	driver.navigate().refresh();
	}
	
	@Test(priority = 10)
	//User tried to create an account with correct details but input only blank space in the Email Field 
	public void testApplyBlankSpaceEmail()throws Exception{
		registerUser("Name", " ", "password", "Consumer");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	driver.navigate().refresh();
	}
	
	@Test(priority = 11)
	//User tried to create an account with correct details but input only blank space in the Password Field  
	public void testApplyBlankSpacePass()throws Exception{
		registerUser("Name", " ", "password", "Consumer");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	driver.navigate().refresh();
	}
	
	@Test(priority = 12)
	//User tried to create an account and fills-out the form with more than 255 characters in the Name Field  
	public void testApply255CharName()throws Exception{
		registerUser("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 
				"name@email.com", "password", "Consumer");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}
	driver.navigate().refresh();
	}
	
	@Test(priority = 13)
	//User tried to create an account and fills-out the form with more than 128 characters in the Email Field 
	public void testApply128CharEmail()throws Exception{
		registerUser("Name", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@email.com",
				"password", "Consumer");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	driver.navigate().refresh();
	}
	
	@Test(priority = 14)
	//User tried to create an account and fills-out the form with with more than 255 characters in the Password Field  
	public void testApply255CharPass()throws Exception{
		registerUser("Name", "name@email.com",
					"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
					"Consumer");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}
	driver.navigate().refresh();
	}
	
	@Test(priority = 15)
	//User tried to create an account with less than 7 characters input in password field  
	public void testApply7CharPass()throws Exception{
		registerUser("Name", "name@email.com", "pass", "Consumer");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	driver.navigate().refresh();
	}
	
	@Test(priority = 16)
	//User creates a user account for admin
	public void testApplyUserAdmin()throws Exception{
		registerUser("MRamoz", "mramoz@gmail.com", "mramoz000", "Administrator");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	driver.navigate().refresh();
	}
	
	@Test(priority = 17)
	//User creates a user account for district manager 
	public void testApplyUserDManager()throws Exception{
		registerUser("SBautista", "sbautista@gmail.com", "sbautista000", "District Manager");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	driver.navigate().refresh();
	}
	
	@Test(priority = 18)
	//User creates a user account for manager 
	public void testApplyUserManager()throws Exception{
		registerUser("Castillo", "rcastillo@gmail.com", "rcastillo000", "Manager");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	driver.navigate().refresh();
	}
	
	@Test(priority = 19)
	//User creates a user account for consumer
	public void testApplyUserConsumer()throws Exception{
		registerUser("Juan Dela Cruz", "jdelacruz@gmail.com", "jdelacruz000", "Consumer");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
	driver.navigate().refresh();
	}
	
	
	@Test(priority = 20)
	//User creates a user account for consumer
	public void testApplyNotClear()throws Exception{
		String name = "Juan Dela";
		String email = "jdela@gmail.com";
		String pass = "jdela000";
		String type = "Consumer";
		
		registerUser(name, email, pass, type);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
	
	if( driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/form/div[2]/input")).getText().equalsIgnoreCase(name)){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed");
		}
	driver.navigate().refresh();
	}

}
