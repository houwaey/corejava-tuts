package com.library.utils;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * Used to format, validate and get data.
 * 
 * @see Map
 * @see HashMap
 * @see File
 * @version %I%, %G% 
 * @author Houwaey (Collabera)
 * 
 */
public final class Util {
	
	/*
	 * (non-javadoc)
	 * Initialize all wrapper types.
	 */
	private static final Map<Class<?>,Class<?>> WRAPPER_TYPES = initWrapperTypes();
	
	/*
	 * (non-javadoc)
	 * Map the primitive and wrapper types.
	 */
	private static Map<Class<?>,Class<?>> initWrapperTypes()
	{
		HashMap<Class<?>,Class<?>> ret = new HashMap<Class<?>,Class<?>>();
		ret.put(boolean.class  , Boolean.class);
		ret.put(char.class     , Character.class);
		ret.put(byte.class     , Byte.class);
		ret.put(short.class    , Short.class);
		ret.put(int.class      , Integer.class);
		ret.put(long.class     , Long.class);
		ret.put(float.class    , Float.class);
		ret.put(double.class   , Double.class);
		ret.put(void.class     , Void.class);
		return ret;
	}
	
	/*
	 * (non-javadoc)
	 * Private constructor to prevent instantiation.
	 */
	private Util()
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * Validates the input data if {@code null}. 
	 * If {@code null}, it will return the {@code default} value provided.
	 * 
	 * @param data The input data to be validated.
	 * @param defaultValue The value to be returned in case the data is {@code null}.
	 * @return {@code String} - either input data (if data is not {@code null}) or defaultValue (if data is {@code null});
	 * @since v1.0
	 * 
	 */
	public static <T> T isNull(T data, T defaultValue)
	{
		return data == null ? defaultValue : data;
    }
	
	/**
	 * Used the get the current working directory / {@code classpath}.
	 * 
	 * @return {@code String} - working directory based on {@code classpath}.
	 * @since v1.0
	 * 
	 */
	public static String getWorkingDirectory() 
	{
		return (
					new File(
							System.getProperty("java.class.path")
									.split(":")[0]
							)
				).getAbsoluteFile()
					.getParentFile()
						.getPath();
	}
	
	/**
	 * Used to take an Object of one particular type and 
	 * "turning it into" another Object type.
	 * 
	 * <p>
	 * <strong>Example:</strong></br></br>
	 * <code>System.out.println(Util.cast("12345", int.class));</code></br></br>
	 * <u>Output</u>: <code>12345</code>
	 * </p>
	 * 
	 * @param obj The input object to be casted.
	 * @param klass Output class type.
	 * @return {@code Object} - an object casted to the type given.
	 * @since v1.0
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static <E> E cast(Object obj, Class<E> klass)
	{
		Class<E> wrapper = (Class<E>) WRAPPER_TYPES.get(klass);
		if(wrapper!= null) klass = wrapper;
		if(Number.class.isAssignableFrom(klass))
		{
			Constructor<E> m = null;
			try
			{
				m = klass.getConstructor(String.class);
				if(obj != null)
				{
					return (E) m.newInstance(obj.toString());
				}
				else
				{
					return (E) m.newInstance("0");
				}
			}
			catch (Exception e)
			{
				Logger.LogServer(e);
				try
				{
					return (E) m.newInstance("0");
				}
				catch (Exception e1)
				{
					Logger.LogServer(e1);
				}
			}
		}
		else if(String.class.isAssignableFrom(klass))
		{
			if(obj != null)
			{
				return (E) obj.toString();
			}
			return (E) "";
		}
		return (E) obj;
	}
	
}
