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

import org.springframework.util.ObjectUtils;

public class StringUtils {
	
	/**
	 * Convert a {@code String} array into a delimited {@code String} (e.g. CSV).
	 * <p>Useful for {@code toString()} implementations.
	 * @param arr the array to display
	 * @param delim the delimiter to use (typically a ",")
	 * @param quote the quote to use if a field contains a delimiter
	 * @param quoteEscape the character used to escape an AS-IS quote
	 * @return the delimited {@code String}
	 */
	public static String arrayToDelimitedString(Object[] arr, char delim, char quote, char quoteEscape) {
		if (ObjectUtils.isEmpty(arr)) {
			return "";
		}
		if (arr.length == 1) {
			return ObjectUtils.nullSafeToString(arr[0]);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (i > 0) {
				sb.append(delim);
			}
			if (arr[i].toString().indexOf(delim) != -1) {
				String candidate = arr[i].toString();
				if (candidate.indexOf(quote) != -1) {
					candidate = arr[i].toString().replace(Character.toString(quote), ("" + quoteEscape + quote));					
				}				
				surroundColumnWithQuotes(candidate, quote, sb, i);				
			} else {
				sb.append(arr[i]);				
			}			
		}
		return sb.toString();
	}

	private static void surroundColumnWithQuotes(String candidate, char quote, StringBuilder sb, int i) {
		sb.append(quote);
		sb.append(candidate);
		sb.append(quote);
	}
}
