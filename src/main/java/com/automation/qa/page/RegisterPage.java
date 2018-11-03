package com.automation.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.automation.qa.base.BassClass;
import com.automation.qa.testdata.GenderEnum;
import com.automation.qa.testdata.HobbiesEnum;
import com.automation.qa.util.TestUtil;

public class RegisterPage extends BassClass {

	@FindBy(how = How.XPATH, using = "//input[@placeholder='First Name']")
	WebElement txtfirstname;

	@FindBy(how = How.CSS, using = "input[placeholder='Last Name']")
	WebElement txtlastname;

	@FindBy(xpath = "//textarea[@ng-model='Adress']")
	WebElement txtaddress;

	@FindBy(xpath = "//input[@type='email']")
	WebElement txtemail;

	@FindBy(xpath = "//input[@type='tel']")
	WebElement txtphone;

	@FindBy(xpath = "//div[@id='msdd']")
	WebElement languageDropdown;

	public void setFirstName(String firstname) {
		txtfirstname.sendKeys(firstname);
	}

	public void setLastName(String lastname) {
		txtlastname.sendKeys(lastname);
	}

	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}

	public void setPhone(String phone) {
		txtphone.sendKeys(phone);
	}

	public void setGender(Enum<GenderEnum> gender) {
		webdriver.findElement(By.xpath("//label//input[@name='radiooptions' and @value='" + gender + "']")).click();
	}

	public void setHobbies(Enum<HobbiesEnum> Hobby) {
		webdriver.findElement(
				By.xpath("(//div[@class='form-group']//div[@class='col-md-4 col-xs-4 col-sm-4'])[6]//input[@value='"
						+ Hobby + "']"));
	}

	public void setLanguage(String language[]) {
		TestUtil.scrollDown(languageDropdown);
		languageDropdown.click();
		for (int count = 0; language.length > count; count++) {
			WebElement selectedlanguage = webdriver
					.findElement(By.xpath("//multi-select//div[@id='msdd']//following-sibling::div//ul//li//a[text()='"
							+ language[count] + "']"));
			selectedlanguage.click();
		}
	}

	public RegisterPage() {
		PageFactory.initElements(webdriver, this);
	}
}
