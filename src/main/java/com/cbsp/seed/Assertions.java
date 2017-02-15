package com.cbsp.seed;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.testng.Assert;

public class Assertions {

	public Assertions() {
		// TODO Auto-generated constructor stub
	}
	
	public void AssertEqualsBoolean(boolean expected, boolean actual) {
		Assert.assertEquals(actual, expected);
	}
	
	public void AssertEqualsChar(char expected, char actual) {
		Assert.assertEquals(actual, expected);
	}
	
	public void AssertEqualsInt(int expected, int actual) {
		Assert.assertEquals(actual, expected);
	}
	
	public void AssertEqualsLong(long expected, long actual) {
		Assert.assertEquals(actual, expected);
	}
	
	public void AssertEqualsCollection(Collection<?>  expected, Collection<?> actual) {
		Assert.assertEquals(actual, expected);
	}
	
	public void AssertEqualsMap(Map<?,?> expected, Map<?,?> actual) {
		Assert.assertEquals(actual, expected);
	}
	
	public void AssertEqualsObject(Object expected, Object actual) {
		Assert.assertEquals(actual, expected);
	}
	
	public void AssertEqualsObjectArray(Object[] expected, Object[] actual) {
		Assert.assertEquals(actual, expected);
	}
	
	public void AssertEqualsSet(Set<?> expected, Set<?> actual) {
		Assert.assertEquals(actual, expected);
	}
	
	public void AssertEqualsShort(short expected, short actual) {
		Assert.assertEquals(actual, expected);
	}
	
	public void AssertEqualsString(String expected, String actual) {
		Assert.assertEquals(actual, expected);
	}
	
	public void AssertEqualsIterable(Iterable<?> expected, Iterable<?> actual) {
		Assert.assertEquals(actual, expected);
	}
	
	public void AssertEqualsIterator(Iterator<?> expected, Iterator<?> actual) {
		Assert.assertEquals(actual, expected);
	}
	
	public void AssertEqualsFloat(float expected, float actual ) {
		Assert.assertEquals(actual, expected);
	}
	
	public void AssertEqualsBoolean(boolean expected, boolean actual, String message) {
		Assert.assertEquals(actual, expected, message);
	}
	
	public void AssertEqualsChar(char expected, char actual, String message) {
		Assert.assertEquals(actual, expected, message);
	}
	
}
