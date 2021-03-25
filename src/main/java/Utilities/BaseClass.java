package Utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class BaseClass {

	//creating objects for each class
		public static Properties inputProp;
		public static Properties webelementsProp;
		public static  WebDriver driver;
	
	/****************************************Invoke Property File***********************/
	//To get the Data from InputData properties file
	public static Properties fromInputPropertiesFile() throws IOException
	{
		Properties properties= new Properties();
		FileInputStream readfile=new FileInputStream(System.getProperty("user.dir")+"\\Resources\\InputData.properties");
		properties.load(readfile);
		return properties;
	}
	//To get the Data from WebElements properties file
	public static Properties invokeWebelementsPropertiesFile() throws IOException
	{
		Properties property= new Properties();
		FileInputStream readfile=new FileInputStream(System.getProperty("user.dir")+"\\Resources\\WebElements.properties");
		property.load(readfile);
		return property;
	}
	
	/*****************************Invoke Browser**************************************/
	
	public static WebDriver launchBrowser() throws IOException {

		inputProp=fromInputPropertiesFile();

		String browser = inputProp.getProperty("testBrowser");

		if (browser.equalsIgnoreCase("firefox")) {

			FirefoxOptions ops = new FirefoxOptions();
			ops.addArguments("--disable-notifications");

			System.setProperty("webdriver.gecko.driver",
					inputProp.getProperty("driverLocationFirefox"));

			driver = new FirefoxDriver();
		}

		else if (browser.contains("chrome")) {

			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");

			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(ops); 
		/*	System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(browser.contains("headless"))
				options.addArguments("headless");
			driver = new ChromeDriver(options);*/
			
			//driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver",
					inputProp.getProperty("driverLocationEdge"));

			driver = new EdgeDriver();
		}

		else if (browser.equalsIgnoreCase("remote")) {

			String Node = inputProp.getProperty("nodeIP");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");

			driver = new RemoteWebDriver(new URL(Node), cap);
		}

		return driver;
	}

	public static void closeBrowser(WebDriver driver) 
	{
		if(driver!=null)
		driver.quit();
	}
	
	
}
