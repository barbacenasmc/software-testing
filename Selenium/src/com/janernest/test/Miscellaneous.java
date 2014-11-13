package com.janernest.test;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class Miscellaneous {
	public WebDriver driver;
	public String browser;
	public String baseURL;
	
	
	public void setURL(String baseURL){
		this.baseURL = baseURL;
		driver = new FirefoxDriver();
		driver.get(baseURL);
	}
	
	/*public void setBrowser(String browser){
		this.browser = browser;
		if(browser=="Firefox"){
			driver = new FirefoxDriver();
		}else if(browser=="Chrome"){
			driver = new ChromeDriver();
		}else{
			System.out.println(browser+ "does not exist!");
		}
	}*/
	
	public void endSession(){
        driver.close();
        System.exit(0);
		}
		
}
