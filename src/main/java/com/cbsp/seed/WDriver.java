package com.cbsp.seed;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.log4testng.Logger;

import com.assertthat.selenium_shutterbug.core.Shutterbug;

import junit.framework.Assert;

public class WDriver {

	private static WebDriver driver; 
	private static File currentDirectory = new File("");
	//private static Logger log = Logger.getLogger(driver);
	
	public WDriver() {
		this.driver = null;
	}
	
	/**
	 * 
	 * @param service
	 */
	public void CreateDriver(ChromeDriverService service) {
		this.driver = new RemoteWebDriver(service.getUrl(),DesiredCapabilities.chrome());
	}
	
	/**
	 * 
	 * @param url
	 */
	public void navigateTo(String url) {
		this.driver.navigate().to(url);
	}
	
	/**
	 * 
	 */
	public void QuitDriver() {
		this.driver.quit();
	}
	
	public void maxWindow() {
		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver( options ); 
		
		/*driver.manage().window().setPosition(new Point(0,0));
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
		driver.manage().window().setSize(dim);
		*/
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--kiosk");
		driver = new ChromeDriver(chromeOptions);
		
	
	}
	
	
	public void elementSendKey(String xpath, String value) {
		driver.findElement(By.xpath(xpath)).clear();
		this.driver.findElement(By.xpath(xpath)).sendKeys(value);
	}
	public void elementClick(String xpath) {
		this.driver.findElement(By.xpath(xpath)).click();;
	}
	
	public void elementVisiable(String xpath, String text) {
		String[] arrtext = text.split(" ");
		
		//bodyText.contain(keywords[n]);
		
		System.out.println("the compare text is " +text);
		String bodyText = this.driver.findElement(By.xpath(xpath)).getText();
		System.out.println("the text is " +this.driver.findElement(By.xpath(xpath)).getText());
		System.out.println("");
		
		boolean result = true;
		
		for (String s: arrtext)
		{
			if (!bodyText.contains(s))
			{
				result = false;
			}
		}
		
		System.out.println("the result of contain is" + result);
		
		if(bodyText.contains(text))
		  {
		    System.out.println("Pass");
		  }
		else
		  {
		    System.out.println("Fail");
		  }
		
		Assert.assertTrue("Text is not correct", result);
		
		
	}
	public void captureScreen() {
	    String path;
	    try {
	        WebDriver augmentedDriver = new Augmenter().augment(driver);
	        File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
	        path = "./target/screenshots/" + source.getName();
	        FileUtils.copyFile(source, new File(path)); 
	    }
	    catch(IOException e) {
	        path = "Failed to capture screenshot: " + e.getMessage();
	    }
	    //return path;
	    
	/*	String path= currentDirectory.getAbsolutePath() + "/test-output/";
		String test = "google";
		System.out.println(path);
		try {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			System.out.println("pass here==================1");
			FileUtils.copyFile(scrFile, new File(path + "screenshot.png"));
			System.out.println("pass here==================2");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//String path= currentDirectory.getAbsolutePath() + "/test-output/";
		//Shutterbug.shootPage(driver).save(path);
		
	}
	
	public static String captureScreenshot (String screenshotName){

	    try {
	        TakesScreenshot ts = (TakesScreenshot)driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String dest = currentDirectory.getAbsolutePath() + "/test-output/" + screenshotName + ".png";
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination);
	        return dest;
	        } 

	    catch (IOException e) {return e.getMessage();}
	    }


}
