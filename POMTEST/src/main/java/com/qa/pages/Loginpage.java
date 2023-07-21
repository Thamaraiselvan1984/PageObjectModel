package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class Loginpage extends Testbase{

	//Page Factory

	@FindBy(xpath= "//span[normalize-space()='Log In']")
	WebElement login;

	@FindBy(name="email")
	WebElement email;

	@FindBy(name="password")
	WebElement password;

	@FindBy(xpath="//*[@id=\"ui\"]/div/div/form/div/div[3]")
	WebElement loginbtn;

	@FindBy(xpath="/html/body/div/main/section[1]/a/span[2]")
	WebElement  signin;

	@FindBy(className="brand-name")
	WebElement crmlogo;


	public Loginpage()
	{
		  PageFactory.initElements(driver, this);
	}

	//Actions
	public String ValidateLoginPageTitle() {
		login.click();
		return driver.getTitle();
	}

	public boolean validatefreeCrmImage()
	{
		return crmlogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		login.click();
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();

		return new HomePage();

	}
}

