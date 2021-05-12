package com.aweber.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aweber.qa.base.TestBase;

public class MyProfilePage extends TestBase {

	// Page Factory - OR

	@FindBy(xpath = "//h2[contains(text(),'aweberchallenge')]")
	WebElement profileUserName;

	@FindBy(xpath = "//div//span[text()='Profile']")
	WebElement profileHeaderLabel;

	@FindBy(xpath = "//label[contains(text(),'Public display name')]")
	WebElement displayNameLabel;

	@FindBy(xpath = "//input[@value='aweberchallenge']")
	WebElement publicDisplayName;

	@FindBy(xpath = "//button[contains(text(),'Log out')]")
	WebElement logOutButton;

	@FindBy(xpath = "//div[@class='animate__appear']//img[@class='gravatar']")
	WebElement profilePhoto;

	@FindBy(xpath = "//a[contains(@class,'sidebar__menu-link')]//span[text()='My Profile']")
	WebElement sidebarMyProfileLink;

	@FindBy(xpath = "//button[text()='Save profile details']")
	WebElement saveProfileDetailsButton;

	@FindBy(xpath = "//input[@id='first_name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lastName;

	@FindBy(xpath = "//textarea[@id='description']")
	WebElement aboutMe;

	@FindBy(xpath = "//span[contains(@class,'components-form-toggle')]//input[contains(@class,'components')]")
	WebElement hideProfile;

	@FindBy(xpath = "//button//span[text()='Add']")
	WebElement addButton;

	@FindBy(xpath = "//div//button[text()='Add URL']")
	WebElement addUrlButton;

	@FindBy(xpath = "//input[contains(@placeholder,'Enter a URL')]")
	WebElement urlTextfield;

	@FindBy(xpath = "//input[contains(@placeholder,'Enter a description')]")
	WebElement descriptionTextfield;

	@FindBy(xpath = "//button[text()='Add Site']")
	WebElement addSiteButton;

	// Initializing the Page Objects

	public MyProfilePage() {
		PageFactory.initElements(driver, this);

	}

	// Actions

	public String validateProfileUserName() {
		return profileUserName.getText();
	}

	public String validateProfileHeaderLabel() {
		return profileHeaderLabel.getText();
	}

	public boolean validateMyProfilePhoto() {
		return profilePhoto.isDisplayed();
	}

	public String validateDisplayNameLabel() {
		return displayNameLabel.getText();
	}

	public boolean validatePublicDisplayName() {
		return publicDisplayName.isDisplayed();
	}

	public void saveProfileDetails(String fName, String lName, String aboutMeText) {
		firstName.clear();
		firstName.sendKeys(fName);
		lastName.clear();
		lastName.sendKeys(lName);
		aboutMe.clear();
		aboutMe.sendKeys(aboutMeText);
		hideProfile.click();
		saveProfileDetailsButton.click();

	}

	public void createProfileLinks(String url, String description) {
		addButton.click();
		addUrlButton.click();
		urlTextfield.sendKeys(url);
		descriptionTextfield.sendKeys(description);
		addSiteButton.click();

	}

	public void logOut() {
		logOutButton.click();
	}
}
