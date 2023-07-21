package com.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.Contactpage;
import com.qa.pages.CreateNewContactPage;
import com.qa.pages.Dealspage;
import com.qa.pages.HomePage;
import com.qa.pages.Loginpage;

public class CreateNewContactPageTest extends Testbase {


	Loginpage loginpage;
	HomePage homepage;
	Contactpage contactpage;
	CreateNewContactPage newcontactpage;
	Dealspage dealspage;

	public CreateNewContactPageTest() {
		super();
	}

	@BeforeMethod
	public void setup()  {
		Testbase.initialization();
		Loginpage loginpage= new Loginpage();
		HomePage homepage = new HomePage();
		CreateNewContactPage newcontactpage = new CreateNewContactPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactpage = homepage.clickoncontactlink();
		newcontactpage = contactpage.createNewContact();
	}

	@Test
	public void createNewContact() {
		CreateNewContactPage newcontactpage = new CreateNewContactPage();
		newcontactpage.createNewContact("Thamarai", "Mani" , "selvan", "cts");
	}

	@DataProvider
	public void getTestData() {

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
