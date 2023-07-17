package com.naveenAutomation.FrameworkDemo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.DemoProject.base.BaseClass;
import com.naveenautomation.DemoProject.pages.AccountLogin;
import com.naveenautomation.DemoProject.pages.MyAccount;
import com.naveenautomation.DemoProject.pages.MyWishList;
import com.naveenautomation.DemoProject.pages.YourStore;

import junit.framework.Assert;

public class MyWishListTest extends BaseClass {

	
	YourStore yourStore;
	AccountLogin accountLogin;
	MyAccount myAccount;
	MyWishList myWishList;
	
	@BeforeMethod
	public void setup() {
		initialisation();
		yourStore = new YourStore();

	}
	
	@Test
	public void clickOnMonitors() {
		
		yourStore.clickMyAccountBtn();
		accountLogin = new YourStore().clickLoginBtn();
		accountLogin.enterEmail("tony@gmail.com");
		accountLogin.enterPassword("Password2");
		myAccount=accountLogin.login();
		myWishList= myAccount.clickWishListBtn();
		myWishList.clickComponentsBtn();
		myWishList.clickMonitorsBtn();
		Assert.assertEquals(wd.getTitle(), "Monitors");
	}
	
}
