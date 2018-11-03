package com.automation.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automation.qa.base.BassClass;
import com.automation.qa.page.HomePage;
import com.automation.qa.page.RegisterPage;
import com.automation.qa.testdata.GenderEnum;
import com.automation.qa.testdata.HobbiesEnum;
import com.automation.qa.util.TestUtil;

public class DemoTest extends BassClass {

	RegisterPage registerpage;

	public DemoTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		try {
			initialization();

			registerpage = (new HomePage()).getSignIn();
			Thread.sleep(5000);
		} catch (Exception e) {

		}
	}

	@AfterMethod
	public void tearDown() {
		webdriver.quit();
	}

	@DataProvider
	public Object[][] getDemoTestData() {
		Object data[][] = TestUtil.getTestData("User");
		return data;
	}

	@Test(dataProvider = "getDemoTestData")
	public void validateRegisterForm(String firstname, String lastname, String email, String phone) {
		registerpage.setFirstName(firstname);
		registerpage.setLastName(lastname);
		registerpage.setEmail(email);
		registerpage.setPhone(phone);
		registerpage.setGender(GenderEnum.FeMale);
		registerpage.setHobbies(HobbiesEnum.Movies);
		registerpage.setLanguage(prop.getProperty("language").split(","));
	}

}
