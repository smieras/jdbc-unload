package nl.mierasmade.util;

import org.springframework.util.ObjectUtils;

public class StringUtils {
	
	/**
	 * Convert a {@code String} array into a delimited {@code String} (e.g. CSV).
	 * <p>Useful for {@code toString()} implementations.
	 * @param arr the array to display
	 * @param delim the delimiter to use (typically a ",")
	 * @param quote the quote to use if a field contains a delimiter
	 * @return the delimited {@code String}
	 */
	public static String arrayToDelimitedString(Object[] arr, char delim, char quote) {
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
				sb.append(quote);
				sb.append(arr[i]);
				sb.append(quote);
			} else {
				sb.append(arr[i]);				
			}			
		}
		return sb.toString();
	}

}
