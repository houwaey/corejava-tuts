package com.library.utils;

/**
 * <p>Used in string formatting / manipulation.</p>
 * 
 * @see StringBuilder
 * @see StringBuffer
 * @version %I%, %G% 
 * @author Houwaey (Collabera)
 */
public final class StringUtil
{
	
	/*
	 * (non-javadoc)
	 * Private constructor to prevent instantiation.
	 */
	private StringUtil()
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Used to validate the string if {@code null} or {@code empty}.
	 * 
	 * @param value String that needs to be validated.
	 * @return {@code boolean} - if {@code null} or {@code empty}
	 * @since v1.0
	 *
	 */
	public static boolean isNullOrEmpty(String value)
	{
		return value == null || value.length() == 0;
	}
	
	/**
	 * Used to validate the string if {@code null} or {@code empty}.
	 * 
	 * @param value String that needs to be validated.
	 * @param defaultValue Default value in case the string is {@code null} or {@code empty}.
	 * @return {@code String} - Returns the value in case the {@code value} is not {@code null} or {@code empty}, 
	 * otherwise, it will return {@code defaultValue}.
	 * @since v1.0
	 * @see #isNullOrEmpty(String)
	 * 
	 */
	public static String nvl(String value, String defaultValue)
	{
		return isNullOrEmpty(value) ? defaultValue : value;
	}
	
	/**
	 * Used to join the String array into one string({@code delimited}).
	 * 
	 * <p>
	 * <strong>Example:</strong></br></br>
	 * <code>
	 * String[] arr = {"a","b","c"};</br>
	 * System.out.println(arr, ",");</br></br>
	 * </code>
	 * <u>Output</u>: <code>"a,b,c"</code>
	 * </p>
	 * 
	 * @param array The string array to be joined.
	 * @param delimiter Delimiter of the joined string.
	 * @return Delimited string.
	 * @since v1.0
	 * 
	 */
	public static String join(String[] array, String delimiter)
	{
		StringBuilder sb = new StringBuilder();
		if (delimiter == null) delimiter = "";
		for (String data : array)
		{
			sb.append(data);
			sb.append(delimiter);
		}
		if (sb.length() > 0)
		{
			sb.delete(sb.length() - delimiter.length(), sb.length());
		}
		return sb.toString();
	}
	
	/**
	 * Used to join the Object array into one string({@code delimited}).
	 * 
	 * <p>
	 * <strong>Example:</strong></br></br>
	 * <code>
	 * Integer[] arr = {1,2,3};</br>
	 * System.out.println(arr, ",");</br></br>
	 * </code>
	 * <u>Output</u>: <code>"1,2,3"</code>	
	 * </p>
	 * 
	 * @param array The object array to be joined.
	 * @param delimiter Delimiter of the joined objects.
	 * @return Delimited string.
	 * @since v1.0
	 * 
	 */
	public static String join(Object[] array, String delimiter)
	{
		StringBuilder sb = new StringBuilder();
		if (delimiter == null) delimiter = "";
		for (Object data : array)
		{
			sb.append(data);
			sb.append(delimiter);
		}
		if (sb.length() > 0)
		{
			sb.delete(sb.length() - delimiter.length(), sb.length());
		}
		return sb.toString();
	}
	
	/**
	 * Used to add left padding to the String.
	 * 
	 * <p>
	 * <strong>Example:</strong></br></br>
	 * <code>
	 * System.out.println("12345", 5, "0");</br></br>
	 * </code>
	 * <u>Output</u>: <code>"0000012345"</code>
	 * </p>
	 * 
	 * @param str Input string to be padded.
	 * @param length Number of character to be added.
	 * @param car The character to be added.
	 * @return {@code String} - padded string.
	 * @since v1.0
	 * 
	 */
	public static String leftPad(String str, int length, char car)
	{
		if (length <= str.length())
		{
			return str.substring(str.length() - length);
		}
		return str + String.format("%" + (length - str.length()) + "s", "").replace(" ", String.valueOf(car));
	}

	/**
	 * Used to add right padding to the String.
	 * 
	 * <p>
	 * <strong>Example:</strong></br></br>
	 * <code>
	 * System.out.println("12345", 5, "0");</br></br>
	 * </code>
	 * <u>Output</u>: <code>"1234500000"</code>
	 * </p>
	 * 
	 * @param str Input string to be padded.
	 * @param length Number of character to be added.
	 * @param car The character to be added.
	 * @return {@code String} - padded string.
	 * @since v1.0
	 * 
	 */
	public static String rightPad(String str, int length, char car)
	{
		if (length <= str.length())
		{
			return str.substring(0, length);
		}
		return String.format("%" + (length - str.length()) + "s", "").replace(" ", String.valueOf(car)) + str;
	}
	
	/**
	 * Used to format the string into HTML String.
	 * 
	 * @param string Input string that needs to be formatted.
	 * @return {@code String} - formatted html string.
	 * @since v1.0
	 * 
	 */
	public static String stringToHTMLString(String string)
	{
	    StringBuffer sb = new StringBuffer(string.length());
	    int len = string.length();
	    char c;

	    for (int i = 0; i < len; i++)
	    {
	        c = string.charAt(i);

            // HTML Special Chars
            if (c == '"')
                sb.append("&quot;");
            else if (c == '&')
                sb.append("&amp;");
            else if (c == '<')
                sb.append("&lt;");
            else if (c == '>')
                sb.append("&gt;");
            else if (c == '\n')
                // Handle Newline
            	sb.append("&lt;br/&gt;");
            else
            {
                int ci = 0xffff & c;
                if (ci < 160 )
                {
                	// nothing special only 7 Bit
                    sb.append(c);
                }
                else
                {
                    // Not 7 Bit use the unicode system
                    sb.append("&#");
                    sb.append(Integer.toString(ci));
                    sb.append(';');
                }
            }
	    }
	    return sb.toString();
    }
	
}
