package java.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class ModelUtilities {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	
	public static Timestamp getDateTime() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return new Timestamp(cal.getTimeInMillis());
	}

	public static Timestamp addDays(int period) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, period); // minus number would decrement the days
		return new Timestamp(cal.getTimeInMillis());
	}
	
}
