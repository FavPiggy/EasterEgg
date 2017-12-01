package edu.uw.tacoma.piggy;

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
	 * The connection string
	 */
	private static final String	DRIVER_PATH	= "jdbc:relique:csv:";

	/**
	 * The driver to access into the data
	 */
	private static String		driver;

	public static String getDriver()
	{
		if (driver == null)
		{
			StringBuilder builder = new StringBuilder();

			builder.append(DRIVER_PATH);
			if (getOperatingSystemType() != OSType.Windows) builder.append("/");
			builder.append(PiggyUtilities.class.getResource("/").toString().substring(6));
			builder.append("db");

			driver = builder.toString();
		}

		return driver;
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
