package com.qa.testcases;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.pages.Contactpage;
import com.qa.pages.Dealspage;
import com.qa.pages.HomePage;
import com.qa.pages.Loginpage;

public class HomePageTest extends Testbase {

		Loginpage loginpage;
		HomePage homepage;
		Contactpage contactpage;
		Dealspage dealspage;

		public HomePageTest()
		{
			super();
		}


		@BeforeMethod()
		public void setup() throws InterruptedException {
			Testbase.initialization();
			Contactpage contactpage = new Contactpage();
			Dealspage dealspage = new Dealspage();
			Loginpage loginpage= new Loginpage();
			homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		}

		@Test(priority =1)
		public void VerifyHomepageTitleTest() {
			HomePage homepage = new HomePage();
			String homePageTitle = homepage.verifyHomePageTitle();
			AssertJUnit.assertEquals(homePageTitle, "Cogmento CRM");
		}

		@Test(priority=2)
		public void UserNameLabelTest() {
			HomePage homepage = new HomePage();
			boolean flag = homepage.UserNameLabel();
			AssertJUnit.assertTrue(flag);
		}

		@Test(priority=3)
		public void verifycontactlinkTest() throws InterruptedException {
			HomePage homepage = new HomePage();
			contactpage = homepage.clickoncontactlink();
		}

		@Test(priority=4)
		public void clickonDealsTest() {
			HomePage homepage = new HomePage();
			dealspage = homepage.clickonDeals();
		}

		@AfterMethod
		public void tearDown() {
			driver.quit();
		}
}

