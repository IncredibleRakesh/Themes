package pageClasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Utilities.BaseClass;

	public class LogInPage extends BaseClass{
		
		public static String baseURL;
		public static WebDriver driver;
		
		//To enter Login Credentials
		@Test
		public void LogIn() throws IOException {
			
			Properties inputProp=BaseClass.fromInputPropertiesFile();
			Properties webelementsProp = BaseClass.invokeWebelementsPropertiesFile();
			
			driver = BaseClass.launchBrowser();
			baseURL=inputProp.getProperty("URL");
			driver.get(baseURL);
			//driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.name(webelementsProp.getProperty("userName"))).sendKeys(inputProp.getProperty("ussername"));
			driver.findElement(By.id(webelementsProp.getProperty("userNext"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.name(webelementsProp.getProperty("pass"))).sendKeys(inputProp.getProperty("password"));
			driver.findElement(By.id(webelementsProp.getProperty("passNext"))).click();
			try {
				Thread.sleep(25000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id(webelementsProp.getProperty("otpVerify"))).click();
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.id(webelementsProp.getProperty("nextButton"))).click();
			
			driver.close();
		}

	}