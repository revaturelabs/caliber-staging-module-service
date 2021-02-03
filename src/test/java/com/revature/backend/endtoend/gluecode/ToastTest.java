package com.revature.backend.endtoend.gluecode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.revature.backend.endtoend.page.HomePage;
import com.revature.backend.endtoend.page.LoginPage;
import com.revature.backend.endtoend.page.ViewPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ToastTest {
	public HomePage homePage;
	public LoginPage loginPage;
	public ViewPage viewPage;
	
	
	// Scenario 1
	@Given("User is at the login page")
	public void user_is_at_the_login_page() {
		this.loginPage = new LoginPage(DriverUtility.driver);
		assertEquals(DriverUtility.driver.getCurrentUrl(), "http://localhost:4200/login");
	}

	@When("user inputs their email <{string}>")
	public void user_inputs_their_email(String string) {
		loginPage.setEmail(string);
	}

	@When("user inputs their password <{string}>")
	public void user_inputs_their_password(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user clicks log in")
	public void user_clicks_log_in() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user clicks view swots")
	public void user_clicks_view_swots() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user clicks add new item")
	public void user_clicks_add_new_item() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user selects type opportunity")
	public void user_selects_type_opportunity() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user submits item name <{string}>")
	public void user_submits_item_name(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user clicks add item")
	public void user_clicks_add_item() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("user can click add new item again without clearing the message")
	public void user_can_click_add_new_item_again_without_clearing_the_message() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// Scenario 2
	@When("user clicks update for recently created item")
	public void user_clicks_update_for_recently_created_item() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user changes type to strength")
	public void user_changes_type_to_strength() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user clicks delete for the same item")
	public void user_clicks_delete_for_the_same_item() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the three messages should occupy separate locations on the screen")
	public void the_three_messages_should_occupy_separate_locations_on_the_screen() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	// Scenario 3
	@When("user clicks create swot")
	public void user_clicks_create_swot() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user selects type threat")
	public void user_selects_type_threat() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("user selects type weakness")
	public void user_selects_type_weakness() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("the user should have four toast messages")
	public void the_user_should_have_four_toast_messages() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
