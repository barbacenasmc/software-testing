package com.ehatidapi.test.login;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.*;

import com.miscellaneous.test.Miscellaneous;

public class WebLogin {
	public Miscellaneous misc1 = new Miscellaneous();
	
	//@BeforeTest
	public void initialize(){
		misc1.setURL("http://ehatidapi.solutionsresource.com/users/login");		
	}
	
	/*public static final int LENGTH=5; // the length of passwords we want to generate
	public static void passWordGen(String currentPass,char c){      
	    if(c<='~'){
	    	System.out.println(currentPass+c);
	        
	    	passWordGen(currentPass,(char)(c+1)); //go through every character at this position
	        
	        if(currentPass.length()<LENGTH-1){
	            passWordGen(currentPass+c,'!'); //start over by adding the current charterer to the current postion
	        	}
	    	}
	    }  */
	      
	public void inputLogin(String email, String password) throws Exception {
	misc1.driver.findElement(By.id("email")).clear();
    misc1.driver.findElement(By.id("email")).sendKeys(email);
    misc1.driver.findElement(By.id("password")).clear();
    misc1.driver.findElement(By.id("password")).sendKeys(password);
    misc1.driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public boolean checkDashboard(){
		try {
			misc1.driver.findElement(By.linkText("eHatid Dashboard Beta"));
		}catch (NoSuchElementException e) {
		   return false;
		}
		
		return true;
	}
	@Test (priority=0)
	public void testValidLogin() throws Exception{
		boolean proceed=true;
		
		while(proceed){		
			initialize();
			inputLogin("RHUAdmin1", "ehatid000");
				if(checkDashboard()){
					System.out.println("Login Success!");
					proceed = false;
				}else{
					System.out.println("Login Failure!");
				}
			misc1.driver.quit();
		}
		
	}
	/*@Test (priority=1)
	public void testMultipleLogin(){
		
	}*/
}
