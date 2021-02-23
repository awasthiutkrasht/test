package com.actitime.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest implements IAutoCons {
	
	public static WebDriver d;

		public void openBrowser() throws Throwable 
	{
		Filelib flib = new Filelib ();
		String browser = flib.getPopKeyvalue(PROP_PATH, "browser");
		
		if(browser.equalsIgnoreCase("chrome")) 
		{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	    d=new ChromeDriver();

		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
		
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			d= new FirefoxDriver();
			
		}
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		d.manage().window().maximize();
	   String appUrl = flib.getPopKeyvalue(PROP_PATH, "url");
		d.get(appUrl);
		
		WebDriverCommonLib wlib = new WebDriverCommonLib();
		wlib.verify(wlib.getPageTitle(),flib.getPopKeyvalue(PROP_PATH, "loginPage"),"Login Page");
	}
		
  
	public void closeBrowser() 
	{
		
		d.quit();
		
	}
	
}
