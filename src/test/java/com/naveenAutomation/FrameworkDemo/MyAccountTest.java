package com.naveenAutomation.FrameworkDemo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.DemoProject.base.BaseClass;
import com.naveenautomation.DemoProject.pages.AccountLogin;
import com.naveenautomation.DemoProject.pages.MyAccount;
import com.naveenautomation.DemoProject.pages.YourStore;

public class MyAccountTest extends BaseClass{

	
	YourStore yourStore;
	AccountLogin accountLogin;
	MyAccount myAccount;
	
	
	@BeforeMethod
	public void setUP() {
		initialisation();
		yourStore = new YourStore();
	}
	
	@Test
	public void validateLoginUsingValidCredentials() {

		yourStore.clickMyAccountBtn();
		accountLogin = new YourStore().clickLoginBtn();
		accountLogin.enterEmail("tony@gmail.com");
		accountLogin.enterPassword("Password2");
		accountLogin.login();
		Assert.assertEquals(wd.getTitle(), "My Account");

	}
	
	@Test
	public void validateMywishPageTitle() {
		yourStore.clickMyAccountBtn();
		accountLogin = new YourStore().clickLoginBtn();
		accountLogin.enterEmail("tony@gmail.com");
		accountLogin.enterPassword("Password2");
		myAccount=accountLogin.login();
		myAccount.clickWishListBtn();
		Assert.assertEquals(wd.getTitle(), "My  List");
		
	}
	
	
	
	
	
	
	
	
}
