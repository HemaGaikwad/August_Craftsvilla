package com.craftsvilla.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements AutoConst
{
	public static WebDriver driver = null;	
	public static WebDriverWait wait = null;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void openApp(String browser)
	{
		if(browser.equalsIgnoreCase("CHROME"))
		{
			System.setProperty(chrome_key, chrome_value);
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("FIREFOX"))
		{
			System.setProperty(gecko_key, gecko_value);
			driver = new FirefoxDriver();			
		}

		else 
		{
			Reporter.log("Invalid browser selection. Choose between chrome or firefox");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		driver.get("https://www.craftsvilla.com/");
		
	}
	
	@AfterMethod
	public void closeApp()
	{
		driver.quit();
	}

}
