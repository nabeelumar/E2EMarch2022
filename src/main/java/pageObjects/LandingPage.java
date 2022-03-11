package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

  	WebDriver driver;
  	
  	public LandingPage(WebDriver driver) {
  		this.driver=driver;
  	}
  	
  	
  	private By signIn = By.linkText("Sign in");
  	private  By logo = By.cssSelector(".hmsprite.logo");
  	
  	
  	public WebElement signIn() {
  		
  		return driver.findElement(signIn);
  		
  	}
  	
  	public WebElement logoText() {
  		return driver.findElement(logo);
  	}
}
