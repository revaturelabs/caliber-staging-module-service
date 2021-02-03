package com.revature.backend.endtoend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewPage {
	
	private WebDriver driver;
	
	public ViewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Add new item button
	@FindBy(xpath = "//button[contains(.,Add new item)]") 
	private WebElement addNewButton;
	
	// Update button
	@FindBy(xpath = "//button[contains(.,Update)]" )
	private WebElement updateButton;
	
	// Delete button
	@FindBy(xpath = "//button[contains(.,Delete)]" )
	private WebElement deleteButton;
	
	// Back to home page link
	@FindBy(xpath = "//*[@id='homeLink'")
	private WebElement homePageButton;
	
	
	//
}
