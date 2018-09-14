package com.library.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Used for logging string or throwable.</p>
 * 
 * @see File
 * @see FileOutputStream
 * @see Writer
 * @see OutputStreamWriter
 * @see BufferedWriter
 * @see PrintWriter
 * @see StringWriter
 * @see Util
 * @version %I%, %G% 
 * @author Houwaey (Collabera)
 */
public class Logger {
	
	private static int id = 0;

	private static File logServerFile = new File(Util.getWorkingDirectory() + "/Log/Server");
	private static File logDbFile = new File(Util.getWorkingDirectory() + "/Log/DB");

	/*
	 * (non-javadoc)
	 * Private constructor to prevent instantiation.
	 */
	private Logger()
	{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Used to log string or message. It is advisable to use only if the message is related 
	 * to the application error. The directory/location of the log file is depends on the 
	 * {@link #logServerFile} configuration.
	 * 
	 * @param msg Input string or message to be logged.
	 * @since v1.0
	 * 
	 */
	public static void LogServer(String msg)
	{
		synchronized(Logger.logServerFile)
		{
			Log(Logger.logServerFile.getAbsolutePath() + "/" +  getLogFilename(),msg);
		}
	}

	/**
	 * Used to log the full stacktrace of the exception. It is advisable to use only if 
	 * the message is related to the application error. The directory/location of the log file is depends on the 
	 * {@link #logServerFile} configuration.
	 * 
	 * @param e The exception to be logged.
	 * @since v1.0
	 * 
	 */
	public static void LogServer(Throwable e)
	{
		synchronized(Logger.logServerFile)
		{
			Log(Logger.logServerFile.getAbsolutePath() + "/" +  getLogFilename(),Logger.GetStackTrace(e));
		}
	}

	/**
	 * Used to log a string or message along with the full stacktrace of the exception. 
	 * It is advisable to use only if the message is related to the application error. 
	 * The directory/location of the log file is depends on the 
	 * {@link #logServerFile} configuration.
	 * 
	 * @param msg String or message to be logged.
	 * @param e The exception to be logged.
	 * @since v1.0
	 * 
	 */
	public static void LogServer(String msg, Throwable e)
	{
		synchronized(Logger.logServerFile)
		{
			Log(Logger.logServerFile.getAbsolutePath() + "/" +  getLogFilename(), msg + "~" + Logger.GetStackTrace(e));
		}
	}
	
	/**
	 * Used to log string or message. It is advisable to use only if the message is related 
	 * to the database error. The directory/location of the log file is depends on the 
	 * {@link #logDbFile} configuration.
	 * 
	 * @param msg Input string or message to be logged.
	 * @since v1.0
	 * 
	 */
	public static void LogDb(String msg)
	{
		synchronized(Logger.logDbFile)
		{
			Log(Logger.logDbFile.getAbsolutePath() + "/" +  getLogFilename(),msg);
		}
	}
	
	/**
	 * Used to log the full stacktrace of the exception. It is advisable to use only if 
	 * the message is related to the database error. The directory/location of the log file is depends on the 
	 * {@link #logDbFile} configuration.
	 * 
	 * @param e The exception to be logged.
	 * @since v1.0
	 * 
	 */
	public static void LogDb(Throwable e)
	{
		synchronized(Logger.logDbFile)
		{
			Log(Logger.logDbFile.getAbsolutePath() + "/" +  getLogFilename(), Logger.GetStackTrace(e));
		}
	}

	/**
	 * Used to log a string or message along with the full stacktrace of the exception. 
	 * It is advisable to use only if the message is related to the database error. 
	 * The directory/location of the log file is depends on the 
	 * {@link #logDbFile} configuration.
	 * 
	 * @param msg String or message to be logged.
	 * @param e The exception to be logged.
	 * @since v1.0
	 * 
	 */
	public static void LogDb(String msg, Throwable e)
	{
		synchronized(Logger.logDbFile)
		{
			Log(Logger.logDbFile.getAbsolutePath() + "/" +  getLogFilename(), msg + "~" +  Logger.GetStackTrace(e));
		}
	}
	
	private static String getTimeStamp()
	{
		SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss.SSS");
		return f.format(new Date()); 
	}
	
	/**
	 * Used to get the log's file name.
	 * 
	 * <p><strong>Example:</strong> <code>20180719@1200_0.log</code></p>
	 * 
	 * @return {@code String} - logs file name.
	 * @since v1.0
	 * 
	 */
	public static String getLogFilename()
	{
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd'@'HH'00'");
		return f.format(new Date()) + "_" + id + ".log"; 
	}
	
	/**
	 * Used to log/write a message into a file (<code>string file path</code>).
	 * 
	 * @param path A string file path of the log to use.
	 * @param msg A string message to write on the specified log file.
	 * @since v1.0
	 * 
	 */
	public static void Log(String path, String msg)
	{
		Logger.Log(new File(path), msg);
	}
	
	/**
	 * Used to log/write a message into a file (<code>File</code> format).
	 * 
	 * @param path Log file to use.
	 * @param msg A string message to write on the specified log file.
	 * @since v1.0
	 * 
	 */
	public static void Log(File log, String msg)
	{
		try
		{
			if(!log.getParentFile().isDirectory())
				log.getParentFile().mkdirs();
			log.setReadable(true, false);
			OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(log, true), "UTF-8");
			BufferedWriter fbw = new BufferedWriter(writer);
			fbw.write(getTimeStamp() + " " + msg + "\r\n");
			fbw.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Used to get the full stacktrace of the {@code Exception}.
	 * 
	 * @param throwable The actual exception to log.
	 * @return {@code String} - full stacktrace of the exception in {@code String} representation.
	 * @since v1.0
	 * 
	 */
	public static String GetStackTrace(Throwable throwable)
	{
		Writer writer = null;
		PrintWriter printWriter = null;
		String stackTrace = "";
		try
		{
			writer = new StringWriter();
			printWriter = new PrintWriter(writer);
			throwable.printStackTrace(printWriter);
			stackTrace = writer.toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(writer != null)
				try
				{
					writer.close();
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			if(printWriter != null) printWriter.close();
		}
		return stackTrace;
	}
	
}
