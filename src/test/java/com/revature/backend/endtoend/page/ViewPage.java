package com.revature.backend.endtoend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ViewPage {
	
	
	public ViewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
