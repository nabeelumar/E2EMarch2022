package com.andoroathodi.EndToEndProjectMarch2022;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
 
import resources.base;

public class LoginPageApp extends base {
	public static Logger log = LogManager.getLogger(LoginPageApp.class.getName());
	SoftAssert a = new SoftAssert();
	
	
	@BeforeTest
	public void setUP() throws IOException {

		driver = intializeDriver();
		log.info("Driver is initalized");
		log.debug("Fetching url and going to launch it");
		driver.get(prop.getProperty("url"));
		log.info("Url launched");
		

 
	}

	@Test(dataProvider = "getData")
	public void login(String uname, String pd) throws IOException {

		LandingPage lap = new LandingPage(driver);
		
		WebElement logo = lap.logoText();
		System.out.println(logo.getText() + " is the logo value");
		log.debug("Clicking on sign in button");
		lap.signIn().click();
		log.info("Sign in button clicked");

		LoginPage lop = new LoginPage(driver);
		lop.username().sendKeys(uname);
		lop.password().sendKeys(pd);
		log.debug("Clicking submit button");
		lop.submit().click();
		log.info("Submit button clicked");
		driver.navigate().back();
		driver.navigate().back();
		String txt =driver.findElement(By.xpath("//a[@title='Already a user? Sign in']")).getText();
		System.out.println("path is "+txt);
	//a.assertEquals(txt, "hello");
	
	}
	
	@Test
	public void validateGoogle() {
		driver.findElement(By.xpath("//input[@id='input']")).sendKeys("aheel");
		
	}
	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[2][2];
		data[0][0] = "alex@gmail";
		data[0][1] = "abc";
		data[1][0] = "vikay@gma";
		data[1][1] = "54";

		return data;
	}

	@AfterTest
	public void exit() {
a.assertAll();
System.out.println("Cahnges done as per git");
System.out.println("Made changes to develop branch");
	}

}
