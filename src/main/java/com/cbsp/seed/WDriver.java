package com.cbsp.seed;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WDriver {

	private WebDriver driver; 
	
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

}
