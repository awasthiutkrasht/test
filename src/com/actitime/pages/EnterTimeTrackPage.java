package com.actitime.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.genericLib.BaseTest;

public class EnterTimeTrackPage {

	@FindBy(xpath="//div[@id='container_users']") private WebElement userTab;

	public EnterTimeTrackPage() {
		
		PageFactory.initElements(BaseTest.d, this);
	}
	
	public WebElement getUsersTab() {
		return userTab;	
	}
	public void clickUsersTab() {
		
		userTab.click();
	}
	
}
