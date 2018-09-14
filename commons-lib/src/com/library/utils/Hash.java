package com.library.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>Used to {@code hash} a {@code String}.</p>
 * 
 * @see MessageDigest
 * @version %I%, %G% 
 * @author Houwaey (Collabera)
 */
public final class Hash
{

	/*
	 * (non-javadoc)
	 * Private constructor to prevent instantiation.
	 */
	private Hash()
	{
		throw new UnsupportedOperationException();
	}
	
	private static ThreadLocal<MessageDigest> md2 = new ThreadLocal<MessageDigest>() 
	{
		@Override
		protected MessageDigest initialValue()
		{
			try
			{
				return MessageDigest.getInstance("MD2");
			}
			catch (NoSuchAlgorithmException e)
			{
				e.printStackTrace();
			}
			return null;
		}
	};
	
	private static ThreadLocal<MessageDigest> md5 = new ThreadLocal<MessageDigest>() 
	{
		@Override
		protected MessageDigest initialValue()
		{
			try
			{
				return MessageDigest.getInstance("MD5");
			}
			catch (NoSuchAlgorithmException e)
			{
				e.printStackTrace();
			}
			return null;
		}
	};
	
	private static ThreadLocal<MessageDigest> sha1 = new ThreadLocal<MessageDigest>() 
	{
		@Override
		protected MessageDigest initialValue()
		{
			try
			{
				return MessageDigest.getInstance("SHA-1");
			}
			catch (NoSuchAlgorithmException e)
			{
				e.printStackTrace();
			}
			return null;
		}
	};
	
	private static ThreadLocal<MessageDigest> sha256 = new ThreadLocal<MessageDigest>() 
	{
		@Override
		protected MessageDigest initialValue()
		{
			try
			{
				return MessageDigest.getInstance("SHA-256");
			}
			catch (NoSuchAlgorithmException e)
			{
				e.printStackTrace();
			}
			return null;
		}
	};
	
	private static ThreadLocal<MessageDigest> sha384 = new ThreadLocal<MessageDigest>() 
	{
		@Override
		protected MessageDigest initialValue()
		{
			try
			{
				return MessageDigest.getInstance("SHA-384");
			}
			catch (NoSuchAlgorithmException e)
			{
				e.printStackTrace();
			}
			return null;
		}
	};
	
	private static ThreadLocal<MessageDigest> sha512 = new ThreadLocal<MessageDigest>() 
	{
		@Override
		protected MessageDigest initialValue()
		{
			try
			{
				return MessageDigest.getInstance("SHA-512");
			}
			catch (NoSuchAlgorithmException e)
			{
				e.printStackTrace();
			}
			return null;
		}
	};
	
	/**
	 * Used to hash string into <code>MD2</code> algorithm. The value is converted into byte array using 
	 * <code>UTF-8</code> encoding before being digested.
	 * 
	 * <p>
	 * <strong>Example:</strong></br></br>
	 * <code>
	 * System.out.println(Hash.hashMD2("Hello World!"));
	 * </code></br></br>
	 * <u>Output</u>: <code>"315F7C67223F01FB7CAB4B95100E872E"</code>
	 * </p>
	 * 
	 * @param value The input string or message to be hashed.
	 * @return {@code String} - Hashed value using (<code>MD2</code> algorithm).
	 * @throws UnsupportedEncodingException In case the encoding string provided is incorrect.
	 * @since v1.0
	 * @see Hex#encode(byte[])
	 * 
	 */
	public static String hashMD2(String value) throws UnsupportedEncodingException
	{
		return Hex.encode(md2.get().digest(value.getBytes("UTF-8")));
	}

	/**
	 * Used to hash string into <code>MD5</code> algorithm. The value is converted into byte array using 
	 * <code>UTF-8</code> encoding before being digested.
	 * 
	 * <p>
	 * <strong>Example:</strong></br></br>
	 * <code>
	 * System.out.println(Hash.hashMD2("Hello World!"));
	 * </code></br></br>
	 * <u>Output</u>: <code>"ED076287532E86365E841E92BFC50D8C"</code>
	 * </p>
	 * 
	 * @param value The input string or message to be hashed.
	 * @return {@code String} - Hashed value using (<code>MD5</code> algorithm).
	 * @throws UnsupportedEncodingException In case the encoding string provided is incorrect.
	 * @since v1.0
	 * @see Hex#encode(byte[])
	 * 
	 */
	public static String hashMD5(String value) throws UnsupportedEncodingException
	{
		return Hex.encode(md5.get().digest(value.getBytes("UTF-8")));
	}
	
	/**
	 * Used to hash string into <code>SHA-1</code> algorithm. The value is converted into byte array using 
	 * <code>UTF-8</code> encoding before being digested.
	 * 
	 * <p>
	 * <strong>Example:</strong></br></br>
	 * <code>
	 * System.out.println(Hash.hashSHA1("Hello World!"));
	 * </code></br></br>
	 * <u>Output</u>: <code>"2EF7BDE608CE5404E97D5F042F95F89F1C232871"</code>
	 * </p>
	 * 
	 * @param value The input string or message to be hashed.
	 * @return {@code String} - Hashed value using (<code>SHA-1</code> algorithm).
	 * @throws UnsupportedEncodingException In case the encoding string provided is incorrect.
	 * @since v1.0
	 * @see Hex#encode(byte[])
	 * 
	 */
	public static String hashSHA1(String value) throws UnsupportedEncodingException
	{
		return Hex.encode(sha1.get().digest(value.getBytes("UTF-8")));
	}
	
	/**
	 * Used to hash string into <code>SHA-256</code> algorithm. The value is converted into byte array using 
	 * <code>UTF-8</code> encoding before being digested.
	 * 
	 * <p>
	 * <strong>Example:</strong></br></br>
	 * <code>
	 * System.out.println(Hash.hashSHA256("Hello World!"));
	 * </code></br></br>
	 * <u>Output</u>: <code>"7F83B1657FF1FC53B92DC18148A1D65DFC2D4B1FA3D677284ADDD200126D9069"</code>
	 * </p>
	 * 
	 * @param value The input string or message to be hashed.
	 * @return {@code String} - Hashed value using (<code>SHA-256</code> algorithm).
	 * @throws UnsupportedEncodingException In case the encoding string provided is incorrect.
	 * @since v1.0
	 * @see Hex#encode(byte[])
	 * 
	 */
	public static String hashSHA256(String value) throws UnsupportedEncodingException
	{
		return Hex.encode(sha256.get().digest(value.getBytes("UTF-8")));
	}
	
	/**
	 * Used to hash string into <code>SHA-384</code> algorithm. The value is converted into byte array using 
	 * <code>UTF-8</code> encoding before being digested.
	 * 
	 * <p>
	 * <strong>Example:</strong></br></br>
	 * <code>
	 * System.out.println(Hash.hashSHA384("Hello World!"));
	 * </code></br></br>
	 * <u>Output</u>: <code>"BFD76C0EBBD006FEE583410547C1887B0292BE76D582D96C242D2A792723E3FD6FD061F9D5CFD13B8F961358E6ADBA4A"</code>
	 * </p>
	 * 
	 * @param value The input string or message to be hashed.
	 * @return {@code String} - Hashed value using (<code>SHA-384</code> algorithm).
	 * @throws UnsupportedEncodingException In case the encoding string provided is incorrect.
	 * @since v1.0
	 * @see Hex#encode(byte[])
	 * 
	 */
	public static String hashSHA384(String value) throws UnsupportedEncodingException
	{
		return Hex.encode(sha384.get().digest(value.getBytes("UTF-8")));
	}
	
	/**
	 * Used to hash string into <code>SHA-512</code> algorithm. The value is converted into byte array using 
	 * <code>UTF-8</code> encoding before being digested.
	 * 
	 * <p>
	 * <strong>Example:</strong></br></br>
	 * <code>
	 * System.out.println(Hash.hashSHA512("Hello World!"));
	 * </code></br></br>
	 * <u>Output</u>: <code>"861844D6704E8573FEC34D967E20BCFEF3D424CF48BE04E6DC08F2BD58C729743371015EAD891CC3CF1C9D34B49264B510751B1FF9E537937BC46B5D6FF4ECC8"</code>
	 * </p>
	 * 
	 * @param value The input string or message to be hashed.
	 * @return {@code String} - Hashed value using (<code>SHA-512</code> algorithm).
	 * @throws UnsupportedEncodingException In case the encoding string provided is incorrect.
	 * @since v1.0
	 * @see Hex#encode(byte[])
	 * 
	 */
	public static String hashSHA512(String value) throws UnsupportedEncodingException
	{
		return Hex.encode(sha512.get().digest(value.getBytes("UTF-8")));
	}
	
}
