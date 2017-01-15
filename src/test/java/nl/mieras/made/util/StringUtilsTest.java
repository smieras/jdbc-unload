package nl.mieras.made.util;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StringUtilsTest {
	
	private Object[] dataWithoutElements;
	private Object[] dataWithOneElement;
	private Object[] dataWithoutDelimiters;
	private Object[] dataWithDelimiters;
	
	@Before
	public void setUp() {
		dataWithoutElements = new Object[] {};
		dataWithOneElement = new Object[] { "0" };
		dataWithoutDelimiters = new Object[] { "1" , "john", "smith"};
		dataWithDelimiters = new Object[] { "2", "jane, a", "cage"};
	}

	@Test
	public void testArrayToDelimitedStringWithoutElements() {
		String expectedResult = "";
		String actualResult = StringUtils.arrayToDelimitedString(dataWithoutElements, ',', '"');
		
		assertTrue(String.format("The expected result [ %s ] is not the same as the actual result [ %s ]", expectedResult, actualResult),  expectedResult.equals(actualResult));
	}
	@Test
	public void testArrayToDelimitedStringWithOneElement() {
		String expectedResult = "0";
		String actualResult = StringUtils.arrayToDelimitedString(dataWithOneElement, ',', '"');
		
		assertTrue(String.format("The expected result [ %s ] is not the same as the actual result [ %s ]", expectedResult, actualResult),  expectedResult.equals(actualResult));
	}
	@Test
	public void testArrayToDelimitedStringWithoutDelimiters() {
		String expectedResult = "1,john,smith";
		String actualResult = StringUtils.arrayToDelimitedString(dataWithoutDelimiters, ',', '"');
		
		assertTrue(String.format("The expected result [ %s ] is not the same as the actual result [ %s ]", expectedResult, actualResult),  expectedResult.equals(actualResult));
	}
	@Test
	public void testArrayToDelimitedStringWithDelimiters() {
		String expectedResult = "2,\"jane, a\",cage";
		String actualResult = StringUtils.arrayToDelimitedString(dataWithDelimiters, ',', '"');
		
		assertTrue(String.format("The expected result [ %s ] is not the same as the actual result [ %s ]", expectedResult, actualResult),  expectedResult.equals(actualResult));
	}
	
}
