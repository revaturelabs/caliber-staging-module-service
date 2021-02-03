package com.revature.backend.testing.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@class='btn btn-primary logout-btn']")
	private WebElement logoutButton;

}
