package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Testbase;

public class Contactpage extends Testbase {

	@FindBy(xpath = "//span[@class='selectable ']")
	WebElement contactlable;

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button")
	WebElement create;

	public Contactpage() {
		PageFactory.initElements(driver, this);
	}

	public boolean contactPagelabel() {
		Actions action = new Actions(driver);
		action.moveToElement(contactlable).build().perform();
		return contactlable.isDisplayed();
	}

	public CreateNewContactPage createNewContact() {
		Actions action1 = new Actions(driver);
		action1.moveToElement(create).build().perform();
		create.click();
		return new CreateNewContactPage();
	}
}
