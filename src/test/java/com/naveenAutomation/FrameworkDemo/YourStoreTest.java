package com.naveenAutomation.FrameworkDemo;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.naveenautomation.DemoProject.base.BaseClass;
import com.naveenautomation.DemoProject.pages.AccountLogin;
import com.naveenautomation.DemoProject.pages.YourStore;

public class YourStoreTest extends BaseClass {
	
	YourStore yourStore;
	AccountLogin accountLogin;
	
	
	@BeforeMethod
	public void setUP() {
		initialisation();
		yourStore = new YourStore();
	}
	
	@Test
	public void ValidateLogin() {
		yourStore.clickMyAccountBtn();
		accountLogin= yourStore.clickLoginBtn();
		Assert.assertEquals(wd.getTitle(),"Account Login");
	}

}
