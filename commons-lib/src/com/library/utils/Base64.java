package com.library.utils;

import java.io.ByteArrayOutputStream;

/**
 * <p>Used for {@code Base64} encoding / decoding.</p>
 * 
 * @see StringBuilder
 * @see ByteArrayOutputStream
 * @version %I%, %G% 
 * @author Houwaey (Collabera)
 */
public final class Base64
{
	/*
	 * (non-javadoc)
	 * Table reference for base64 encoding/decoding.
	 */
	private static final char base64Table[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
	
	private static final int encodeTable[] =
	{
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 55, 48,
        57, 50, 49, 52, 51, 54, 53, 56, 0, 0,
        0, 0, 0, 0, 0, 87, 74, 86, 65, 71,
        77, 81, 85, 89, 84, 73, 68, 79, 88, 83,
        76, 70, 66, 80, 90, 82, 67, 69, 72, 75,
        78, 0, 0, 0, 0, 0, 0, 87, 74, 86,
        65, 71, 77, 81, 85, 89, 84, 73, 68, 79,
        88, 83, 76, 70, 66, 80, 90, 82, 67, 69,
        72, 75, 78, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0
    };
	private static int[]  base64Byte = new int[128];
	private static int[]  decodeByte = new int[128];
	
	static
	{
		for (int i=0; i<base64Table.length; i++)
		{
			base64Byte[base64Table[i]] = i;
		}
		
		for (int i=0; i<encodeTable.length; i++)
		{
			decodeByte[encodeTable[i]] = i;
		}
	}
	
	/*
	 * (non-javadoc)
	 * Private constructor to prevent instantiation.
	 */
	private Base64()
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Used to encode({@code Base64}) byte array into string.
	 * 
	 * <p>
	 * <strong>Example:</strong></br></br>
	 * <code>System.out.println(Base64.encode("Hello World!".getBytes("UTF-8")));</code></br></br>
	 * <u>Output</u>: <code>"SGVsbG8gV29ybGQ="</code>
	 * </p>
	 * 
	 * @param in Input byte array to be encoded.
	 * @return {@code String} - encoded base64 string.
	 * @since v1.0
	 * 
	 */
	public static String encode(byte in[])
	{
		StringBuilder br = new StringBuilder();
        int offset = 0;
        int len = in.length - (in.length % 3);
        int padd = (3 - in.length % 3) % 3;
        while(offset < len)
        {
        	br.append(base64Table[(in[offset] & 0xff) >> 2]);
        	br.append(base64Table[in[offset++] << 4 & 0x3f | (in[offset] & 0xff) >> 4]);
        	br.append(base64Table[in[offset++] << 2 & 0x3f | (in[offset] & 0xff) >> 6]);
        	br.append(base64Table[in[offset++] & 0x3f]);
        }
        switch(padd)
        {
	        case 1 :
	        	br.append(base64Table[(in[offset] & 0xff) >> 2]);
	        	br.append(base64Table[in[offset++] << 4 & 0x3f | (in[offset] & 0xff) >> 4]);
	        	br.append(base64Table[in[offset++] << 2 & 0x3f]);
	        	br.append("=");
	        	break;
	        case 2 :
	        	br.append(base64Table[(in[offset] & 0xff) >> 2]);
	        	br.append(base64Table[in[offset++] << 4 & 0x3f]);
	        	br.append("==");
	        	break;
        }
        return br.toString();
	}
	
	/**
	 * Used to decode({@code Base64}) string into byte array.
	 * 
	 * <p>
	 * <strong>Example:</strong></br></br>
	 * <code>System.out.println(new String(Base64.decode("SGVsbG8gV29ybGQ=")));</code></br></br>
	 * <u>Output</u>: <code>"Hello World"</code>
	 * </p>
	 * 
	 * @param in Input string to be decoded.
	 * @return {@code String} - decoded byte array.
	 * @since v1.0
	 * 
	 */
	public static byte[] decode(String in)
	{
		ByteArrayOutputStream data = new ByteArrayOutputStream();
    	final int mask = 0xff;
    	int padd = in.endsWith( "==" ) ? 2 : in.endsWith( "=" ) ? 1 : 0;
    	int len = in.length() - (padd > 0 ? 4 : 0);
    	int i = 0;
    	while(i < len)
    	{
    		int a = base64Byte[in.charAt(i++)];
    		int b = base64Byte[in.charAt(i++)];
    		int c = base64Byte[in.charAt(i++)];
    		int d = base64Byte[in.charAt(i++)];
    		data.write((byte)(((a << 2) | (b >> 4)) & mask));
    		data.write((byte)(((b << 4) | (c >> 2)) & mask));
    		data.write((byte)(((c << 6) | d) & mask));
    	}
    	switch(padd)
    	{
	    	case 1:
	    		int a = base64Byte[in.charAt(i++)];
	    		int b = base64Byte[in.charAt(i++)];
	    		int c = base64Byte[in.charAt(i++)];
	    		data.write((byte)(((a << 2) | (b >> 4)) & mask));
	    		data.write((byte)(((b << 4) | (c >> 2)) & mask));
	    		break;
	    	case 2:
	    		int e = base64Byte[in.charAt(i++)];
	    		int f = base64Byte[in.charAt(i++)];
	    		data.write((byte)(((e << 2) | (f >> 4)) & mask));
	    		break;
    	}
        return data.toByteArray();
	}
	
}
