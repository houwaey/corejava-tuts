package com.library.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <p>Used to format, parse, convert or manipulate date/time.</p>
 * 
 * @see SimpleDateFormat
 * @see Calendar
 * @see Date
 * @see GregorianCalendar
 * @version %I%, %G% 
 * @author Houwaey (Collabera)
 */
public final class DateUtil
{
	/**
	 * Used in {@link SimpleDateFormat} for date/time formatting.
	 * 
	 * <p><strong>Format:</strong> <code>yyyyMMdd</code></p>
	 * <p>
	 * <strong>Example:</strong> <code>20180718</code>
	 * </p>
	 * @since v1.0
	 */
	public static final String DEFAULT_DATEFORMAT = "yyyyMMdd";
	
	/* (non-javadoc)
	 * Used in formatting & parsing date/time using {@code DEFAULT_DATEFORMAT}.
	 */
	private static SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_DATEFORMAT);
	
	/*
	 * (non-javadoc)
	 * Private constructor to prevent instantiation.
	 */
	private DateUtil()
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Used to format or covert object into {@link Date}.
	 * 
	 * @param object The date to be formatted. (Accepted types: {@link String}, {@link Integer})
	 * @return Formatted date ({@link #DEFAULT_DATEFORMAT}).
	 * @throws ParseException If the object parameter is not in correct date format.
	 * @since v1.0
	 * @see #formatObject(Object, String)
	 * 
	 */
	public static Date formatObject(Object object) throws ParseException
	{
		return formatObject(object, DEFAULT_DATEFORMAT);
	}
	
	/**
	 * Used to format or convert object into {@link Date}.
	 * 
	 * <p>
	 * <strong>Examples:</strong></br></br>
	 * 
	 * <i>1) If the object is in the {@code String} format.</i></br></br>
	 * <code>System.out.println(DateUtil.formatObject("2017/07/18", "yyyy/MM/dd"));</code></br></br>
	 * <u>Output</u>: <code>"Tue Jul 18 00:00:00 SGT 2017"</code>
	 * 
	 * </br></br></br>
	 * 
	 * <i>2) If the object is in the {@code Integer} format.</i></br></br>
	 * <code>System.out.println(DateUtil.formatObject(20170718, "yyyyMMdd"));</code></br></br>
	 * <u>Output</u>: <code>"Tue Jul 18 00:00:00 SGT 2017"</code>
	 * </p>
	 * 
	 * @param object The date to be formatted. (Accepted types: {@link String}, {@link Integer})
	 * @param format This parameter is used to parse the input object.
	 * @return Date based on the parsed object. Return {@code null} if the object is 
	 * not a {@code String} or {@code Integer}.
	 * @throws ParseException If the input object and format is not the same.
	 * @since v1.0
	 * 
	 */
	public static Date formatObject(Object object, String format) throws ParseException
	{
		if (object instanceof String || object instanceof Integer)
			return new SimpleDateFormat(format).parse(String.valueOf(object));
		return null;
	}
	
	/**
	 * Used to formats the given object into a specific class type.
	 * 
	 * <p>
	 * <strong>Examples:</strong></br></br>
	 * <i>1) If the object is in the {@code Date} format.</i></br></br>
	 * <code>System.out.println(DateUtil.formatDate(new Date(), "yyyy-MM-dd", String.class));</code></br></br>
	 * <u>Output</u>: <code>"2018-07-19"</code>
	 * 
	 * </br></br></br>
	 * 
	 * <i>2) If the object is in the {@code String} format.</i></br></br>
	 * <code>System.out.println(DateUtil.formatDate("20180719", "yyyy-MM-dd", String.class));</code></br></br>
	 * <u>Output</u>: <code>"2018-07-19"</code>
	 * 
	 * </br></br></br>
	 * 
	 * <i>3) If the object is in the {@code Integer} format.</i></br></br>
	 * <code>System.out.println(DateUtil.formatDate(20180719, "yyyy-MM-dd", String.class));</code></br></br>
	 * <u>Output</u>: <code>"2018-07-19"</code>
	 * </p>
	 * 
	 * @param object The date to be formatted. If the object is a {@code String} or 
	 * an {@code Integer}, the value must be in {@link #DEFAULT_DATEFORMAT} format. 
	 * (Accepted types: {@link Date}, {@link String}, {@link Integer})
	 * @param format It is the output's date format.
	 * @param clazz The output's class type.
	 * @return The formatted object/date ({@code DEFAULT_DATEFORMAT}). Return {@code null} if the object is 
	 * not a {@code String} or {@code Integer}.
	 * @throws ParseException If object parameter is not in {@code DEFAULT_DATEFORMAT} format. 
	 * (Assuming that the object is a {@code String} or an {@code Integer}).
	 * @since v1.0
	 * @see Util#cast(Object, Class)
	 * 
	 */
	public static <T> T formatObject(Object object, String format, Class<T> clazz) throws ParseException
	{
		SimpleDateFormat df = new SimpleDateFormat(format);
		if (object instanceof Date)
			return Util.cast(df.format((Date) object), clazz);
		else if (object instanceof String || object instanceof Integer)
			return Util.cast(df.format(sdf.parse(String.valueOf(object))), clazz);
		else 
			return null;
	}
	
	/**
	 * Used to format the given date to an Object.
	 * 
	 * <p>
	 * <strong>Example:</strong></br></br>
	 * <code>System.out.println(DateUtil.formatDate(new Date(), String.class));</code></br></br>
	 * <u>Output</u>: <code>"20180719"</code>
	 * </p>
	 * 
	 * @param date The date to be formatted.
	 * @param clazz The output's class type.
	 * @return The formatted object ({@link #DEFAULT_DATEFORMAT}).
	 * @since v1.0
	 * @see Util#cast(Object, Class)
	 * 
	 */
	public static <T> T formatDate(Date date, Class<T> clazz)
	{
		return Util.cast(sdf.format(date), clazz);
	}
	
	/**
	 * <p>Used to get the Month's end date of the given date.</p>
	 * 
	 * <p>
	 * <strong>Examples:</strong></br></br>
	 * <i>1) If the object is in the {@code Date} format.</i></br></br>
	 * <code>System.out.println(DateUtil.getMonthEndDate(new Date(), String.class));</code></br></br>
	 * <u>Output</u>: <code>"2018-07-31"</code>
	 * 
	 * </br></br></br>
	 * 
	 * <i>2) If the object is in the {@code String} format.</i></br></br>
	 * <code>System.out.println(DateUtil.getMonthEndDate("20180719", String.class));</code></br></br>
	 * <u>Output</u>: <code>"2018-07-31"</code>
	 * 
	 * </br></br></br>
	 * 
	 * <i>3) If the object is in the {@code Integer} format.</i></br></br>
	 * <code>System.out.println(DateUtil.getMonthEndDate(20180718, String.class));</code></br></br>
	 * <u>Output</u>: <code>"2018-07-31"</code>
	 * </p>
	 * 
	 * @param object Object that you need to parse in able to get the end date. If the object is a 
	 * {@code String} or an {@code Integer}, the value must be in {@link #DEFAULT_DATEFORMAT} format. 
	 * (Accepted types: {@link Date}, {@link String}, {@link Integer})
	 * @param clazz The output's class type.
	 * @return The formatted Month's end date. In case the {@code clazz} is not a {@link Date}, 
	 * the {@code DEFAULT_DATEFORMAT} will be applied.
	 * @throws ParseException If object parameter is not in {@code DEFAULT_DATEFORMAT} format. 
	 * (Assuming that the object is a {@code String} or an {@code Integer}).
	 * @since v1.0
	 * @see #getMonthEndDate(Object, Class, int)
	 * 
	 */
	public static <T> T getMonthEndDate(Object object, Class<T> clazz) throws ParseException
	{
		return getMonthEndDate(object, clazz, 0);
	}
	
	/**
	 * <p>Used to get the Month's end date of the given date/time using factor (+/- month/s).</p>
	 * 
	 * <p>
	 * <strong>Examples:</strong></br></br>
	 * Let: <code>new Date() = "20180719"</code>
	 * </br></br>
	 * 
	 * <i>1) To get the previous month.</i></br></br>
	 * <code>System.out.println(DateUtil.getMonthEndDate(new Date(), String.class, -1));</code></br></br>
	 * <u>Output</u>: <code>"20180630"</code>
	 * 
	 * </br></br></br>
	 * 
	 * <i>2) To get 2 months before.</i></br></br>
	 * <code>System.out.println(DateUtil.getMonthEndDate(new Date(), String.class, -2));</code></br></br>
	 * <u>Output</u>: <code>"20180531"</code>
	 * 
	 * </br></br></br>
	 * 
	 * <i>3) To get the next month.</i></br></br>
	 * <code>System.out.println(DateUtil.getMonthEndDate(new Date(), String.class, 1));</code></br></br>
	 * <u>Output</u>: <code>"20180831"</code>
	 * </p>
	 * 
	 * @param object Object/Date that you need to parse in able to get the end date. If the object is a 
	 * {@code String} or an {@code Integer}, the value must be in {@link #DEFAULT_DATEFORMAT} format. 
	 * (Accepted types: {@link Date}, {@link String}, {@link Integer})
	 * @param clazz The output's class type.
	 * @param factor This value is used to add or subtract month(s) on the given date. (-)Negative value to subtract month(s) 
	 * and (+)Positive value to add month(s).
	 * @return The formatted Month's end date depending on the factor value given. Return {@code null} if the object is 
	 * not a {@code String}, {@code Integer} or {@code Date}.
	 * @throws ParseException If object parameter is not in {@code DEFAULT_DATEFORMAT} format. 
	 * (Assuming that the object is a {@code String} or an {@code Integer}).
	 * @since v1.0
	 * @see Util#cast(Object, Class)
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getMonthEndDate(Object object, Class<T> clazz, int factor) throws ParseException
	{
		Calendar c = Calendar.getInstance();
		if (object instanceof Date)
			c.setTime((Date) object);
		else if (object instanceof String || object instanceof Integer)
			c.setTime(sdf.parse(String.valueOf(object)));
		else 
			return null;
		
		if (factor != 0)
			c.add(Calendar.MONDAY, factor);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		if (clazz == Date.class)
			return (T) c.getTime();
		return Util.cast(sdf.format(c.getTime()), clazz);
	}
	
	/**
	 * <p>Used to get the quarter's end date of the given date/time.</p>
	 * 
	 * <p>
	 * <strong>Example:</strong></br></br>
	 * 
	 * <i>1) If the object is in the {@code String} format.</i></br></br>
	 * <code>System.out.println(DateUtil.getQuarterEndDate("20170718", "MM-dd-yyyy", String.class));</code></br></br>
	 * <u>Output</u>: <code>"09-30-2018"</code>
	 * 
	 * </br></br></br>
	 * 
	 * <i>2) If the object is in the {@code Integer} format.</i></br></br>
	 * <code>System.out.println(DateUtil.getQuarterEndDate(20170718, "MM-dd-yyyy", String.class));</code></br></br>
	 * <u>Output</u>: <code>"09-30-2018"</code>
	 * </p>
	 * 
	 * @param object Object/Date that you need to parse in able to get the quarter's end date. If the object is a 
	 * {@code String} or an {@code Integer}, the value must be in {@link #DEFAULT_DATEFORMAT} format. 
	 * (Accepted types: {@link String}, {@link Integer})
	 * @param format This value is needed for parsing in case the object is a {@code String} or an {@code Integer}.
	 * @param clazz It is the output's class type.
	 * @return The formatted quarter's end date/time. Return {@code null} if the object is 
	 * not a {@code String} or {@code Integer}.
	 * @throws ParseException If object parameter is not in {@code DEFAULT_DATEFORMAT} format. 
	 * (Assuming that the object is a {@code String} or an {@code Integer}).
	 * @since v1.0
	 * @see #getQuarterEndDate(Date, Class)
	 * 
	 */
	public static <T> T getQuarterEndDate(Object object, String format, Class<T> clazz) throws ParseException
	{
		SimpleDateFormat df = new SimpleDateFormat(format);
		if (object instanceof String || object instanceof Integer)
			return getQuarterEndDate(df.parse(String.valueOf(object)), clazz);
		return null;
	}
	
	/**
	 * Used to get the quarter's end date of the given date/time.
	 * 
	 * <p>
	 * <strong>Example:</strong></br></br>
	 * 
	 * Let: <code>new Date() = "20180719"</code></br></br>
	 * 
	 * <code>System.out.println(DateUtil.getQuarterEndDate(new Date(), String.class));</code></br></br>
	 * <u>Output</u>: <code>"20180930"</code>
	 * </p>
	 * 
	 * @param date It is the basis(date) to get the quarter's end date.
	 * @param clazz It is the output's class type.
	 * @return The quarter's end date.
	 * @since v1.0
	 * @see #formatDate(Date, Class)
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getQuarterEndDate(Date date, Class<T> clazz)
	{
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int factor = 0;
		int month = calendar.get(Calendar.MONTH);
		if (month == Calendar.JANUARY
			|| month == Calendar.APRIL
			|| month == Calendar.JULY
			|| month == Calendar.OCTOBER)
			factor = 2;
		else if (
			month == Calendar.FEBRUARY
			|| month == Calendar.MAY
			|| month == Calendar.AUGUST
			|| month == Calendar.NOVEMBER) 
			factor = 1;
		else
			factor = 0;

		calendar.add(Calendar.MONTH, factor);
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		if (clazz == Date.class)
			return (T) calendar.getTime();
		return formatDate(calendar.getTime(), clazz);
	}
	
	/**
	 * Used to get the quarter's number of the given date. 
	 * 
	 * <p>
	 * <strong>Examples:</strong></br></br>
	 * 
	 * Let: <code>new Date() = "20180719"</code></br></br>
	 * 
	 * <i>1) If the object is in the {@code Date} format.</i></br></br>
	 * <code>System.out.println(DateUtil.getQuarterNum(new Date()));</code></br></br>
	 * <u>Output</u>: <code>3</code>
	 * 
	 * </br></br></br>
	 * 
	 * <i>2) If the object is in the {@code String} format.</i></br></br>
	 * <code>System.out.println(DateUtil.getQuarterNum("20180718"));</code></br></br>
	 * <u>Output</u>: <code>3</code>
	 * 
	 * </br></br></br>
	 * 
	 * <i>3) If the object is in the {@code Integer} format.</i></br></br>
	 * <code>System.out.println(DateUtil.getQuarterNum(20180214));</code></br></br>
	 * <u>Output</u>: <code>1</code>
	 * </p>
	 * 
	 * @param object It is the basis(date) to get the quarter's number. If the object is a 
	 * {@code String} or an {@code Integer}, the value must be in {@link #DEFAULT_DATEFORMAT} format. 
	 * (Accepted types: {@link Date}, {@link String}, {@link Integer})
	 * @return <b>{@code int}</b> - the quarter's number. Return {@code -1} if the object is not a {@code Date}, 
	 * {@code String} or {@code Integer}.
	 * @throws ParseException If object parameter is not in {@code DEFAULT_DATEFORMAT} format. 
	 * (Assuming that the object is a {@code String} or an {@code Integer}).
	 * @since v1.0
	 */
	public static int getQuarterNum(Object object) throws ParseException
	{
		Date date;
		if (object instanceof Date)
			date = (Date) object;
		else if (object instanceof String || object instanceof Integer)
			date = sdf.parse(String.valueOf(object));
		else 
			return -1;

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		return (month / 3) + 1;
	}
	
}
