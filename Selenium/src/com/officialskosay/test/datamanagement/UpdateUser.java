package com.officialskosay.test.datamanagement;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.officialskosay.test.pageobject.UsersPage;
import com.officialskosay.test.pageobject.UserManagentPage;
	 
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
			UsersPage.btn_Edit(driver).click();
			UsersPage.txt_EditUserName(driver).clear();
			UsersPage.txt_EditUserName(driver).sendKeys(name);
			UsersPage.txt_EditUserEmail(driver).clear();
			UsersPage.txt_EditUserEmail(driver).sendKeys(email);
			UsersPage.cbo_EditUserAccountType(driver).click();
			UsersPage.cbo_EditUserAccountType(driver).sendKeys(type);
			UsersPage.btn_EditSave(driver).click();
		}


		public void cancelUpdateUser(String name, String email, String type){
			UsersPage.btn_Edit(driver).click();
			UsersPage.txt_EditUserName(driver).clear();
			UsersPage.txt_EditUserName(driver).sendKeys(name);
			UsersPage.txt_EditUserEmail(driver).clear();
			UsersPage.txt_EditUserEmail(driver).sendKeys(email);
			UsersPage.cbo_EditUserAccountType(driver).click();
			UsersPage.cbo_EditUserAccountType(driver).sendKeys(type);
			UsersPage.btn_EditCancel(driver);
		}
		
		public void updateManagerUserGroup(String mngrgroup){
			UserManagentPage.tab_UserManagement(driver).click();
			UserManagentPage.btn_Edit(driver).click();
			UserManagentPage.cbo_UserGroup(driver).click();
			UserManagentPage.cbo_UserGroup(driver).sendKeys(mngrgroup);
			UserManagentPage.btn_EditSave(driver).click();
		}
		
		public void deleteUserAcct(){
			UsersPage.btn_Page4(driver).click();
			UsersPage.btn_DeleteUserAcct(driver);
		}

		
		@AfterTest
		public void quit(){
			driver.quit();
		}
		
		// @Test(priority = 0)		Issue
		//User edit an existing user account with correct details
		public void testApplyEditSuccess()throws Exception{
			String name = "Valid Name";
			String email = "validemail@email.com";
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
		
		//@Test(priority = 1)
		//User edit an existing user account and leave the name field with null value
		public void testApplyEditNoName()throws Exception{
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
		
		//@Test(priority = 2)
		//User edit an existing user account and leave the email address field with null value
		public void testApplyEditNoEmail()throws Exception{
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
		
		//@Test(priority = 3)
		//User tried to edit an existing account and use an email that is already existing in the system
		public void testApplyEditExistingEmail()throws Exception{
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
		
		//@Test(priority = 4)
		//User edit an account and use other valid email formats
		public void testApplyEditOtherValidEmail()throws Exception{
			
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
		
		//@Test(priority = 5)
		//User edit an account and use a invalid email address
		public void testApplyEditInvalidEmail()throws Exception{
			
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
		
		//@Test(priority = 6)
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
		
		//@Test(priority = 7)
		//User tried to edit an existing account then change to other user groups and save
		public void testApplyEditGroupofManager()throws Exception{
			String grp = "Walmart";
			updateManagerUserGroup(grp);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/table/tbody[2]/tr[5]/td[2]/div/input")).getText().equalsIgnoreCase(grp)){
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
			}else{
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
			}
			driver .navigate().refresh();
		}
			
		//@Test(priority = 8)
		//User edit an account and tried to input more than 255 character in the name field
		public void testApplyLongCharName()throws Exception{
			updateUser("namenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamename",
					"editname255@email.com","Consumer");
			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			if(driver.findElement(By.xpath("")).isDisplayed()){
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
			}else{
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
			}
			driver.navigate().refresh();
		}
		
		
		@Test(priority = 9)	
		//User tried to delete an existing user account
		public void testApplyDeleteUserAccount()throws Exception{
			deleteUserAcct();
			
		}
	
		// @Test(priority = 10)		javascript
		//User tried to delete an existing user account
		public void testApplyDeleteAcctUserMngt()throws Exception{
		}

		
		
}
