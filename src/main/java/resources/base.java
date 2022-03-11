package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class base {
public static Logger log = LogManager.getLogger(base.class.getName());
	public static  WebDriver driver;
	public Properties prop;

	public WebDriver intializeDriver() throws IOException {

		  prop = new Properties();
		/*FileInputStream fis = new FileInputStream(
				"/Users/Nabeel/eclipse-workspace/EndToEndProjectMarch2022/src/main/java/resources/data.properties");*/
		  
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {
		
			//System.setProperty("webdriver.chrome.driver", "/Users/Shared/Files From f.localized/Selenium jars and drivers/Browser Drivers Mac/chromedriver");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/resources/chromedriver");
		
			ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
				
				 
			}
			driver = new ChromeDriver(options);
			
			
		} else if (browserName.equals("edge")) {
		//	System.setProperty("webdriver.edge.driver",
			//		"/Users/Shared/Files From f.localized/Selenium jars and drivers/Browser Drivers Mac/edgedriver_mac64/msedgedriver");
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/src/main/java/resources/msedgedriver");
			driver = new EdgeDriver();

		} else if (browserName.equals("safari")) {

			driver = new SafariDriver();
		}else {
			
			log.fatal("BROWSER WRONG");
		}
		
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
	
		return driver;
	}
	
	public String takeScreenshot(WebDriver driver, String testCaseName) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
		FileUtils.copyFile(src, new File(destinationFile));
	 return destinationFile;
	}

}
