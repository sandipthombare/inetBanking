package com.inetBanking.testCases;



import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;

//import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;
import com.inetBanking.utilities.Reporting;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	Reporting reporting = new Reporting();
	
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	
	public static WebDriver driver;
    public static Logger logger = LogManager.getLogger(BaseClass.class);
    
    public String addExtensionPath = "./Extensions/uBlockOrigin.crx";
    
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

			 // Ensure the path is correct and accessible
            logger.info("setup method started");
            
            try {
            	
            	 initializeDriver(br);
            	 Thread.sleep(5000);
            	 driver.get(baseURL);
            	 driver.manage().window().maximize();
                 
            } catch (Exception e) {
            	logger.error("Failed to initialize the WebDriver", e);
                throw new RuntimeException("Driver initialization failed", e);
            }
    }
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();	
	}
	
	public void initializeDriver(String browser) {
		logger.info("Initializing WebDriver for browser: "+ browser);
		switch(browser.toLowerCase()) {
		
		case "chrome":
			
			ChromeOptions opt = new ChromeOptions();
			opt.addExtensions(new File(addExtensionPath));
			
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver(opt);
			
			break;
			
		case "edge":
			System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Invalid browser value: "+ browser);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public static void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" +tname + ".png");
		FileUtils.copyFile(source,target);
		System.out.println("Screenshot taken");
		
	}
	
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public String randomNumber()
	{
		String generatedString1 = RandomStringUtils.randomNumeric(4);
		return generatedString1;
	}
}
