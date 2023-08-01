package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.Testbase;

public class CreateNewContactPage extends Testbase {

	@FindBy(name = "first_name")
	WebElement First_Name;

	@FindBy(name = "last_name")
	WebElement Last_Name;

	@FindBy(name = "middle_name")
	WebElement Middle_Name;

	@FindBy(xpath = "//*[@id=\"main-content\"]/div/div[2]/form/div[2]/div[2]/div/div/input")
	WebElement Company;

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
	WebElement saveBtn;

	public CreateNewContactPage(){
		PageFactory.initElements(driver, this);
	}

	public void createNewContact(String first_name, String last_name, String middle_name, String company)
	{
		First_Name.sendKeys(first_name);
		Last_Name.sendKeys(last_name);
		Middle_Name.sendKeys(middle_name);
		Company.sendKeys(company);
		saveBtn.click();
	}
}
