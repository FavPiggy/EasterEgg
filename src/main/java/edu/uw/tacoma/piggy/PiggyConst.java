package edu.uw.tacoma.piggy;

public class PiggyConst
{
	public static final String DRIVER_PATH = "jdbc:relique:csv:" + 
			PiggyConst.class.getResource("/").toString().substring(6) + "db";
}
