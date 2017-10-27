package com.cbsp.seed;



import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.WrapsDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.google.common.base.Function;


import junit.framework.Assert;

public class WDriver {

	private static WebDriver driver; 
	private static File currentDirectory = new File("");
    //private static Logger log = Logger.getLogger(driver);
	//private static Logger log = Logger.getLogger(WDriver.class) ;
	private static Logger log;
	private FluentWait<WebDriver> wait;
	private int timeOut;
	private int pollInterval;
	
	
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
		
	//	log.info("navigate to " + url);
		this.driver.navigate().to(url);
	}
	
	/**
	 * 
	 */
	public void QuitDriver() {
		//log.info("End test suit");
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
	//	log.info("Max the window");
		
	
	}
	
	public void waitTime() {
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	public void elementSendKey(final String xpath, String value) {
//		findElementByFluentWaitAndXPath(xpath);
		waitTime();
		driver.findElement(By.xpath(xpath)).clear();
		this.driver.findElement(By.xpath(xpath)).sendKeys(value);
	//	log.info("Insert the text: " +  value);
	}
	public void elementClick(String xpath) {
	//	findElementByFluentWaitAndXPath(xpath);
		waitTime();
		String value =  driver.findElement(By.xpath(xpath)).getAttribute("value");
		System.out.println("text is " + driver.findElement(By.xpath(xpath)).getAttribute("value")); 
		System.out.println("text is " + driver.findElement(By.xpath(xpath)).getText()); 
		String clickValue =  driver.findElement(By.xpath(xpath)).getText();
		this.driver.findElement(By.xpath(xpath)).click();
	//	log.info("Click " +clickValue);
	}
	
	
	public void findElement(String xpath) {
		//	findElementByFluentWaitAndXPath(xpath);
		 WebElement loginButton = this.driver.findElement(By.xpath(xpath));
			waitTime();
			System.out.println("The element is " + loginButton.getText());
			loginButton.click();
			this.driver.findElement(By.xpath(xpath));
	}
	
	public String getText(String xpath) {
		//	findElementByFluentWaitAndXPath(xpath);
		 WebElement text = this.driver.findElement(By.xpath(xpath));
			waitTime();
			System.out.println("The element is " + text.getText());
			return text.getText();
	}
	
	public void checkingElement(String xpath) {
		this.driver.findElement(By.xpath(xpath));
	}
	
	public void findElementByNumber(String xpath) {
		//	findElementByFluentWaitAndXPath(xpath);
		 WebElement loginButton = this.driver.findElement(By.xpath(xpath));
			waitTime();
			System.out.println("The element is " + loginButton.getText());
			System.out.println("The element size " + loginButton.getSize());
			
			this.driver.findElement(By.xpath(xpath));
	}
	
	public void close() {
		this.driver.close();
	}
	
	
	
	public void elementVisiable(String xpath, String text) {
//		findElementByFluentWaitAndXPath(xpath);
		waitTime();
		String[] arrtext = text.split(" ");
		
		//bodyText.contain(keywords[n]);
		
		System.out.println("the compare text is " +text);
		String bodyText = this.driver.findElement(By.xpath(xpath)).getText();
		System.out.println("the text is " +bodyText);
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
		
		//log.info("Check the elements " +  text + " is visible");
		
		
	}
	
	
	public void clickdropDown(String xpath, String subElement) throws InterruptedException {
		waitTime();
	//	findElementByFluentWaitAndXPath(xpath);
		WebElement link = driver.findElement(By.xpath(xpath));
		Actions action = new Actions(this.driver);
		action.moveToElement(link).build().perform();
		Thread.sleep(1000);
		this.driver.findElement(By.linkText(subElement)).click();
		//log.info("Move mouseover a drop down menu and click the drop down value: " + subElement);
	}
	
	public void randomSelectdropDown(String xpath) throws InterruptedException {
		waitTime();
		
		WebElement drpDwnList = driver.findElement(By.xpath(xpath));
		 //Using FindElements to create a List object
		 
		 //Using Select Class to fetch the count
		 Select objSel = new Select(drpDwnList);
		 List <WebElement> weblist = objSel.getOptions();
		 //Taking the count of items
		 int endOption = weblist.size();
		 //Using Random class to generate random values
		 Random num = new Random();
		 int startOption = 1;
		
		 int iSelect = startOption + num .nextInt( endOption - startOption); 
		 //Selecting value from DropDownList
		 objSel.selectByIndex(iSelect);
		 //Selected Value
		 System.out.println("the drop down value is "+drpDwnList.getAttribute("value"));
		// log.info("random select a drop down box value: " + drpDwnList.getAttribute("value"));
	}
	
	public void randomSelectdropDownForYear(String xpath) throws InterruptedException {
		waitTime();
		
		WebElement drpDwnList = driver.findElement(By.xpath(xpath));
		 //Using FindElements to create a List object
		 
		 //Using Select Class to fetch the count
		 Select objSel = new Select(drpDwnList);
		 List <WebElement> weblist = objSel.getOptions();
		 //Taking the count of items
		 int endOption = weblist.size();
		 //Using Random class to generate random values
		 Random num = new Random();
		 int startOption = 2;  //can't be this year
		
		 int iSelect = startOption + num .nextInt( endOption - startOption); 
		 //Selecting value from DropDownList
		 objSel.selectByIndex(iSelect);
		 //Selected Value
		 System.out.println(drpDwnList.getAttribute("value"));
	//	 log.info("random select a drop down box value: " + drpDwnList.getAttribute("value"));
	}
	
	
	public void setWait(int timeOut, int pollInterval, TimeUnit timeUnit) {
		System.out.println("the line is " + timeOut + " " + pollInterval + " " + timeUnit);
		
		this.wait = new FluentWait<WebDriver>(this.driver).withTimeout(timeOut, timeUnit).pollingEvery(pollInterval, timeUnit).ignoring(NoSuchElementException.class);
		
	}
	
	public void scrolldownpage() throws InterruptedException {
		((JavascriptExecutor)this.driver).executeScript("scroll(0,400)");
	}
	
	public FluentWait<WebDriver> getWait() {
		return wait;
	}
	
	
	public void findElementByFluentWaitAndXPath2(final String xpath) {
	
		
		WebElement element = getWait().until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				return element;
			}
			});
	}
	
	public void setWait(int timeOut, int pollInterval) {
		this.timeOut=timeOut;
		this.pollInterval = pollInterval;
	}
	
	public int getTimeOut()
	{
		return timeOut;
	}
	public int getPollInterval()
	{
		return pollInterval;
	}
	
	public void findElementByFluentWaitAndXPath(final String xpath) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(this.driver)
			.withTimeout(getTimeOut(), TimeUnit.SECONDS)
			.pollingEvery(getPollInterval(), TimeUnit.SECONDS)
			.ignoring(NoSuchElementException.class);  
			System.out.println("Timeout is: " + getTimeOut() + " pollInterval is "+ getPollInterval());
			WebElement element = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath(xpath));
				return element;
			}
			});
		
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
	        String dest = currentDirectory.getAbsolutePath() + "/test-output/screenshot/" + screenshotName + ".png";
	        File destination = new File(dest);
	        FileUtils.copyFile(source, destination);
	        return dest;
	        } 

	    catch (IOException e) {return e.getMessage();}
	}
	
	public void takeScreenshotElement(WebElement element) throws IOException {
	    WrapsDriver wrapsDriver = (WrapsDriver) element;
	    File screenshot = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);
	    Rectangle rectangle = new Rectangle(element.getSize().width, element.getSize().height);
	    Point location = element.getLocation();
	    BufferedImage bufferedImage = ImageIO.read(screenshot);
	    BufferedImage destImage = bufferedImage.getSubimage(location.x, location.y, rectangle.width, rectangle.height);
	    ImageIO.write(destImage, "png", screenshot);
	    File file = new File("//path//to");
	    FileUtils.copyFile(screenshot, file);
	}
	
	public static String gettime()
	{
		Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddhhmmss");

	      System.out.println("Current Date: " + ft.format(dNow));
		
		return ft.format(dNow); 
	}
	
	public static String getCreditcardNumber()
	{
		Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddhhmmss");
	    Random rand = new Random();
	    int randomCard = 3 + rand.nextInt(3);   //display credit card 3, 4 , 5
	    int randomInteger = (int)(Math.random() * 9);
	    String creditcard= randomCard + "" + randomInteger + ft.format(dNow);

	      System.out.println("credit card: " + creditcard);
		
		return creditcard; 
	}
	
	public static String getVISACreditcardNumber()
	{
		String card[] = {"4929349427826558", "4532220944133290", "4556118442234431",
		   "4940988578651797", "4898959619596046", 
			"4716665600226721", "4532757305711628", "4405613331491137", "4929790126600986", "4929538712955516",
			"4929538712955516"
		};
		
	    
	    int randomInteger = (int)(Math.random() * card.length);
	  //String creditcard= card[randomInteger];
	   String creditcard =  "370894492001902";
	      System.out.println("VISA credit card: " + creditcard);
		
		return creditcard; 
	}
	
	/**
	 * 
	 * @param frameName
	 */
	public void switchToFrame(String frameName) {
		waitTime();
		WebElement iFrame= driver.findElement(By.xpath(frameName));
		this.driver.switchTo().frame(iFrame);
	}
	
	public void switchToNewWindow() {
		waitTime();
		Set handles = this.driver.getWindowHandles();
		 
        System.out.println(handles);

        // Pass a window handle to the other window

        for (String handle1 : driver.getWindowHandles()) {

        	System.out.println("the new handle is " + handle1);

        	driver.switchTo().window(handle1);

        	}
	}
	
	
	public void switchToDefaultContent() {
		this.driver.switchTo().defaultContent();
	}
	
	public void switchToActiveElement() {
		this.driver.switchTo().activeElement();
	}


}


