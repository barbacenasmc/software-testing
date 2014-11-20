package com.ehatidapi.test.login;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
import org.testng.annotations.*;

public class testLogin {

	public String baseURL= "http://ehatidapi.solutionsresource.com/users/login";
	public String dashboardTitle ="ehatid API";
	public WebDriver driver;
	
	@BeforeTest
	public void setBaseURL(){
		driver = new FirefoxDriver();
		driver.get(baseURL);
	}
	
	
	public static final int LENGTH=5; // the length of passwords we want to generate
	public static String passWordGen(String currentPass,char c){      
	    if(c<='~'){
	    	System.out.println(currentPass+c);
	        passWordGen(currentPass,(char)(c+1)); //go through every character at this position
	        
	        if(currentPass.length()<LENGTH-1){
	            passWordGen(currentPass+c,'!'); //start over by adding the current charterer to the current postion
	        }
	    }  
	    
	    return currentPass+c;
	}
	public static void main(String[] args) {        
	        passWordGen("",'!'); // kick off the recursion with an empty string and the first character         
	}
/*	@Test
	public void testLogin(){
		
		
		 	driver.findElement(By.id("email")).clear();
	        driver.findElement(By.id("email")).sendKeys("RHUadmin1");
	        driver.findElement(By.id("password")).clear();
	        driver.findElement(By.id("password")).sendKeys("password");
	}*/
	
}
