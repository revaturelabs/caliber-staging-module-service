package com.revature.backend.endtoend.gluecode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class RevatureDriverUtility {
	public static WebDriver driver;
	public static final String url = "http://localhost:4200/login";
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@After
	public void tearDown() {
		if(driver != null) driver.quit();
	}
	
	
			
}
