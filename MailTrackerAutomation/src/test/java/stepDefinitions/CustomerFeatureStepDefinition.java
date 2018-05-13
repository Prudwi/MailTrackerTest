package stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature")
public class CustomerFeatureStepDefinition {
	@Given("^user is on customer administration page$")
	public void user_is_on_customer_administration_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user click on Add New Button$")
	public void user_click_on_Add_New_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^validate user is on AddOrEditCustomer page$")
	public void validate_user_is_on_AddOrEditCustomer_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user input Jim Johnson in Name TextBox$")
	public void user_input_Jim_Johnson_in_Name_TextBox() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user input a number in account number TextBox$")
	public void user_input_a_number_in_account_number_TextBox() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user click on save Button$")
	public void user_click_on_save_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^validate success is displayed$")
	public void validate_success_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^new customer is displayed in Customer Administration grid$")
	public void new_customer_is_displayed_in_Customer_Administration_grid() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
}
