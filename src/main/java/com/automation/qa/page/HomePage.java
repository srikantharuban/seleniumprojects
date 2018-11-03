package com.automation.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.qa.base.BassClass;

public class HomePage extends BassClass {

	@FindBy(xpath = "//img[@id='enterimg']")
	WebElement signin;

	public RegisterPage getSignIn() {
		signin.click();
		return new RegisterPage();
	}

	public HomePage() {
		PageFactory.initElements(webdriver, this);
	}

}
