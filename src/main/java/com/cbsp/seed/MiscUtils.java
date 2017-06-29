package com.cbsp.seed;

import java.util.Random;

public class MiscUtils {
	
	private Random random;

	public MiscUtils() {
		// TODO Auto-generated constructor stub
		random = new Random();
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

}
