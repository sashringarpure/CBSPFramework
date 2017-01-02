package com.cbsp.seed;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriverService;

public class ChromeService {
	
	private static ChromeDriverService chromeDriverService;

	public ChromeService() {
		this.chromeDriverService = null;
	}
	
	public void startService(String pathToChromeDriver) {
		this.chromeDriverService = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File(pathToChromeDriver))
				.usingAnyFreePort()
				.build();
		try {
			this.chromeDriverService.start();
		} catch (IOException e) {
			System.out.println("IO execepeption occured while creating chrome driver service.");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	public ChromeDriverService getChromeDriverService() {
			return this.chromeDriverService;
	}
	
	public void stopService() {
		this.chromeDriverService.stop();
	}

}
