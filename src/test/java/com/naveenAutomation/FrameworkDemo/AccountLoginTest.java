package com.naveenAutomation.FrameworkDemo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.DemoProject.base.BaseClass;
import com.naveenautomation.DemoProject.pages.AccountLogin;
import com.naveenautomation.DemoProject.pages.YourStore;

public class AccountLoginTest extends BaseClass {

	YourStore yourStore;
	AccountLogin accountLogin;

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
	public void validateLoginUsingInvalidVredentials() {
		yourStore.clickMyAccountBtn();
		accountLogin = new YourStore().clickLoginBtn();
		accountLogin.enterEmail("munni@gmail.com");
		accountLogin.enterPassword("1234");
		accountLogin.login();

		Assert.assertEquals(wd.getTitle(), "Account Login");

	}
	@Test
	public void testfailure() {
		Assert.assertEquals("Jude", "JudEJUDE");
	}

}
