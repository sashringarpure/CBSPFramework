package com.cbsp.seed;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SeedFramework {

	private ApacheHttpClient apacheHttpClient;
	private ApachePOI apachePOI;
	private CDriver cDriver;
	private ChromeService chromeService;
	private WDriver wDriver;
	private DropDown dropDown;
	private Element element;
	private ExplicitWait explicitWait;
	private FFDriver ffDriver;
	private FileBufferedReader fileBufferedReader;
	private FileBufferedWriter fileBufferedWriter;
	private FileScanner fileScanner;
	private IEDriver ieDriver;
	private RestAssured restAssured;
	private SDriver sDriver;
	private SnakeYaml snakeYaml;
	private Assertions assertions;
	private HtmlDriver htmlUnitDriver;
	
	public void initApacheHttpClient(String url) {
		this.apacheHttpClient = new ApacheHttpClient(url);
	}
	
	public void initApachePOI() {
		apachePOI = new ApachePOI();
	}
	
	public void initCDriver() {
		cDriver = new CDriver();
	}
	
	public void initChromeService() {
		chromeService = new ChromeService();
	}
	
	public void initWDriver() {
		wDriver = new WDriver();
	}
	
	public void initDropDown() {
		dropDown = new DropDown();
	}
	
	public void initElement() {
		element = new Element();
	}
	
	public void initFFDriver() {
		ffDriver = new FFDriver();
	}
	
	public void initFileBufferedReader(String fileName) throws FileNotFoundException {
		fileBufferedReader = new FileBufferedReader(fileName);
	}
	
	public void initFileBufferedWriter(String fileName) throws IOException {
		fileBufferedWriter = new FileBufferedWriter(fileName);
	}
	
	public void initFileScanner(String fileName) throws FileNotFoundException {
		fileScanner = new FileScanner(fileName);
	}
	
	public void initIEDriver() {
		ieDriver = new IEDriver();
	}
	
	public void initRestAssured() {
		restAssured = new RestAssured();
	}
	
	public void initSDriver() {
		sDriver = new SDriver();
	}
	
	public void initSnakeYaml() {
		snakeYaml = new SnakeYaml();
	}
	
	public void initAssertions() {
		assertions = new Assertions();
	}
	
	public void initHtmlDriver() {
		htmlUnitDriver = new HtmlDriver();
	}

	public ApacheHttpClient getApacheHttpClient() {
		return this.apacheHttpClient;
	}
	
	public ApachePOI getApachePOI() {
		return this.apachePOI;
	}
	
	public CDriver getCDriver() {
		return this.cDriver;
	}
	
	public ChromeService getChromeService() {
		return this.chromeService;
	}
	
	public WDriver getWDriver() {
		return this.wDriver;
	}
	
	public DropDown getDropDown() {
		return this.dropDown;
	}
	
	public Element getElement() {
		return this.element;
	}
	
	public ExplicitWait getExplicitWait() {
		return this.explicitWait;
	}
	
	public FFDriver getFFDriver() {
		return this.ffDriver;
	}
	
	public FileBufferedReader getFileBufferedReader() {
		return this.fileBufferedReader;
	}
	
	public FileBufferedWriter getFileBufferedWriter() {
		return this.fileBufferedWriter;
	}
	
	public FileScanner getFileScanner() {
		return this.fileScanner;
	}
	
	public IEDriver getIEDriver() {
		return this.ieDriver;
	}
	
	public RestAssured getRestAssured() {
		return this.restAssured;
	}
	
	public SDriver getSDriver() {
		return this.sDriver;
	}
	
	public SnakeYaml getSnakeYaml() {
		return this.snakeYaml;
	}
	
	public Assertions getAssertions() {
		return this.assertions;
	}
	
	public HtmlDriver getHtmlDriver() {
		return this.htmlUnitDriver;
	}
}
