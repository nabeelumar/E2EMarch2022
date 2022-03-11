package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPageOptimised {
WebDriver driver;
  	
  	public LandingPageOptimised(WebDriver driver) {
  		this.driver=driver;
  	}
  	
  	
  	By signIn = By.linkText("Sign in");
  	By logo = By.cssSelector(".hmsprite.logo");
  	
  	
  	public LoginPage signIn() {
  		
  		  driver.findElement(signIn).click();
return new LoginPage(driver);
  		
  	}
  	
  	public WebElement logoText() {
  		return driver.findElement(logo);
  	}
}
