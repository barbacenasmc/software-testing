package com.miscellaneous.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class Miscellaneous {
	public WebDriver driver;
	public String browser;
	public String baseURL;
	
	
	public void setURL(String baseURL){
		this.baseURL = baseURL;
		driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
        driver.quit();
		}
		
}

