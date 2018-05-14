package Core;

import java.util.Dictionary;

import org.junit.internal.builders.JUnit4Builder;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import cucumber.runtime.junit.JUnitReporter;

public class WebDriverFactory {
	public static Dictionary<String, WebDriver> WebDriverDict = null;
	private static Object DictLock = new Object();
	private static Boolean pageTrackerInit = false;
	public static String browser = null;
	
public void GetCurrentWebDriver()
{
	
	this.GetCurrentWebDriver();
}
public static String GetTestFixtureName()
{
	String fixtureName = junit.runner.BaseTestRunner.SUITE_METHODNAME.toString();
	
	return fixtureName;
}
public static void InstantiateWebDriver()
{
	WebDriver driver;
	String fixtureName = GetTestFixtureName();
	if( browser == "IE")
	{
		InternetExplorerOptions IeOptions = new InternetExplorerOptions();
		IeOptions.ignoreZoomSettings();		
		driver = new InternetExplorerDriver(IeOptions);
		driver.manage().window().maximize();
	}
	else 
	{
		ChromeOptions chrOptions = new ChromeOptions();
		chrOptions.addArguments("start-maximized");
		driver = new ChromeDriver(chrOptions);
	}
	WebDriverDict.put(fixtureName, driver);
}
}
