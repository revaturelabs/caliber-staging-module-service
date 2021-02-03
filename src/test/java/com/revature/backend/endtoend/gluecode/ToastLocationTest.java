package com.revature.backend.endtoend.gluecode;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.revature.backend.endtoend.page.HomePage;
import com.revature.backend.endtoend.page.LoginPage;
import com.revature.backend.endtoend.page.ViewPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ToastLocationTest {
	public HomePage homePage;
	public LoginPage loginPage;
	public ViewPage viewPage;

	//Scenario 1: Creating and submitting new SWOT item
	@Given("a user is logged into the welcome page of Revature Staging Module")
	public void a_user_is_logged_into_the_welcome_page_of_revature_staging_module() {
		this.homePage = new HomePage(RevatureDriverUtility.driver);
		this.loginPage.setEmail("test@revature.com");
		this.loginPage.setPassword("password");
		this.loginPage.clickLogin();
		WebDriverWait wait = new WebDriverWait(RevatureDriverUtility.driver, 2);
		wait.until(ExpectedConditions.urlContains("home"));
		this.loginPage = new LoginPage(RevatureDriverUtility.driver);
		assertEquals(this.homePage.url, RevatureDriverUtility.driver.getCurrentUrl());
	}

	@When("a user clicks Create SWOT for associate {string}")
	public void a_user_clicks_create_swot_for_associate(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("clicks Select SWOT type")
	public void clicks_select_swot_type() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("selects their {string}")
	public void selects_their(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("types into Enter Item field {string}")
	public void types_into_enter_item_field(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("clicks submit")
	public void clicks_submit() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("a toast notification should appear in the lower left")
	public void a_toast_notification_should_appear_in_the_lower_left() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the toast should not obstruct any other text")
	public void the_toast_should_not_obstruct_any_other_text() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	//Scenario 2: Deleting a submitted SWOT item
	@Given("a user is logged in and viewing a SWOT page for associate id {string}")
	public void a_user_is_logged_in_and_viewing_a_swot_page_for_associate_id(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("a user clicks a SWOT delete button for {string}")
	public void a_user_clicks_a_swot_delete_button_for(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("a toast notification should appear in the lower left")
	public void a_toast_notification_should_appear_in_the_lower_left() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the toast should not obstruct any other text")
	public void the_toast_should_not_obstruct_any_other_text() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	//Scenario 3: Updating a submitted SWOT item
	@Given("a user is logged in and viewing a SWOT page for associate id {string}")
	public void a_user_is_logged_in_and_viewing_a_swot_page_for_associate_id(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("a user clicks a SWOT update button for {string}")
	public void a_user_clicks_a_swot_update_button_for(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("clicks enter item field with text {string}")
	public void clicks_enter_item_field_with_text(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("clears field of all data")
	public void clears_field_of_all_data() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("adds text {string}")
	public void adds_text(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@When("clicks Update SWOT")
	public void clicks_update_swot() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("a toast notification should appear in the lower left")
	public void a_toast_notification_should_appear_in_the_lower_left() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the toast should not obstruct any other text")
	public void the_toast_should_not_obstruct_any_other_text() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
