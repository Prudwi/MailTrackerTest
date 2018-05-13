@CustomerAdminScenarios
Feature: Customer Administration Test Scenarios

  @AddNewCustomer
  Scenario: Add a new customer to a financial institution
  Given user is on customer administration page
  When user click on Add New Button
  Then validate user is on AddOrEditCustomer page
  When user input Jim Johnson in Name TextBox
  And user input a number in account number TextBox
  When user click on save Button
  Then validate success is displayed
  And new customer is displayed in Customer Administration grid
  @EditExistingCustomer
  Scenario: Edit an existing customer
  
  
  
   

  