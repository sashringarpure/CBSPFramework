package com.cbsp.seed;

import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.By;

import com.google.common.base.Function;

public class WDriver {

	private WebDriver driver; 
	private Wait<WebDriver> wait;
	
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
	 */
	public void QuitDriver() {
		this.driver.quit();
	}
	
	/**
	 * 
	 * @param driver
	 * @param timeOut
	 * @param pollInterval
	 * @param timeUnit
	 */
	public void setWait(WebDriver driver, int timeOut, int pollInterval, TimeUnit timeUnit) {
		this.wait = new FluentWait<WebDriver>(driver).withTimeout(timeOut, timeUnit).pollingEvery(pollInterval, timeUnit).ignoring(NoSuchElementException.class);
	}
	
	public Wait<WebDriver> getWait() {
		return this.wait;
	}
	
	public WebDriver getWebDriver() {
		return this.driver;
	}
	
	/**
	 * @throws InterruptedException
	 */	
	public void driverWait() throws InterruptedException {
		this.driver.wait();
	}
	
	/**
	 * @param timeout
	 * @throws InterruptedException
	 */
	public void driverWait(int timeout) throws InterruptedException {
		this.driver.wait(timeout);
	}
	
	/**
	 * 
	 * @return returns a driver in string format.
	 */
	public String driverToString() {
		return this.driver.toString();
	}
	
	/**
	 * @param windowName
	 */
	public void switchToWindow(String windowName) {
		this.driver.switchTo().window(windowName);
	}
	
	public void switchToParentFrame() {
		this.driver.switchTo().parentFrame();
	}
	
	/**
	 * 
	 * @param frameName
	 */
	public void switchToFrame(String frameName) {
		this.driver.switchTo().frame(frameName);
	}
	
	/**
	 * 
	 * @param frameId
	 */
	public void switchToFrame(int frameId) {
		this.driver.switchTo().frame(frameId);
	}
	
	public void switchToDefaultContent() {
		this.driver.switchTo().defaultContent();
	}
	
	public void switchToActiveElement() {
		this.driver.switchTo().activeElement();
	}
	
	public void quit() {
		this.driver.quit();
	}
	
	public void close() {
		this.driver.close();
	}
	
	/**
	 * 
	 * @param url
	 */
	public void navigateTo(URL url) {
		this.driver.navigate().to(url);
	}
	
	/**
	 * 
	 * @param url
	 */
	public void navigateTo(String url) {
		this.driver.navigate().to(url);
	}
	
	public void refresh() {
		this.driver.navigate().refresh();
	}
	
	public void navigateForward() {
		this.driver.navigate().forward();
	}
	
	public void navigateBack() {
		this.driver.navigate().back();
	}

	public void setWindowPosition() {
		this.driver.manage().window().setPosition(new Point(0,0));
	}
	
	/**
	 * 
	 * @param d
	 */
	public void setWindowSize(Dimension d) {
		this.driver.manage().window().setSize(d);
	}
	
	public void maximizeBrowser() {
		this.driver.manage().window().setPosition(new Point(0,0));
		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension d = new Dimension((int) screenSize.getWidth(),(int) screenSize.getHeight());
		this.driver.manage().window().setSize(d);
	}
	
	public void maximizeWindow() {
		this.driver.manage().window().maximize();
	}
	
	/**
	 * 
	 * @return returns the size of the window.
	 */
	public Dimension getWindowSize() {
		return this.driver.manage().window().getSize();
	}
	
	/**
	 * 
	 * @return returns the position of the window.
	 */
	public Point getWindowPosition() {
		return this.driver.manage().window().getPosition();
	}
	
	/**
	 * 
	 * @param seconds : time to wait in.
	 * @param secs : TimeUnit.
	 */
	public void setImplicitWait(int seconds, TimeUnit secs) {
		this.driver.manage().timeouts().implicitlyWait(seconds, secs);
	}
	
	/**
	 * 
	 * @param seconds : time to wait in.
	 * @param secs : TimeUnit.
	 */
	public void setPageLoadTimeout(int seconds, TimeUnit secs) {
		this.driver.manage().timeouts().pageLoadTimeout(seconds, secs);
	}
	
	/**
	 * 
	 * @param seconds : time to wait in.
	 * @param secs : TimeUnit.
	 */
	public void setScriptTimeout(int seconds, TimeUnit secs) {
		this.driver.manage().timeouts().setScriptTimeout(seconds, secs);
	}
	
	/**
	 * 
	 * @return A set consisting of cookies.
	 */
	public Set<Cookie> getCookies() {
		return this.driver.manage().getCookies();
	}
	
	/**
	 * 
	 * @param cookieName
	 * @return a cookie object.
	 */
	public Cookie getCookieNamed(String cookieName) {
		return this.driver.manage().getCookieNamed(cookieName);
	}
	
	/**
	 * 
	 * @param cookieName
	 */
	public void deleteCookieNamed(String cookieName) {
		this.driver.manage().deleteCookieNamed(cookieName);
	}
	
	/**
	 * 
	 * @param cookie
	 */
	public void deleteCookie(Cookie cookie) {
		this.driver.manage().deleteCookie(cookie);
	}
	
	public void deleteAllCookies() {
		this.driver.manage().deleteAllCookies();
	}
	
	/**
	 * 
	 * @param cookie
	 */
	public void AddCookies(Cookie cookie) {
		this.driver.manage().addCookie(cookie);
	}
	
	/**
	 * 
	 * @return all window handles.
	 */
	public Set<String> getAllWindowHandles() {
		return this.driver.getWindowHandles();
	}
	
	public String getWindowHandle() {
		return this.driver.getWindowHandle();
	}
	
	/**
	 * 
	 * @return page title
	 */
	public String getTitle() {
		return this.driver.getTitle();
	}
	
	/**
	 * 
	 * @return page source
	 */
	public String getPageSource() {
		return this.driver.getPageSource();
	}
	
	/**
	 * 
	 * @return current URL
	 */
	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}
	
	/**
	 * 
	 * @param url
	 */
	public  void get(String url) {
		this.driver.get(url);
	}
	
	
}
