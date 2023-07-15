package com.naveenautomation.DemoProject.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.naveenautomation.DemoProject.base.BaseClass;

public class Utils extends BaseClass{
	
	public static void takeScreenShort(String testName) {
		
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
		System.out.println(timeStamp);
		
		File screenshotFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);		
		try {
			FileUtils.copyFile(screenshotFile,new File( "./FailedScreenShots\\"+"_"+testName+"_"+timeStamp+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
