package factory;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	
	static WebDriver driver;
	static Properties p;
	static Logger Logger;
	
	
	public static WebDriver intilizeBrowser() throws IOException 
	{
		p = getProperties();
		String executionEnv = p.getProperty("execution_env");
		String browser = p.getProperty("browser").toLowerCase();
		String os = p.getProperty("os").toLowerCase();
		
		if(executionEnv.equalsIgnoreCase("remote")) 
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//OS
			switch (os) 
			{
			case "windows": capabilities.setPlatform(Platform.WINDOWS);break;
			case "mac": capabilities.setPlatform(Platform.MAC);break;
			case "linux": capabilities.setPlatform(Platform.LINUX);break;
			default: System.out.println("No Matching OS"); return null;
			}
			
			//browser
			switch(browser)
			{
			case "chrome": capabilities.setBrowserName("chrome");break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge");break;
			case "firefox": capabilities.setBrowserName("firefox");break;
			default : System.out.println("no matcching browser"); return null;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		}
		else if(executionEnv.equalsIgnoreCase("local"))
		{
			switch(browser.toLowerCase()) 
			{
			case "chrome": driver=new ChromeDriver();break;
			case "edge": driver= new EdgeDriver();break;
			case "firefox": driver= new FirefoxDriver();break;

			default : System.out.println("no matching browser");return null;
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		return driver;
	}
	
	public static WebDriver getDriver() 
	{
		return driver;
	}
	
	public static Properties getProperties() throws IOException 
	{
		FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		return p;
	}
	
	public static Logger getLogger() 
	{
		Logger = LogManager.getLogger();
		return Logger;
	}
	
	public static String randomeString() 
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	public static String randomeNumber()
	{
		String generatedNum = RandomStringUtils.randomNumeric(10);
		return generatedNum;
		
	}
	public static String AlphaNumeric() 
	{
		String str = RandomStringUtils.randomAlphabetic(5);
		String num = RandomStringUtils.randomNumeric(5);
		return str+num;
	}

}
