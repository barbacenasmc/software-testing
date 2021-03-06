package com.crowdtogo.test.apply;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import com.miscellaneous.test.Miscellaneous;

public class CrowdieApplication {

	public Miscellaneous misc1 = new Miscellaneous();
	
	@BeforeTest
	public void initialize(){
		misc1.setURL("http://devapp.crowdtogo.com/crowdie/step1");		
	}
	public void inputApply(String email, String password, String password2, String firstname, String lastname, String birthdate, String contact){

	    misc1. driver.findElement(By.name("email")).clear();
	    misc1.driver.findElement(By.name("email")).sendKeys(email);
	    misc1.driver.findElement(By.id("password")).clear();
	    misc1.driver.findElement(By.id("password")).sendKeys(password);
	    misc1.driver.findElement(By.id("password2")).clear();
	    misc1.driver.findElement(By.id("password2")).sendKeys(password2);
	    misc1.driver.findElement(By.name("firstname")).clear();
	    misc1.driver.findElement(By.name("firstname")).sendKeys(firstname);
	    misc1.driver.findElement(By.name("lastname")).clear();
	    misc1.driver.findElement(By.name("lastname")).sendKeys(lastname);
	    misc1.driver.findElement(By.id("birthdate")).clear();
	    misc1.driver.findElement(By.id("birthdate")).sendKeys(birthdate);
	    misc1.driver.findElement(By.name("contact")).clear();
	    misc1.driver.findElement(By.name("contact")).sendKeys(contact);
	    misc1.driver.findElement(By.xpath("//input[@value='Next']")).click();
	   
	}
	
	public void endTest(){
		misc1.endSession();
	}
	
	@Test(priority = 0)
	public void testApply() throws Exception{
		//initialize();
		inputApply("jdelacruz@gmail.com", "jdelacruz000", "jdelacruz000","Juan", "Dela Cruz", "01/01/1990", "09261234567");
		if(misc1.driver.getTitle().equals("Well paid part time jobs")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " Failed!");
		}
		initialize();
	}
	@Test(priority = 1)
	public void testApplyOtherValidEmail() throws Exception{
		String [] validEmails = {"niceandsimple@example.com", "very.common@example.com", "a.little.lengthy.but.fine@dept.example.com", 
				"disposable.style.email.with+symbol@example.com", "other.email-with-dash@example.com", "user@localserver.com", "another_acceptable_example@server.com"};
		
		for(int i=0;i<validEmails.length;i++){
			//initialize();
			inputApply(validEmails[i], "jdelacruz000", "jdelacruz000","Juan", "Dela Cruz", "01/01/1990", "09261234567");
			if(misc1.driver.getTitle().equals("Well paid part time jobs")){
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ ":"+ validEmails[i]+ " Passed!");
			}else{
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() +":"+ validEmails[i] + " Failed!");
			}
			initialize();
		}	
	}
	@Test(priority = 2)
	public void testApplyInvalidEmail() throws Exception{
		String [] invalidEmails = {"Abc.example.com", "A@b@c@example.com","a\"b(c)d,e:f;g<h>i[j\\k]l@example.com", "just\"not\"right@example.com",
				"this is\"not\\allowed@example.com", "this\\ still\\\"not\\allowed@example.com","john..doe@example.com", "john.doe@example..com"};
		
		for(int i=0;i<invalidEmails.length;i++){
			//initialize();
			inputApply(invalidEmails[i], "jdelacruz000", "jdelacruz000","Juan", "Dela Cruz", "01/01/1990", "09261234567");
			if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ ":" + invalidEmails[i]+ " Passed!");
			}else{
				System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ ":" + invalidEmails[i] + " Failed!");
			}
			initialize();
		}	
	}
	@Test(priority = 3)
	public void testApplyExistingEmail() throws Exception{
		//initialize();
		inputApply("crowdtogo@gmail.com", "jdelacruz000", "jdelacruz000","Juan", "Dela Cruz", "01/01/1990", "09261234567");
		if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	@Test(priority = 4)
	public void testApplyNoEmail() throws Exception{
		//initialize();
		inputApply("", "jdelacruz000", "jdelacruz000","Juan", "Dela Cruz", "01/01/1990", "09261234567");
		if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	@Test(priority = 5)
	public void testApply100EmailChar() throws Exception{
		//initialize();
		inputApply("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@gmail.com", 
				"jdelacruz000", "jdelacruz000","Juan", "Dela Cruz", "01/01/1990", "09261234567");
		if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	@Test(priority = 6)
	public void testApplyMismatchPass() throws Exception{
		//initialize();
		inputApply("sample@gmail.com", "jdelacruz000", "diffPass","Juan", "Dela Cruz", "01/01/1990", "09261234567");
		if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	@Test(priority = 7)
	public void testApplyLess5Pass() throws Exception{
		//initialize();
		inputApply("sample@gmail.com", "abc", "abc","Juan", "Dela Cruz", "01/01/1990", "09261234567");
		if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	@Test(priority = 8)
	public void testApplyNoPass() throws Exception{
		//initialize();
		inputApply("sample@gmail.com", "", "jdelacruz000","Juan", "Dela Cruz", "01/01/1990", "09261234567");
		if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	@Test(priority = 9)
	public void testApplyNoConfirmPass() throws Exception{
		//initialize();
		inputApply("sample@gmail.com", "jdelacruz000", "","Juan", "Dela Cruz", "01/01/1990", "09261234567");
		if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	@Test(priority = 10)
	public void testApplyNoPassConfirmPass() throws Exception{
		//User did not enter values on password and confirm password field
		//initialize();
		inputApply("sample@gmail.com", "", "","Juan", "Dela Cruz", "01/01/1990", "09261234567");
		if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	
	@Test(priority = 11)
	public void testApply2Fname() throws Exception{
		//User enters two names on first name field
		//initialize();
		inputApply("sample@gmail.com", "jdelacruz000", "jdelacruz000","Juan Juan", "Dela Cruz", "01/01/1990", "09261234567");
		if(misc1.driver.getTitle().equals("Well paid part time jobs")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	
	@Test(priority = 12)
	public void testApplyFnameWithNum() throws Exception{
		//User enters a name with numbers on first name field
		//initialize();
		inputApply("sample@gmail.com", "jdelacruz000", "jdelacruz000","Juan2", "Dela Cruz", "01/01/1990", "09261234567");
		if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	
	@Test(priority = 13)
	public void testApplyFnameWithSpecial() throws Exception{
		//User enters a name with special characters on first name field
		//initialize();
		inputApply("sample@gmail.com", "jdelacruz000", "jdelacruz000","Juan~!@#$%^&*", "Dela Cruz", "01/01/1990", "09261234567");
		if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	@Test(priority = 14)
	public void testApplyNoFname() throws Exception{
		//User did not enter a value on the first name field
		//initialize();
		inputApply("sample@gmail.com", "jdelacruz000", "jdelacruz000","", "Dela Cruz", "01/01/1990", "09261234567");
		if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	
	@Test(priority = 15)
	public void testApply2Lname() throws Exception{
		//User enters two names on last name field
		//initialize();
		inputApply("sample@gmail.com", "jdelacruz000", "jdelacruz000","Juan", "Dela Cruz", "01/01/1990", "09261234567");
		if(misc1.driver.getTitle().equals("Well paid part time jobs")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	
	@Test(priority = 16)
	public void testApply100LnameChar() throws Exception{
		//User enters last name that is more than 100 characters
		//initialize();
		misc1.driver.findElement(By.name("lastname")).clear();
		misc1.driver.findElement(By.name("lastname")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		String lastname = misc1.driver.findElement(By.name("lastname")).getAttribute("value");
		    
		if(lastname.length()==100){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	
	@Test(priority = 17)
	public void testApplyLnameWithNum() throws Exception{
		//User enters a name with special characters on last name field
		//initialize();
		inputApply("sample@gmail.com", "jdelacruz000", "jdelacruz000","Juan", "Dela Cruz1234", "01/01/1990", "09261234567");
		if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	
	@Test(priority = 18)
	public void testApplyLnameWithSpecial() throws Exception{
		//User enters a name with special characters on last name field
		//initialize();
		inputApply("sample@gmail.com", "jdelacruz000", "jdelacruz000","Juan", "Dela Cruz!@#$%^&*(", "01/01/1990", "09261234567");
		if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	
	@Test(priority = 19)
	public void testApplyNoLname() throws Exception{
		//User did not enter a value on the last name field
		//initialize();
		inputApply("sample@gmail.com", "jdelacruz000", "jdelacruz000","Juan", "", "01/01/1990", "09261234567");
		if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	
	@Test(priority = 20)
	public void testApplyBirthdayAhead() throws Exception{
		//User selects a birthday that is ahead of the current date
		//initialize();
		inputApply("sample@gmail.com", "jdelacruz000", "jdelacruz000","Juan", "", "01/01/2050", "09261234567");
		if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	
	@Test(priority = 21)
	public void testApplyAlphContact() throws Exception{
		//User enters alphabetic characters on contact field
		//initialize();
		inputApply("sample@gmail.com", "jdelacruz000", "jdelacruz000","Juan", "", "01/01/1990", "abcdefghijk");
		if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	
	@Test(priority = 22)
	public void testApplyContactWithDashes() throws Exception{
		//User enters contact number with dashes
		//initialize();
		inputApply("sample@gmail.com", "jdelacruz000", "jdelacruz000","Juan", "", "01/01/1990", "0926-123-4567");
		if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	
	@Test(priority = 21)
	public void testApplyContact25More() throws Exception{
		//User enters contact number more than 25 digits
		//initialize();
		misc1.driver.findElement(By.name("contact")).clear();
	    misc1.driver.findElement(By.name("contact")).sendKeys("092612345671233333456123456221");
	    String contact = misc1.driver.findElement(By.name("contact")).getAttribute("value");
		if(contact.length()==25){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		initialize();
	}
	@Test(priority = 23)
	public void testApplyContactSpacesOnly() throws Exception{
		//User entered spaces on contact number field
		//initialize();
		inputApply("sample@gmail.com", "jdelacruz000", "jdelacruz000","Juan", "", "01/01/1990", "     ");
		if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+" Failed!");
		}
		initialize();
	}
	
	@Test(priority = 24)
	public void testApplyNoContact() throws Exception{
		//User did not enter a value on contact number field
		//initialize();
		inputApply("sample@gmail.com", "jdelacruz000", "jdelacruz000","Juan", "", "01/01/1990", "");
		if(misc1.driver.getTitle().equals("Part time jobs in Bentonville Ar")){
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Passed!");
		}else{
			System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ " Failed!");
		}
		misc1.driver.quit();
	}	
	

}
