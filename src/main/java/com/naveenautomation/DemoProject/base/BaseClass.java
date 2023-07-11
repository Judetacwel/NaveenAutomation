package com.naveenautomation.DemoProject.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver wd;

	Properties prop;

	FileInputStream fileInputStream;

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

	public void initialisation() {
		String browserName = prop.getProperty("browser");
		switch (browserName) {
		case "chrome":
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

		wd.get(prop.getProperty("URL"));
		wd.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("Implicit_wait")), TimeUnit.SECONDS);
		wd.manage().window().maximize();

	}

	public void tearDown() {
		wd.quit();

	}

}
