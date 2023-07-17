package com.naveenautomation.DemoProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.DemoProject.base.BaseClass;

public class MyAccount extends BaseClass{

	public MyAccount() {
		PageFactory.initElements(wd, this);
	}
	
	@FindBy(css = "#content>h2:first-of-type")
	WebElement myAccountText;
	
	@FindBy(css = "ul.list-inline>li:nth-of-type(3)")
	WebElement wishListBtn;

	public String getMyAccountText() {
		return myAccountText.getText();
	}

	public MyWishList clickWishListBtn() {
		wishListBtn.click();
		return new MyWishList();
	}

}
