package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "#login1")
	private WebElement uname;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement pwd;

	@FindBy(css = "[value='Sign in']")
	private WebElement signIn;

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
