package com.crowdtogo.test.apply;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.miscellaneous.test.Miscellaneous;

public class MerchantApplication {
	public Miscellaneous misc1 = new Miscellaneous();
	
	public void initialize(){
		misc1.setURL("http://devapp.crowdtogo.com/merchant/step1");		
	}
	
	public void merchantApply(String businessName, String businessContact, String firstname, String lastname, String email, String password, String password2){
	    misc1.driver.findElement(By.name("businessName")).clear();
	    misc1.driver.findElement(By.name("businessName")).sendKeys(businessName);
	    misc1.driver.findElement(By.name("businessContact")).clear();
	    misc1.driver.findElement(By.name("businessContact")).sendKeys(businessContact);
	    misc1.driver.findElement(By.name("firstname")).clear();
	    misc1.driver.findElement(By.name("firstname")).sendKeys(firstname);
	    misc1.driver.findElement(By.name("lastname")).clear();
	    misc1.driver.findElement(By.name("lastname")).sendKeys(lastname);
	    misc1.driver.findElement(By.name("email")).clear();
	    misc1.driver.findElement(By.name("email")).sendKeys(email);
	    misc1.driver.findElement(By.id("password")).clear();
	    misc1.driver.findElement(By.id("password")).sendKeys(password);
	    misc1.driver.findElement(By.id("password2")).clear();
	    misc1.driver.findElement(By.id("password2")).sendKeys(password2);
	    misc1.driver.findElement(By.xpath("//input[@value='Next']")).click();
	}
	
	public void endTest(){
		misc1.endSession();
	}
	
	public String getResult(int scenarioType, String methodName){
		String result = null;
		switch (scenarioType){
		//Valid
		case 1:{
			if(misc1.driver.getTitle().equals("Arkansas Same Day Delivery")){
				result = methodName + " Passed!";
			}else{
				result = methodName + "Failed!";
			}
			break;
			}
		//Invalid
		case 0:{
			if(misc1.driver.getTitle().equals("Arkansas Local Delivery")){
				result = methodName + " Passed!";
			}else{
				result = methodName + "Failed!";
			}
			break;
			}
		}
		return result;
		//misc1.driver.quit();
	}
	@Test(priority = 0)
	public void testMerchantApplyValid() throws Exception{
		//User fills-out form with valid and complete details
		initialize();
		merchantApply("Solutions Resource", "(002)-123-4567", "Aileen", "Soriano", "aileen@gmail.com", "aileen000", "aileen000");
		System.out.println(getResult(1, Thread.currentThread().getStackTrace()[1].getMethodName()));
		misc1.driver.quit();
	}
	
	@Test(priority = 1)
	public void testNoInput(){
		//User clicks Next without input on any field
		initialize();
		misc1.driver.findElement(By.xpath("//input[@value='Next']")).click();
		System.out.println(getResult(0, Thread.currentThread().getStackTrace()[1].getMethodName()));
		misc1.driver.quit();
	}
	//@Test(priority = 2)
	
}
