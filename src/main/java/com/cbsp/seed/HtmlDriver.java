/**
 * @author sshringarpure
 * 
 */
package com.cbsp.seed;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;

import junit.framework.Assert;



public class HtmlDriver {
	
	private HtmlUnitDriver htmlUnitDriver;

	public HtmlDriver() {
		this.htmlUnitDriver = null;
	}
	
	public void setHtmlUnitDriver()  {
		htmlUnitDriver = new HtmlUnitDriver();
	}
	
	public void setHtmlUnitDriver(boolean enableJavaScript)  {
		htmlUnitDriver = new HtmlUnitDriver(enableJavaScript);
	}

	public void setHtmlUnitDriver(org.openqa.selenium.Capabilities capabilities)  {
		htmlUnitDriver = new HtmlUnitDriver(capabilities);
	}
	
	public void setHtmlUnitDriver(com.gargoylesoftware.htmlunit.BrowserVersion version)  {
		htmlUnitDriver = new HtmlUnitDriver(version);
	}
	
	public HtmlUnitDriver getHtmlUnitDriver() {
		return this.htmlUnitDriver;
	}
	
	public void closeHtmlUnitDriver() {
		this.htmlUnitDriver.close();
	}
	
	public WebElement findElementBy(org.openqa.selenium.By by) {
		return this.htmlUnitDriver.findElement(by);
	}
	
	public WebElement findElementBy(String className) {
		return this.htmlUnitDriver.findElementByClassName(className);
	}
	
	public WebElement findElementByCssSelector(String cssSelector) {
		return this.htmlUnitDriver.findElementByCssSelector(cssSelector);
	}
	
	public WebElement findElementById(String id) {
		return this.htmlUnitDriver.findElementById(id);
	}
	
	public WebElement findElementByLinkText(String linkText) {
		return this.htmlUnitDriver.findElementByLinkText(linkText);
	}
	
	public WebElement findElementByName(String name) {
		return this.htmlUnitDriver.findElementByName(name);
	}
	
	public WebElement findElementByPartialLinkText(String partialLinkText) {
		return this.htmlUnitDriver.findElementByPartialLinkText(partialLinkText);
	}
	
	public WebElement findElementByTagName(String tagName) {
		return this.htmlUnitDriver.findElementByTagName(tagName);
	}
	
	public WebElement findElementByXPath(String xpath) {
		return this.htmlUnitDriver.findElementByXPath(xpath);
	}
	
	public List<org.openqa.selenium.WebElement> findElements(org.openqa.selenium.By by) {
		return this.htmlUnitDriver.findElements(by);
	}
	
	public List<org.openqa.selenium.WebElement> findElementsByClassName(String className) {
		return this.htmlUnitDriver.findElementsByClassName(className);
	}
	
	public List<org.openqa.selenium.WebElement> findElementsByCssSelector(String cssSelector) {
		return this.htmlUnitDriver.findElementsByCssSelector(cssSelector);
	}
	
	public List<org.openqa.selenium.WebElement> findElementsById(String id) {
		return this.htmlUnitDriver.findElementsById(id);
	}
	
	public List<org.openqa.selenium.WebElement> findElementsByLinkText(String linkText) {
		return this.htmlUnitDriver.findElementsByLinkText(linkText);
	}
	
	public List<org.openqa.selenium.WebElement> findElementsByName(String name) {
		return this.htmlUnitDriver.findElementsByName(name);
	}
	
	public List<org.openqa.selenium.WebElement> findElementsByPartialLinkText(String partialLinkText) {
		return this.htmlUnitDriver.findElementsByPartialLinkText(partialLinkText);
	}
	
	public List<org.openqa.selenium.WebElement> findElementsByXPath(String xpath) {
		return this.htmlUnitDriver.findElementsByXPath(xpath);
	}
	
	public void navigateTo(String url) {
		this.htmlUnitDriver.get(url);
	}
	
	public org.openqa.selenium.Capabilities getBrowserCapabilities() {
		return this.htmlUnitDriver.getCapabilities();
	}
	
	public String getUrlOfCurrentPage() {
		return this.htmlUnitDriver.getCurrentUrl();
	}
	
	public org.openqa.selenium.interactions.Keyboard getkeyBoard() {
		return this.htmlUnitDriver.getKeyboard();
	}
	
	public org.openqa.selenium.interactions.Mouse getMouse() {
		return this.htmlUnitDriver.getMouse();
	}
	
	public String getPageSource() {
		return this.htmlUnitDriver.getPageSource();
	}
	
	public String getTitle() {
		return this.htmlUnitDriver.getTitle();
	}
	
	public String getWindowHandle() {
		return this.htmlUnitDriver.getWindowHandle();
	}
	
	public Set<String> getWindowHandles() {
		return this.htmlUnitDriver.getWindowHandles();
	}
	
	public boolean isJavaScriptEnabled() {
		return this.htmlUnitDriver.isJavascriptEnabled();
	}
	
	public org.openqa.selenium.WebDriver.Options manage() {
		return this.htmlUnitDriver.manage();
	}
	
	public org.openqa.selenium.WebDriver.Navigation navigate() {
		return this.htmlUnitDriver.navigate();
	}
	
	public void quit() {
		this.htmlUnitDriver.quit();
	}
	
	public void setAutoProxy(String autoProxyUrl) {
		this.htmlUnitDriver.setAutoProxy(autoProxyUrl);
	}
	
	public void setHTTPProxy(String host, int port, ArrayList<String> noProxyHosts) {
		this.htmlUnitDriver.setHTTPProxy(host, port, noProxyHosts);
	}
	
	public void setJavaScriptEnables(boolean enableJavaScript) {
		this.htmlUnitDriver.setJavascriptEnabled(enableJavaScript);
	}
	
	public void setProxy(String host, int port) {
		this.htmlUnitDriver.setProxy(host, port);
	}
	
	public void setProxySettings(org.openqa.selenium.Proxy proxy) {
		this.htmlUnitDriver.setProxySettings(proxy);
	}
	
	public void setSocksProxy(String host, int port) {
		this.htmlUnitDriver.setSocksProxy(host, port);
	}
	
	public void setSocksProxy(String host, int port, ArrayList<String> noProxyHosts) {
		this.htmlUnitDriver.setSocksProxy(host, port,noProxyHosts);
	}
	
	public org.openqa.selenium.WebDriver.TargetLocator switchTo() {
		return this.htmlUnitDriver.switchTo();
	}
	public void elementSendKey(String id, String value) {
		this.htmlUnitDriver.findElement(By.id(id)).sendKeys(value);
	}
	public void elementClick(String xpath) {
		this.htmlUnitDriver.findElement(By.xpath(xpath)).click();;
	}
	
	public void elementVisiable(String xpath, String text) {
		String[] arrtext = text.split(" ");
		
		//bodyText.contain(keywords[n]);
		
		System.out.println("the compare text is " +text);
		String bodyText = this.htmlUnitDriver.findElement(By.xpath(xpath)).getText();
		System.out.println("the text is " +this.htmlUnitDriver.findElement(By.xpath(xpath)).getText());
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

	
}
