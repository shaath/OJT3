package com.stockAccounting.Tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class grid 
{
	@Test
	public void gt() throws MalformedURLException
	{
		DesiredCapabilities cap=null;
//		cap=DesiredCapabilities.firefox();
//		cap.setBrowserName("firefox");
//		cap.setPlatform(Platform.WINDOWS);
		
//		cap=DesiredCapabilities.chrome();
//		cap.setBrowserName("chrome");
//		cap.setPlatform(Platform.WINDOWS);
		
		cap=DesiredCapabilities.internetExplorer();
		cap.setBrowserName("internet explorer");
		cap.setPlatform(Platform.WINDOWS);
		
		WebDriver driver=new RemoteWebDriver(new URL("http://192.168.1.18:4444/wd/hub"), cap);
		driver.get("http://webapp.qedgetech.com");
	}

}
