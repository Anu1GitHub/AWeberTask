package com.aweber.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aweber.qa.base.TestBase;
import com.aweber.qa.pages.LoginPage;
import com.aweber.qa.pages.MyProfilePage;
import com.aweber.qa.util.TestUtil;

public class MyProfilePageTest extends TestBase {
	LoginPage loginPage;
	MyProfilePage myProfilePage;
	TestUtil testUtil;

	String addUrlSheetName = "AddURL";
	String savaProfileSheetName = "SaveProfileDetails";

	Logger log = Logger.getLogger(MyProfilePageTest.class);

	public MyProfilePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		log.info("Launching Application");
		loginPage = new LoginPage();
		myProfilePage = loginPage.login(prop.getProperty("usernameOrEmail"), prop.getProperty("password"));
		log.info("Entering into MyProfile Page");
	}

	@Test(priority = 1)
	public void myProfilePhotoTest() {
		Boolean flag = myProfilePage.validateMyProfilePhoto();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void validateProfileUserName() {
		String profileUserName = myProfilePage.validateProfileUserName();
		Assert.assertEquals(profileUserName, "aweberchallenge");
	}

	@Test(priority = 3)
	public void validateProfileHeaderLabel() {
		String profileHeaderLabel = myProfilePage.validateProfileHeaderLabel();
		Assert.assertEquals(profileHeaderLabel, "Profile");
	}

	@Test(priority = 4)
	public void validateDisplayNameLabel() {
		String displayNameLabel = myProfilePage.validateDisplayNameLabel();
		Assert.assertEquals(displayNameLabel, "Public display name");
	}

	@Test(priority = 5)
	public void validatePublicDisplayName() {
		Boolean flag = myProfilePage.validatePublicDisplayName();
		Assert.assertTrue(flag);

	}

	@DataProvider
	public Object[][] getSaveProfileData() {
		Object data[][] = TestUtil.getTestData(savaProfileSheetName);
		return data;
	}

	@Test(priority = 6, dataProvider = "getSaveProfileData")
	public void saveProfileDetailsTest(String firstName, String lastName, String aboutMe) {
		myProfilePage.saveProfileDetails(firstName, lastName, aboutMe);
	}

	@DataProvider
	public Object[][] getAddUrlData() {
		Object data[][] = TestUtil.getTestData(addUrlSheetName);
		return data;
	}

	@Test(priority = 7, dataProvider = "getAddUrlData")
	public void addUrlButtonTest(String urlTextfield, String descriptionTextfield) {
		myProfilePage.createProfileLinks(urlTextfield, descriptionTextfield);
	}

	@Test(priority = 8)
	public void logOutTest() {
		myProfilePage.logOut();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
