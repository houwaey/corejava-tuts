package com.library.utils;

import java.io.ByteArrayOutputStream;

/**
 * <p>Used for {@code Hexadecimal} encoding / decoding.</p>
 * 
 * @see StringBuilder
 * @see ByteArrayOutputStream
 * @version %I%, %G% 
 * @author Houwaey (Collabera)
 */
public final class Hex
{
	
	private static final char hexTable[] = "0123456789ABCDEF".toCharArray();
	private static int[]  hexByte = new int[128];
	
	static
	{
		for (int i=0; i<hexTable.length; i++)
		{
			hexByte[hexTable[i]] = i;
		}
	}
	
	/*
	 * (non-javadoc)
	 * Private constructor to prevent instantiation.
	 */
	private Hex()
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Used to encode byte array into hexadecimal string.
	 * 
	 * <p>
	 * <strong>Example:</strong></br></br>
	 * <code>
	 * System.out.println(Hex.encode("Hello World!".getBytes("UTF-8")));
	 * </code></br></br>
	 * <u>Output</u>: <code>"48656C6C6F20576F726C6421"</code>
	 * </p>
	 * 
	 * @param in Byte array to be encoded.
	 * @return {@code String} - hexadecimal encoded string.
	 * @since v1.0
	 * 
	 */
	public static String encode(byte[] in)
	{
		StringBuilder br = new StringBuilder();
        try
        {
        	for(byte b : in)
	        {
	        	br.append(hexTable[(b & 0xff) >> 4]);
	        	br.append(hexTable[(b & 0x0f)]);
	        }
        }
        catch(Exception e) {}
        return br.toString();
	}
	
	/**
	 * Used to decode hexadecimal string into byte array.
	 * 
	 * <p>
	 * <strong>Example:</strong></br></br>
	 * <code>
	 * byte[] var = Hex.decode("48656C6C6F20576F726C6421"); 
	 * </code></br></br></br>
	 * <i>The value of the {@code var} will be:</i> </br></br>
	 * <code>
	 * new byte[]{(byte) 0x48, (byte) 0x65, (byte) 0x6C, (byte) 0x6C, 
	 * (byte) 0x6F, (byte) 0x20, (byte) 0x57, (byte) 0x6F, 
	 * (byte) 0x72, (byte) 0x6C, (byte) 0x64, (byte) 0x21};
	 * </code>
	 * </p>
	 * 
	 * @param in Value or string to be decoded.
	 * @return Decoded byte array.
	 * @since v1.0
	 * 
	 */
	public static byte[] decode(String in)
	{
		final int mask = 0xff;
    	ByteArrayOutputStream data = new ByteArrayOutputStream();
    	try
    	{
	    	for(int i = 0; i < in.length();)
	    	{
	    		int a = hexByte[in.charAt(i++)];
	    		int b = hexByte[in.charAt(i++)];
	    		data.write((byte)(((a << 4) | b) & mask));
	    	}
    	}
    	catch(Exception e) {}
        return data.toByteArray();
	}
	
	/**
	 * Commonly used for printing/debugging a byte array into string representation. So in case you need
	 * the actual byte array of a {@code value} you can use this method.
	 * 
	 * <p>
	 * <strong>Example:</strong></br></br>
	 * <code>
	 * System.out.println(Hex.printBytes(Hex.decode("48656C6C6F20576F726C6421")));
	 * </code></br></br>
	 * <u>Output</u>: </br></br>
	 * <code>"byte[] {name} = new byte[]{(byte) 0x48, (byte) 0x65, (byte) 0x6C, (byte) 0x6C, 
	 * (byte) 0x6F, (byte) 0x20, (byte) 0x57, (byte) 0x6F, (byte) 0x72, (byte) 0x6C, 
	 * (byte) 0x64, (byte) 0x21};"</code>
	 * </p>
	 * 
	 * @param bytes The byte array to be printed.
	 * @return {@code String} - the actual byte array into string representation.
	 * @since v1.0
	 * 
	 */
	public static String printBytes(byte[] bytes)
	{
    	StringBuilder br = new StringBuilder("byte[] {name} = new byte[]{");
    	int counter = 0;
        for(byte b : bytes )
        {
        	if(counter == 8) br.append("\r\n");
        	counter = counter % 8 ;
        	br.append("(byte) 0x");
        	br.append(hexTable[(b & 0xff) >> 4]);
        	br.append(hexTable[(b & 0x0f)]);
        	br.append(", ");
        	counter++;
        }
        br.deleteCharAt(br.length() - 1);
        br.deleteCharAt(br.length() - 1);
        br.append("};");
        return br.toString();
    }
	
}
