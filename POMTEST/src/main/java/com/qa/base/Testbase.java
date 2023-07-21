package com.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.qa.util.TestUtilclass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {

	public static WebDriver driver;
	public static Properties prop;

	public Testbase()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
		} catch(NullPointerException e) {
			e.printStackTrace();
		}catch(IOException e) {
				e.printStackTrace();
	}
	}

	public static void initialization()  {
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().pageLoadTimeout(TestUtilclass.page_load_Timeout, TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(TestUtilclass.Implicit_Wait, TimeUnit.SECONDS);
	 driver.get(prop.getProperty("url"));
	}
}