package com.model;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoITDemo 
{
  @Test
   public void upload() throws IOException, InterruptedException
   {
	 System.setProperty("webdriver.chrome.driver", "E:\\Swati Study Material\\SeleniumSetup\\chrome\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 
	 // To load url
	 driver.get("file:///E:/Swati%20Study%20Material/SeleniumSetup/AutoIiTxtFilesForChrome/uploadFile.html");
	
	 // To maximize browser
	 driver.manage().window().maximize();
	 
	 // To click on upload button
	 driver.findElement(By.xpath("//input[@type='File']")).click();
	 
	 Thread.sleep(5000);
	  Runtime.getRuntime().exec("E:\\Swati Study Material\\SeleniumSetup\\AutoIiTxtFilesForChrome\\fileupload.exe");
      
   }                              


}
