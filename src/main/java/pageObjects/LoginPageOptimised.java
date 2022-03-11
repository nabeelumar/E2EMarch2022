package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageOptimised {
	WebDriver driver;

	public LoginPageOptimised(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "#login1")
	WebElement uname;

	@FindBy(xpath = "//input[@id='password']")
	WebElement pwd;

	@FindBy(css = "[value='Sign in']")
	WebElement signIn;

	public WebElement username() {

		return uname;
	}

	public WebElement password() {

		return pwd;
	}

	public WebElement submit() {

		return signIn;
	}
}
