package Core;

import java.util.Dictionary;

import org.junit.internal.builders.JUnit4Builder;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.TestNG;

import com.aventstack.extentreports.gherkin.model.Feature;

import cucumber.api.Scenario;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.CucumberFeatureWrapperImpl;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.model.CucumberBackground;
import cucumber.runtime.model.CucumberFeature;
import cucumber.runtime.model.CucumberScenario;
import stepDefinitions.TestRunner;


public class WebDriverFactory {
	public static Dictionary<String, WebDriver> WebDriverDict = null;
	private static Object DictLock = new Object();
	private static Boolean pageTrackerInit = false;
	public static String browser = null;
	
	private String getFeatureFileNameFromScenarioId(Scenario scenario) {
	    String featureName = "Feature ";
	    String rawFeatureName = scenario.getId().split(";")[0].replace("-"," ");
	    featureName = featureName + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
System.out.println(featureName);
	    return featureName;
	}
public static String GetTestFixtureName()
{
	String fixtureName = CucumberFeature.class.getPackage().toString();
	//System.out.println(fixtureName);
	return fixtureName;
}
public static WebDriver InstantiateWebDriver()
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
		chrOptions.setBinary("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println(fixtureName);
	}
	//WebDriverDict.put(fixtureName, driver);	
	return driver;
}
public static WebDriver GetCurrentWebDriver()
{
//	if(WebDriverDict.get(GetTestFixtureName())==null)
//	{
		WebDriver driver = InstantiateWebDriver();
	//}
	return driver;
}
}
