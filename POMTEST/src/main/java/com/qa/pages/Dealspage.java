package com.qa.pages;

import org.openqa.selenium.support.PageFactory;
import com.qa.base.Testbase;

public class Dealspage extends Testbase {

	public Dealspage() {
		PageFactory.initElements(driver, this);
	}
}
