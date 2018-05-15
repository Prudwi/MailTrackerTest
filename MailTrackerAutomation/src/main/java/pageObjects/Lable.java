package pageObjects;

import org.openqa.selenium.WebElement;

import Core.BaseElement;

public class Lable extends BaseElement{

	public Lable(SelectBy byToUse, String strToFind)
	{
		SourceIden1 = byToUse;
		SourceStr = strToFind;
	}
	public void click()
	{
		WebElement ele = findElement();
		
		
	}
}
