package Utilities;

import java.util.Date;

//Class to create Dynamic file name
public class TimeStamp {
	public static String getTimeStamps() {
		Date date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}
}