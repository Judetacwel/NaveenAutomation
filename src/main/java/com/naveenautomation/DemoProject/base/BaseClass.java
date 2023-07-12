package com.naveenautomation.DemoProject.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.System.Logger;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.BeforeClass;

import com.naveenautomation.DemoProject.Listerners.WedDriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver wd;
	private Properties prop;
	private FileInputStream fileInputStream;
	public static org.apache.log4j.Logger logger;
	public WedDriverEvents events;
	public EventFiringWebDriver eDriver;

	public BaseClass() {

		prop = new Properties();
		try {
			fileInputStream = new FileInputStream(
					"C:\\Users\\judet\\eclipse-workspace\\DemoProject\\src\\main\\java\\com\\naveenautomation\\DemoProject\\config\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			prop.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@BeforeClass
	public void setUpLogger() {
		logger = org.apache.log4j.Logger.getLogger(BaseClass.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
	}

	public void initialisation() {
		
		
		//String browserName = System.getProperty("BrowserName")!=null?  System.getProperty("BrowserName"): prop.getProperty("browser");

		 String browserName = prop.getProperty("browser");
		switch (browserName) {
		case "Chrome":
			wd = WebDriverManager.chromedriver().create();
			break;
		case "Edge":
			wd = WebDriverManager.edgedriver().create();
			break;
		case "Firefox":
			wd = WebDriverManager.firefoxdriver().create();
			break; 
		default:
			System.out.println("Invalid Browser");
			break;
		}

		eDriver = new EventFiringWebDriver(wd);
		events = new WedDriverEvents();
		eDriver.register(events);
		wd = eDriver;

		wd.get(prop.getProperty("URL"));
		wd.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("Implicit_wait")), TimeUnit.SECONDS);
		wd.manage().window().maximize();

	}

	public void tearDown() {
		wd.quit();

	}

}
