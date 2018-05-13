package Core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public  class BaseElement {
	WebDriver driver = null; //This will be replaced 
	//Find element
	public enum SelectBy { ClassName, CssSelector, Id, LinkText, Name, PartialLinkText, TagName, XPath};
	public SelectBy SourceIden1;
	public String SourceStr;
	
	public WebElement findElement()
	{
		WebElement element = null;
		if(SourceIden1.toString() == "id")
		{
			element = driver.findElement(By.id(SourceStr));
		}
		
		return element;
	}

}
