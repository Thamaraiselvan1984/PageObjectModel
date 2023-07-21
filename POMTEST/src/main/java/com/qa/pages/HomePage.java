package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.Testbase;

public class HomePage extends Testbase
{

	@FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[2]/span[1]")
	WebElement usernamelabel;

	@FindBy(xpath = "//*[@id=\"main-nav\"]/div[3]/a/span")
	WebElement contacts;

	@FindBy(xpath = "//*[@id=\"main-nav\"]/div[5]/a")
	WebElement deals;


	//Initializing the Page Object

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}

	public boolean UserNameLabel()
	{
		return usernamelabel.isDisplayed();
	}

	public Contactpage clickoncontactlink()   {
		Actions action2 = new Actions(driver);
		action2.moveToElement(contacts).build().perform();
		contacts.click();
		return new Contactpage();
	}	
		
	public Dealspage clickonDeals() {
		deals.click();
		return new Dealspage();
	}
	

}
