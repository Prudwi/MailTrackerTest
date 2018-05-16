package Core;

import java.util.Dictionary;

import org.junit.internal.builders.JUnit4Builder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class WebDriverFactory {
	public static Dictionary<String, WebDriver> WebDriverDict = null;
	private static Object DictLock = new Object();
	private static Boolean pageTrackerInit = false;
	public static String browser = null;

	public static String GetTestFixtureName() {
		String fixtureName = null;
		// System.out.println(fixtureName);
		return fixtureName;
	}

	public static WebDriver InstantiateWebDriver() {
		WebDriver driver;
		String fixtureName = GetTestFixtureName();
		if (browser == "IE") {
			InternetExplorerOptions IeOptions = new InternetExplorerOptions();
			IeOptions.ignoreZoomSettings();
			driver = new InternetExplorerDriver(IeOptions);
			driver.manage().window().maximize();
		} else {
			ChromeOptions chrOptions = new ChromeOptions();
			chrOptions.addArguments("start-maximized");
			chrOptions.setBinary("chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println(fixtureName);
		}
		// WebDriverDict.put(fixtureName, driver);
		return driver;
	}

	public static WebDriver GetCurrentWebDriver() {
		// if(WebDriverDict.get(GetTestFixtureName())==null)
		// {
		WebDriver driver = InstantiateWebDriver();
		// }
		return driver;
	}
}
