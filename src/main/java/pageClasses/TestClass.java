package pageClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Utilities.BaseClass;

public class TestClass extends BaseClass{

	public static WebDriver driver;
	@Test
	public void main() throws IOException
	{
		Properties pr = new Properties();
		pr=BaseClass.fromInputPropertiesFile();
		String Browser=pr.getProperty("testBrowser");
		System.out.println(Browser);
		
		//driver=HandleBrowser.launchBrowser();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.close();
	}
}
