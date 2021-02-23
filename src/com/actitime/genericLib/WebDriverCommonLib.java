package com.actitime.genericLib;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.io.Files;

public class WebDriverCommonLib extends BaseTest {

	private static final int FILE = 0;
	private static final int X = 0;

	public String getPageTitle() {
		
		return d.getTitle();
	}
	public void verify(String expected, String actual, String value) {
		
		Assert.assertEquals(expected, actual);
		Reporter.log(value+"is Displayed", true);
	}
	public void selectOption(WebElement element, int index ) {
		
		Select sel = new Select(element);
		sel.selectByIndex(index);
		}
    public void selectOption(String value ,WebElement element) {
		
		Select sel = new Select(element);
		sel.selectByValue(value);
		}
    public void selectOption(WebElement element, String text ) {
	
	Select sel = new Select(element);
	sel.selectByVisibleText(text);
	}
    public void switchtoFrame(int index) {
    	
    	d.switchTo().frame(index);
    }
    public void switchtoFrame(String attribute) {
    	
    	d.switchTo().frame(attribute);
    }
    public void switchtoFrame(WebElement element) {
	
	d.switchTo().frame(element);
    }
    
    public void waitForPage(String title) {
    	
    	WebDriverWait wait = new WebDriverWait(d, 20);
    	wait.until(ExpectedConditions.titleContains(title));
    }
    public void mouseover(WebElement element) {
    	
    	Actions act = new Actions(d);
    	act.moveToElement(element).perform();
    }
 
    public void takePageScreenshot(String name) throws Throwable  {
    	
    	TakesScreenshot ts = (TakesScreenshot)d;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	File dest = new File("./screenshot/"+name+".png");
    	Files.copy(src, dest);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
}
