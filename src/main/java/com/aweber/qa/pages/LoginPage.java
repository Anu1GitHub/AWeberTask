package com.aweber.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aweber.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR
	@FindBy(xpath = "//input[@id='usernameOrEmail']")
	WebElement usernameOrEmail;

	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	WebElement continueButton;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//button[contains(text(),'Log In')]")
	WebElement logInButton;

	// Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions
	public MyProfilePage login(String userEmail, String pass) {
		usernameOrEmail.sendKeys(userEmail);
		continueButton.click();
		password.sendKeys(pass);
		logInButton.click();
		return new MyProfilePage();
	}

}
