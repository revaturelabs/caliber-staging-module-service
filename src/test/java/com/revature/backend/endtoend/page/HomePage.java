package com.revature.backend.endtoend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@class='btn btn-primary logout-btn']")
	private WebElement logoutButton;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	
}
