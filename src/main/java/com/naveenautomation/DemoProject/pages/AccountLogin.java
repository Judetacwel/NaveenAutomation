package com.naveenautomation.DemoProject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.naveenautomation.DemoProject.base.BaseClass;

public class AccountLogin extends BaseClass {

	public AccountLogin() {
		PageFactory.initElements(wd, this);
	}

	@FindBy(id = "input-email")
	private WebElement emailInputField;

	@FindBy(id = "input-password")
	private WebElement passwordInputField;

	@FindBy(css = "input[value='Login']")
	private WebElement loginBtn;

	public void enterEmail(String email) {
		emailInputField.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordInputField.sendKeys(password);
	}
	
	public MyAccount login() {
		loginBtn.click();
		return new MyAccount();
		
	}

}
