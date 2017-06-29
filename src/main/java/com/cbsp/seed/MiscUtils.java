package com.cbsp.seed;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class MiscUtils {
	
	private Random random;
	private DateFormat dateFormat;
	private Date date;

	public MiscUtils() {
		// TODO Auto-generated constructor stub
		random = new Random();
		dateFormat = new SimpleDateFormat("yyyymmddhhmmss");
	}
	
	public double getDoubleRandomNumber() {
		return random.nextDouble();
	}
	
	public double getFloatRandomNumber() {
		return random.nextFloat();
	}
	
	public double getIntRandomNumber() {
		return random.nextInt();
	}
	
	public double getIntRandomNumber(int n) {
		return random.nextInt(n);
	}
	
	public long getLongRandomNumber() {
		return random.nextLong();
	}
	
	public void setSeed(long value) {
		random.setSeed(value);
	}
	
	public String getRandomNumberBasedOnDateTime() {
		date = new Date();
		return dateFormat.format(date);
	}

}
