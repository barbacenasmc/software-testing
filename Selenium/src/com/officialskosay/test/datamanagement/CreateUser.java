package com.officialskosay.test.datamanagement;

import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.officialskosay.test.pageobject.UsersPage;
//import com.officialskosay.test.pageobject.StoreGroupPage;
//import com.officialskosay.test.pageobject.StoresPage;
	 
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
			UsersPage.Mnu_UsersAccounts(driver).click();
			UsersPage.tab_Users(driver).click();
			UsersPage.txt_AddUserName(driver).clear();
			UsersPage.txt_AddUserName(driver).sendKeys(name);
			UsersPage.txt_AddUserEmail(driver).clear();
			UsersPage.txt_AddUserEmail(driver).sendKeys(email);
			UsersPage.txt_AddUserPassword(driver).clear();
			UsersPage.txt_AddUserPassword(driver).sendKeys(password);
			UsersPage.cbo_AddUserAccountType(driver).click();
			UsersPage.cbo_AddUserAccountType(driver).sendKeys(type);
			UsersPage.btn_CreateNewAccount(driver).click();
		}
		
	/*	public void registerUserWithGroup(String name, String email, String password, String type, String group){
			UsersPage.txt_AddUserName(driver).clear();
			UsersPage.txt_AddUserName(driver).sendKeys(name);
			UsersPage.txt_AddUserEmail(driver).clear();
			UsersPage.txt_AddUserEmail(driver).sendKeys(email);
			UsersPage.txt_AddUserPassword(driver).clear();
			UsersPage.txt_AddUserPassword(driver).sendKeys(password);
			UsersPage.cbo_AddUserAccountType(driver).click();
			UsersPage.cbo_AddUserAccountType(driver).sendKeys(type);
			UsersPage.cbo_AddUserGroup(driver).click();
			UsersPage.cbo_AddUserGroup(driver).sendKeys(group);
			UsersPage.btn_CreateNewAccount(driver).click();
		}
		
		public void createStoreGroup(String storename){
			StoreGroupPage.Mnu_Stores(driver).click();
			StoreGroupPage.tab_StoreGroup(driver).click();
			StoreGroupPage.txt_GroupName(driver).clear();
			StoreGroupPage.txt_GroupName(driver).sendKeys(storename);
			StoreGroupPage.btn_Create(driver).click();
		}
		
		public void deleteStore(){
			StoresPage.Mnu_Stores(driver).click();
			StoresPage.tab_Stores(driver).click();
			StoresPage.btn_DeleteStore(driver).click();
		}

		   
		@AfterTest
		public void quit(){
			driver.quit();
		}
	
		//@Test(priority = 0)
		//User creates a user account for administrator
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
		
		//@Test(priority = 1)
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
		
		//@Test(priority = 2)
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
		
		//@Test(priority = 3)
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
		
		//@Test(priority = 4)
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
		
		//@Test(priority = 5)
		//Administrator tried to create user with no input in the name field
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
		
		//@Test(priority = 6)
		//Administrator tried to create user with no input in the email field
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
		
		//@Test(priority = 7)
		//Administrator tried create user with no input in the password field
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
		
		@Test(priority = 8)
		//User tried to register a new Store Group that is already existing in the system
		public void testApplyCreateStoreGroup()throws Exception{
			createStoreGroup("App Test");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			if(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/label")).isDisplayed()){
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
			}else{
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
			}
		}
		
		//@Test(priority = 9)
		//User tried to delete an existing Store account
		public void testApplydeleteStore()throws Exception{
			deleteStore();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		
		@Test(priority = 10)
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
				registerUser("Invalid", invalidEmails[i], "jdelacruz000", "Consumer");
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
		
		@Test(priority = 11)
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
		
		@Test(priority = 12)
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
		
		@Test(priority = 13)
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
		
		@Test(priority = 14)
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
		
		@Test(priority = 15)
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
		
		@Test(priority = 16)
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
		
		@Test(priority = 17)
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
		
		@Test(priority = 18)
		//User tried to create an account and fills-out the form with  more than 255 characters in the Email Field
		public void testApply128CharEmail()throws Exception{
			registerUser("Name", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@email.com",
					"password", "Consumer");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
			}
		driver.navigate().refresh();
		}
		
		@Test(priority = 19)
		//User tried to create an account and fills-out the form with with more than 255 characters in the Password Field
		public void testApply255CharPass()throws Exception{
			registerUser("Name", "255charpass@email.com",
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
		

		@Test(priority = 20)
		//User tried to create a new Manager Account with user group with correct details
		public void testApplyMngrAcctWUserGrp() throws Exception{
			registerUserWithGroup("Annie", "annie@gmail.com", "passwordniannie", "Manager", "Petron");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			if (driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
			}else{
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
			}
			driver.navigate().refresh();
		}
		
		@Test(priority = 21)
		//User tried to create a new District Manager Account with user group with correct details
		public void testAppyDistrictMngrWUserGrp() throws Exception{
			registerUserWithGroup("Buddy", "buddy@gmail.com","passwordnibuddy", "District Manager", "BosCafe");
			
			if(driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/label")).isDisplayed()){
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
			}else{
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
			}
			driver.navigate().refresh();
		}
		*/
		
}
