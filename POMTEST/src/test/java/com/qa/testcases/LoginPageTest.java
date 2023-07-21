package com.qa.testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.HomePage;
import com.qa.pages.Loginpage;

public class LoginPageTest extends Testbase {

	Loginpage loginpage;
	HomePage homepage;

	public LoginPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
	Testbase.initialization();
	Loginpage loginpage= new Loginpage();
	}

	@Test(priority =1)
	public void loginpageTitleTest() {
		Loginpage loginpage= new Loginpage();
		String title = loginpage.ValidateLoginPageTitle();
		AssertJUnit.assertEquals(title, "Cogmento CRM");
	}

	@Test(priority =2)
	public void crmimageLogoTest() {
		Loginpage loginpage= new Loginpage();
		boolean flag = loginpage.validatefreeCrmImage();
		AssertJUnit.assertTrue(flag);
	}

	@Test(priority = 3)
	public void LoginTest()
	{
		Loginpage loginpage= new Loginpage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void teadDown() {
		driver.quit();
	}
}
