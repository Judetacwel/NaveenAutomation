package com.naveenautomation.DemoProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import com.naveenautomation.DemoProject.base.BaseClass;

public class YourStore extends BaseClass {

	public YourStore() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(css = "ul.list-inline>li:nth-of-type(2) a")
	private WebElement myAccountBtn;

	@FindBy(css = "ul.dropdown-menu li:nth-of-type(2) a")
	private WebElement loginBtn;
	

	public YourStore clickMyAccountBtn() {

		myAccountBtn.click();
		return new YourStore();
	}

	public AccountLogin clickLoginBtn() {
		loginBtn.click();
		return new AccountLogin();
	}
}
