package com.actitime.users;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.TimeTrack.ValidLoginTest;
import com.actitime.genericLib.BaseTest;
import com.actitime.genericLib.Filelib;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.UserListPage;

@Listeners(com.actitime.genericLib.MyListener.class)
public class CreateNewUserTest extends BaseTest {

	@Test
	public void createNewUser() throws Throwable {
		
		ValidLoginTest vl = new ValidLoginTest();
		vl.loginToApp();
		
		EnterTimeTrackPage et = new EnterTimeTrackPage();
		et.clickUsersTab();
		
		UserListPage ul = new UserListPage();
		ul.clicknewuserBtn();
		
		Thread.sleep(2000);
		Filelib flib = new Filelib();
		ul.createUser(flib.getCellData(EXCEL_PATH, 1, 0, "Sheet1"),
				      flib.getCellData(EXCEL_PATH, 1, 1, "Sheet1"),
			          flib.getCellData(EXCEL_PATH, 1, 2, "Sheet1"), 
                      flib.getCellData(EXCEL_PATH, 1, 3, "Sheet1"));
		
	}
}
