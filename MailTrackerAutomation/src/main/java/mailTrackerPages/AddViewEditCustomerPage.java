package mailTrackerPages;

import Core.BaseElement;
import pageObjects.Button;
import pageObjects.Lable;
import pageObjects.TextBox;

public class AddViewEditCustomerPage {

	private Lable bankNameLabel = null ;
	private TextBox customerNameTextBox = null;
	private Lable customerCompanyLabel = null;
	private Lable lockBoxLabel = null;
	private TextBox accountNumberTextBox = null;
	private TextBox addressTextBox = null;
	private TextBox emailTextBox = null;
	private TextBox phoneNumberTextBox = null;
	private TextBox faxNumberTextBox = null;
	private Button cancelButton = null;
	
	public Lable BankNameLabel()
	{		 
			 return this.bankNameLabel = new Lable(BaseElement.SelectBy.Id, "Bank Name Locator");	
		
	}
	public TextBox CustomerNameTextBox()
	{
		return this.customerNameTextBox = new TextBox(BaseElement.SelectBy.Name, "Customer Name Text box Locator");
	}
			
		//Navigate
	
}
