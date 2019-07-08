package log4j.mercury;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class MercurtTsLog4j 
{
	public WebDriver driver;
	
	static Logger logger = Logger.getLogger(MercurtTsLog4j.class);
	
	@Test(priority=1)
	  public void loginwithvalidds()
	  {
	    PropertyConfigurator.configure("E:\\Swati Study Material\\java programs\\MercuryTsLog4\\src\\test\\resources\\Log4J.properties");
	    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap1");
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword1");
	    driver.findElement(By.xpath("//input[@name='login']")).click();
	    driver.findElement(By.linkText("SIGN-OFF")).click();
	    logger.info("User has successfully login into Mercury Tours application");
	    logger.debug("User has successfully login into Mercury Tours application");
	    
	  }
	  
	  @Test(priority=2)
	  public void loginwithinvalidds()
	  {
	    PropertyConfigurator.configure("E:\\Swati Study Material\\java programs\\MercuryTsLog4\\src\\test\\resources\\Log4J.properties");
	    driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("Suvidyap");
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P@ssword");
	    driver.findElement(By.xpath("//input[@name='login']")).click();
	    logger.error("User error message");
	    
	  }
  @BeforeMethod
  public void getAllCookies() 
  {
	  Set<Cookie> cookies = driver.manage().getCookies();
	  for(Cookie cookie:cookies)
	  {
		  System.out.println(cookie.getName());
	  }
  }

  @AfterMethod
  public void capatureScrrenshot() 
  {
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  try {
			FileUtils.copyFileToDirectory(src, new File("E:\\Swati Study Material\\java programs\\MercuryTsLog4\\src\\test\\resources\\screenshot\\"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.fatal("Catch block is executed successfully");
		}
	  }  
 

  @BeforeClass
  public void maximizeBrowser() 
  {
	  driver.manage().window().maximize();
	  logger.info("maximizeBrowser is successfully ");
  }

  @AfterClass
  public void deleteAllCookies() 
  {
	  driver.manage().deleteAllCookies();
	  logger.warn("delete all cookies");
  }

  @BeforeTest
  public void enterUrlApplication() 
  {
	  driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	  logger.info("URL is entered successfully");
  }

  @AfterTest
  public void dbConnectionClosed() 
  {
	  logger.info("dbConnectionClosed");
  }

  @BeforeSuite
  public void oenBrowser() 
  {
	  System.setProperty("webdriver.chrome.driver", "E:\\Swati Study Material\\SeleniumSetup\\chrome\\chromedriver.exe");
      driver = new ChromeDriver();
		
	  logger.info("chrome browser open successfully");
	  
  }

  @AfterSuite
  public void closeDriver() 
  {
	  driver.close();
  }

}
