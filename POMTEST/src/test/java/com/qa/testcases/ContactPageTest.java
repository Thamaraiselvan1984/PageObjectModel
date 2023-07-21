package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.Testbase;
import com.qa.pages.Contactpage;
import com.qa.pages.Dealspage;
import com.qa.pages.HomePage;
import com.qa.pages.Loginpage;

public class ContactPageTest extends Testbase {

	Loginpage loginpage;
	HomePage homepage;
	Contactpage contactpage;
	Dealspage dealspage;

	public ContactPageTest() {
		super();
	}

	@BeforeMethod
	public void setup()  {
		Testbase.initialization();
		Loginpage loginpage= new Loginpage();
		HomePage homepage = new HomePage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactpage = homepage.clickoncontactlink();
	}

	@Test (priority =1)
	public void contactPagelabelTest()  {
		Contactpage contactpage = new Contactpage();
		Assert.assertTrue(contactpage.contactPagelabel(),"Contacts lable is missing on the page");
	}

	@Test (priority =2)
	public void createNewContact() {
		Contactpage contactpage = new Contactpage();
		contactpage.createNewContact();
	}


	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
