package pageObjects;

import Core.BaseElement;
import Core.BaseElement.SelectBy;

public class TextBox extends BaseElement{
	public TextBox(SelectBy byToUse, String strToFind)
	{
		SourceIden1 = byToUse;
		SourceStr = strToFind;
	}

}
