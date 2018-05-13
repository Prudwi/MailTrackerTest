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
	
	public WebElement findElement(String srcstring, String findElementType)
	{
		WebElement element = null;
		if(findElementType == "id")
		{
			element = driver.findElement(By.id(srcstring));
		}
		
		return element;
	}

}
