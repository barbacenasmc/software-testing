package com.janernest.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class checkTitle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://freightbit-test.appspot.com/";
        String expectedTitle = "ERNEST Logistics Corporation";
        String actualTitle = "";
        
        //launch browser
        driver.get(baseUrl);
        //get actual value of the title
        actualTitle = driver.getTitle();
        
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        
        //close Firefox
        driver.close();
        
        // exit the program explicitly
        System.exit(0);

	}

}
