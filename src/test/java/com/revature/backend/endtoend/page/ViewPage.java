package com.revature.backend.endtoend.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ViewPage {

	private WebDriver driver;

	// Add new item button
	@FindBy(xpath = "//button[contains(.,'Add new item')]")
	private WebElement addNewButton;

	// inside "add new item" button
	@FindBy(xpath = "//*[@id='type']")
	private WebElement addNewButtonItemType;

	@FindBy(xpath = "//*[@id='content']")
	private WebElement addNewButtonItemText;
	
	@FindBy(xpath = "//*[@type='submit']")
	private WebElement addItemButtonInsideAddNewModal;

	// Update button
	@FindBy(xpath = "//button[contains(.,'Update')]")
	private WebElement updateButton;

	// Path same as addItem, if conflicts emerge look for more ways to differentiate
	@FindBy(xpath = "//*[@id='type']")
	private WebElement updateButtonItemType;
	//
	@FindBy(xpath = "//*[@id='content']")
	private WebElement updateButtonItemText;
	
	@FindBy(xpath = "//*[@type='submit'")
	private WebElement updateItemButtonInsideUpdateModal;

	// Delete button
	@FindBy(xpath = "//button[contains(.,'Delete')]")
	private WebElement deleteButton;

	// Back to home page link
	@FindBy(xpath = "//*[@id='homeLink']")
	private WebElement homePageButton;

	public ViewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickAddNewItem() {
		this.addNewButton.click();
	}
	
	public void addItemSelectType(String string) {
		Select drpType = new Select(driver.findElement(By.name("type")));
		drpType.selectByValue(string);
	}
	
	public void addItemTypeText(String text) {
		this.addNewButtonItemText.clear();
		this.addNewButtonItemText.sendKeys(text);
	}
	
	public void submitAdd() {
		this.addItemButtonInsideAddNewModal.click();
	}

	public void clickUpdateItem() {
		this.updateButton.click();
	}
	
	public void updateItemSelectType(String type) {
		Select drpType = new Select(driver.findElement(By.name("type")));
		drpType.selectByValue(type);
	}
	
	public void updateItemTypeText(String text) {
		this.addNewButtonItemText.clear();
		this.addNewButtonItemText.sendKeys(text);
	}
	
	public void submitUpdate() {
		this.updateItemButtonInsideUpdateModal.click();
	}

	public void clickDeleteItem() {
		this.deleteButton.click();
	}

	public void clickReturnToHomepage() {
		this.homePageButton.click();
	}

}
