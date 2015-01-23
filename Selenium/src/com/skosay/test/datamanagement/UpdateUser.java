package com.skosay.test.datamanagement;
 
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.skosay.test.pageobject.UserPage;
 
public class UpdateUser{
	String empty = "";
	String admin = "http://app.skosay.com/webService";

	
     private static WebDriver driver = null;
 
	@BeforeTest
	public void setUp(){
     driver = new FirefoxDriver();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     driver.get(admin);
     }

	public void updateUser(String name, String email, String type){
		UserPage.btn_Edit(driver).click();
		UserPage.txt_EditName(driver).clear();
		UserPage.txt_EditName(driver).sendKeys(name);
		UserPage.txt_EditEmail(driver).clear();
		UserPage.txt_EditEmail(driver).sendKeys(email);
		UserPage.cbo_EditType(driver).click();
		UserPage.cbo_EditType(driver).sendKeys(type);
		UserPage.btn_EditSave(driver).click();
	}


	public void cancelUpdateUser(String name, String email, String type){
		UserPage.btn_Edit(driver).click();
		UserPage.txt_EditName(driver).clear();
		UserPage.txt_EditName(driver).sendKeys(name);
		UserPage.txt_EditEmail(driver).clear();
		UserPage.txt_EditEmail(driver).sendKeys(email);
		UserPage.cbo_EditType(driver).click();
		UserPage.cbo_EditType(driver).sendKeys(type);
		UserPage.btn_EditCancel(driver).click();
	}
	
	public void editUserManagement(String group){
		UserPage.tab_UserManagement(driver).click();
		UserPage.btn_EditUserGroup(driver).click();
	}

	   
	@AfterTest
	public void quit(){
		driver.quit();
	}


	@Test(priority = 0)
	//User edit an existing user account with correct details

	
	public void successReg()throws Exception{
		String name = "Name";
		String email = "name@email.com";
		String type = "Adminitrator";
	updateUser(name, email, type);
	Thread.sleep(5000);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	if( driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[5]/td[2]/div/input")).getText().equalsIgnoreCase(name) &&
	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[5]/td[3]/div/input")).getText().equalsIgnoreCase(email) && 
	driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[5]/td[4]/div/label/select")).getText().equalsIgnoreCase(type)){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed");
		}
	driver.navigate().refresh();
}
/*	
	@Test(priority = 1)
	//User edit an existing user account with correct details and changed the account type
	
	public void editAcctType()throws Exception{
	updateUser("consumer1","consumer1@consumer.com","Manager");
	Thread.sleep(5000);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	if( driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[5]/td[4]/p")).getText().equalsIgnoreCase("Manager")){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed");
		}
	driver.navigate().refresh();
}

	@Test(priority = 2)
	//User edit an existing user account and leave the name field with null value
	
	public void testApplyNoName()throws Exception{
	updateUser("","consumer1@consumer.com","Manager");
	Thread.sleep(5000);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	if(driver.findElement(By.xpath("")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
	}
	driver.navigate().refresh();
}
	
	@Test(priority = 3)
	//User edit an existing user account and leave the email address field with null value
	
	public void testApplyNoEmail()throws Exception{
	updateUser("","name@email.com","Manager");
	Thread.sleep(5000);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	if(driver.findElement(By.xpath("")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
	}
	driver.navigate().refresh();
}
	
	@Test(priority = 4)
	//User tried to edit an existing account and use an email that is already existing in the system
	
	public void testApplyExistingEmail()throws Exception{
	String email = "district1@manage.com";
	updateUser("Name", email ,"Manager");
	Thread.sleep(5000);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	if( driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[5]/td[3]/div/input")).getText().equalsIgnoreCase(email)){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed");
		}
	driver.navigate().refresh();
}
	*/
/*	@Test(priority = 5)
	//User edit an account and hit cancel after
	
	public void testApplyEditCancel()throws Exception{
	cancelUpdateUser("Name","name@email.com","Manager");
	Thread.sleep(5000);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	if( driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[5]/td[3]/div/input")).getText().equals(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[5]/td[3]/p")).getText())){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed");
		}
	driver.navigate().refresh();
}
	
	@Test(priority = 6)
	//User edit an account and tried to input a very long character in the name field
	
	public void testApplyLongCharName()throws Exception{
	updateUser("longlonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglonglong",
			"name@email.com","Manager");
	Thread.sleep(5000);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	if(driver.findElement(By.xpath("")).isDisplayed()){
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
	}else{
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
	}
	driver.navigate().refresh();
}
	
	@Test(priority = 7)
	//User edit an account and use other valid email formats
	public void testApplyOtherValidEmail()throws Exception{
		
		String [] validEmails = {"email@example.com",
								"firstname.lastname@example.com",
								"email@subdomain.example.com",
								"firstname+lastname@example.com",
								"1234567890@example.com",
								"email@example-one.com",
								"_______@example.com",
								"email@example.name",
								"email@example.museum",
								"email@example.co.jp",
								"firstname-lastname@example.com"};
		
		for(int i=0;i<validEmails.length;i++){
			updateUser("consumer1", validEmails[i], "Consumer");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			Thread.sleep(5000);
			
			if( driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[5]/td[3]/p")).getText().equalsIgnoreCase(validEmails[i])){
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + validEmails[i] + " Passed");
			}else{
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + validEmails[i] + " Failed");
		}
			driver.navigate().refresh();
		}
	}
	
	@Test(priority = 8)
	//User edit an account and use a invalid email address
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
			updateUser("Juan Dela Cruz", invalidEmails[i], "Consumer");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			Thread.sleep(5000);
			
			if( driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[5]/td[3]/p")).getText().equalsIgnoreCase(invalidEmails[i])){
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + invalidEmails[i] + " Failed!");
			}else{
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + invalidEmails[i] + " Passed!");
		}
			driver.navigate().refresh();
		}
	}
	*/
}
