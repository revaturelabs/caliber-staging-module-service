package com.revature.backend.endtoend.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class HomePage {
	public final String url = "http://localhost:4200/home";
	
	@FindBy(xpath = "//*[@class='btn btn-primary logout-btn']")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//button[text()='Create SWOT']")
	private List<WebElement> createSwotButtons;
	
	@FindBy(name = "type")
	private WebElement SwotTypeDropdown;
	
	@FindBy(id = "content")
	private WebElement contentField;
	
	@FindBy(xpath = "//button[text()='ADD ITEM']")
	private WebElement addItem;
	
	@FindBy(xpath = "//button[text()='SUBMIT']")
	private WebElement submitSwots;
	
	@FindBy(xpath = "//button[text()='View SWOTs']")
	private List<WebElement> viewSwots;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickCreateSwotForAssociate(int rowId) {
		WebElement createButton = this.createSwotButtons.get(rowId);
		createButton.click();
	}
	
	public void selectSwotType(String type) {
		Select swotOption = new Select(SwotTypeDropdown);
		swotOption.selectByValue(type);
	}
	
	public void enterContentField(String content) {
		this.contentField.clear();
		this.contentField.sendKeys(content);
	}
	
	public void addSwotItem() {
		this.addItem.click();
	}
	
	public void submitSwotItems() {
		this.submitSwots.click();
	}
	
	public void clickViewSwots(int index) {
		this.viewSwots.get(index).click();
	}

	public WebElement getLogoutButton() {
		return logoutButton;
	}

	public List<WebElement> getCreateSwotButtons() {
		return createSwotButtons;
	}

	public WebElement getSwotTypeDropdown() {
		return SwotTypeDropdown;
	}

	public WebElement getContentField() {
		return contentField;
	}

	public WebElement getAddItem() {
		return addItem;
	}

	public WebElement getSubmitSwots() {
		return submitSwots;
	}

	public List<WebElement> getViewSwots() {
		return viewSwots;
	}
	
}
