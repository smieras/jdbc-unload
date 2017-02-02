/*******************************************************************************
 * Copyright 2017 Mieras Made
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package nl.mierasmade.util;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import nl.mierasmade.util.StringUtils;

public class StringUtilsTest {
	
	private Object[] dataWithoutElements;
	private Object[] dataWithNullElements;
	private Object[] dataWithOneElement;
	private Object[] dataWithoutDelimiters;
	private Object[] dataWithDelimiters;
	private Object[] dataWithDelimitersAndQuotes;
	
	@Before
	public void setUp() {
		dataWithoutElements = new Object[] {};
		dataWithNullElements = new Object[] { "-1", null, null };
		dataWithOneElement = new Object[] { "0" };
		dataWithoutDelimiters = new Object[] { "1" , "john", "smith"};
		dataWithDelimiters = new Object[] { "2", "jane, a", "cage"};
		dataWithDelimitersAndQuotes = new Object[] { "3", "\"s'Hertogenbosch, Den Bosch", "Nederland"};
	}

	@Test
	public void testArrayToDelimitedStringWithoutElements() {
		String expectedResult = "";
		String actualResult = StringUtils.arrayToDelimitedString(dataWithoutElements, ',', '"', '\\');
		
		assertTrue(String.format("The expected result [ %s ] is not the same as the actual result [ %s ]", expectedResult, actualResult),  expectedResult.equals(actualResult));
	}
	@Test
	public void testArrayToDelimitedStringWithNullElements() {
		String expectedResult = "-1,null,null";
		String actualResult = StringUtils.arrayToDelimitedString(dataWithNullElements, ',', '"', '\\');
		
		assertTrue(String.format("The expected result [ %s ] is not the same as the actual result [ %s ]", expectedResult, actualResult),  expectedResult.equals(actualResult));
	}
	@Test
	public void testArrayToDelimitedStringWithOneElement() {
		String expectedResult = "0";
		String actualResult = StringUtils.arrayToDelimitedString(dataWithOneElement, ',', '"', '\\');
		
		assertTrue(String.format("The expected result [ %s ] is not the same as the actual result [ %s ]", expectedResult, actualResult),  expectedResult.equals(actualResult));
	}
	@Test
	public void testArrayToDelimitedStringWithoutDelimiters() {
		String expectedResult = "1,john,smith";
		String actualResult = StringUtils.arrayToDelimitedString(dataWithoutDelimiters, ',', '"', '\\');
		
		assertTrue(String.format("The expected result [ %s ] is not the same as the actual result [ %s ]", expectedResult, actualResult),  expectedResult.equals(actualResult));
	}
	
	@Test
	public void testArrayToDelimitedStringWithDelimiters() {
		String expectedResult = "2,\"jane, a\",cage";
		String actualResult = StringUtils.arrayToDelimitedString(dataWithDelimiters, ',', '"', '\\');
		
		assertTrue(String.format("The expected result [ %s ] is not the same as the actual result [ %s ]", expectedResult, actualResult),  expectedResult.equals(actualResult));
	}
	
	@Test
	public void testArrayToDelimitedStringWithDelimitersAndQuotes() {
		String expectedResult = "3,\"\\\"s'Hertogenbosch, Den Bosch\",Nederland";
		String actualResult = StringUtils.arrayToDelimitedString(dataWithDelimitersAndQuotes, ',', '"', '\\');
		
		assertTrue(String.format("The expected result [ %s ] is not the same as the actual result [ %s ]", expectedResult, actualResult),  expectedResult.equals(actualResult));
	}	
	}
