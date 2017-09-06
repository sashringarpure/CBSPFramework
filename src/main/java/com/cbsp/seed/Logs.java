package com.cbsp.seed;

import org.apache.log4j.Logger;

public class Logs {
	
	private static Logger Log = Logger.getLogger(Logs.class.getName());

	public Logs() {
		// TODO Auto-generated constructor stub
	}
	
	public static void startTestRun(String testCaseName) {
		Log.info("===========================================================================");
		Log.info("===========================================================================");
		Log.info("					starting new test run									 ");
		Log.info("===========================================================================");
		Log.info("===========================================================================");		
	}
	
	public static void startTestCase(String testCaseName) {
		Log.info("===========================================================================");
		Log.info("===========================================================================");
		Log.info("					starting test :" + testCaseName + "						 ");
		Log.info("===========================================================================");
		Log.info("===========================================================================");		
	}
	
	public static void endTestCase(String testCaseName) {
		Log.info("===========================================================================");
		Log.info("					ending test :" + testCaseName + "						 ");
		Log.info("===========================================================================");		
	}
	
	public static void info(String message) {
		Log.info(message);
	}
	
	public static void warn(String message) {
		Log.warn(message);
	}
	
	public static void error(String message) {
		Log.error(message);
	}
	
	public static void fatal(String message) {
		Log.fatal(message);
	}
	
	public static void debug(String message) {
		Log.debug(message);
	}
}
