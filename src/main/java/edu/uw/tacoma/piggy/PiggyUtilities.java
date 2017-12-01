package edu.uw.tacoma.piggy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * The class for project utilities
 * 
 * @author Varik Hoang
 */
public class PiggyUtilities
{
	/**
	 * The driver classs
	 */
	private static final String DRIVER_CLASS = "net.ucanaccess.jdbc.UcanaccessDriver";
	
	/**
	 * The connection string
	 */
	private static final String	DRIVER_PATH	= "jdbc:ucanaccess://";

	/**
	 * The driver to access into the data
	 */
	private static String driver;

	private static boolean done = false;
	
	/**
	 * The method returns the driver string
	 * @return the driver string
	 */
	private static String getDriver()
	{
		if (!done)
		{
			try
			{
				Class.forName(DRIVER_CLASS);
				done = true;
			}
			catch (ClassNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (driver == null)
		{
			StringBuilder builder = new StringBuilder();

			builder.append(DRIVER_PATH);
			if (getOperatingSystemType() != OSType.Windows) builder.append("/");
			builder.append(PiggyUtilities.class.getResource("/").toString().substring(6));
			builder.append("db/database.mdb");

			driver = builder.toString();
		}

		return driver;
	}
	
	/**
	 * The method returns the connection
	 * @return
	 */
	public static Connection getConnection()
	{
		try
		{
			System.out.println(getDriver());
			return DriverManager.getConnection(getDriver());
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	public static OSType getOperatingSystemType()
	{
		String os = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);

		if ((os.indexOf("mac") >= 0) || (os.indexOf("darwin") >= 0)) return OSType.MacOS;
		else if (os.indexOf("win") >= 0) return OSType.Windows;
		else if (os.indexOf("nux") >= 0) return OSType.Linux;

		return OSType.Other;
	}

	public enum OSType
	{
		Windows, MacOS, Linux, Other
	};
	
	/**
	 * The date formatter
	 */
	public static final DateFormat DateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
