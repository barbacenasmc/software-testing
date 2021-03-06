
package com.crowdtogo.test.apply;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import com.miscellaneous.test.Miscellaneous;
import com.crowdtogo.test.apply.CrowdieApplication;


public class CrowdieApplicationStep2 {
	public CrowdieApplication apply = new CrowdieApplication();
	public Miscellaneous step2 = new Miscellaneous();
	
	@BeforeTest
	public void initialize2() throws Exception{
		step2.setURL("http://devapp.crowdtogo.com/crowdie/step1");	
		apply.inputApply("jdelacruz@gmail.com", "jdelacruz000", "jdelacruz000","Juan", "Dela Cruz", "01/01/1990", "09261234567");
	}
	
	public void inputApplyStep2(String street, String apt, String city, String state, String how){
		step2.driver.findElement(By.name("street")).clear();
		step2.driver.findElement(By.name("street")).sendKeys(street);
		step2.driver.findElement(By.name("apt")).clear();
		step2.driver.findElement(By.name("apt")).sendKeys(apt);
		step2.driver.findElement(By.name("city")).clear();
		step2.driver.findElement(By.name("city")).sendKeys(city);
		Select chooseState = new Select(step2.driver.findElement(By.name("state")));
		chooseState.selectByVisibleText(state);
		Select chooseHow = new Select(step2.driver.findElement(By.name("how")));
		chooseHow.selectByVisibleText(how);
		step2.driver.findElement(By.xpath("//input[@value='Next']")).click();
	}
	@Test(priority=0)
	public void testStep2Valid(){
		inputApplyStep2("Sample", "123", "Sample City", "Alabama", "Friend");
	}
	
	@Test(priority=1)
	public void testStep2Valid2(){
		inputApplyStep2("Samples", "1234", "Sample Citys", "Alabama", "Friend");
	}
	

}
