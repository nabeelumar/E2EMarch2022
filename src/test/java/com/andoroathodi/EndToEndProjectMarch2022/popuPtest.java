package com.andoroathodi.EndToEndProjectMarch2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class popuPtest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		//Thread.sleep(2000);
		//driver.navigate().back();
		driver.get("http://the-internet.herokuapp.com");
		driver.findElement(By.linkText("Drag and Drop")).click();
		WebElement src = driver.findElement(By.cssSelector("#column-a"));
		WebElement trg = driver.findElement(By.cssSelector("#column-b"));
		Actions a = new Actions(driver);
		a.dragAndDrop(src, trg).build().perform();;
		 
	}

}
