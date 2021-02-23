package com.actitime.TimeTrack;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.genericLib.BaseTest;
import com.actitime.genericLib.Filelib;
import com.actitime.genericLib.WebDriverCommonLib;
import com.actitime.pages.LoginPage;

@Listeners(com.actitime.genericLib.MyListener.class)
public class ValidLoginTest extends BaseTest {
	
        @Test
	    public void loginToApp() throws Throwable {
		
		BaseTest bt = new BaseTest();
		bt.openBrowser();
		
		LoginPage lp = new LoginPage(d);
		Filelib flib = new Filelib();
		String un = flib.getPopKeyvalue(PROP_PATH, "username");
		String pwd = flib.getPopKeyvalue(PROP_PATH, "password");
	
		lp.login(un, pwd);
		
		WebDriverCommonLib wlib = new WebDriverCommonLib();
		wlib.waitForPage(flib.getPopKeyvalue(PROP_PATH, "homepage"));
        wlib.verify(wlib.getPageTitle(), flib.getPopKeyvalue(PROP_PATH, "homepage"), "Home Page");
		
		
		
	}
	

}
