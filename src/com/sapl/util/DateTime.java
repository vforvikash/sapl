package com.sapl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateTime {
	protected SimpleDateFormat dateFormat;
	protected static long dateTime;
	protected static Calendar calendar = new GregorianCalendar();
	protected static Date currentDate = new Date();

	protected static final String RFC_1123_PATTERN = "EEE, dd MMM yyyy HH:mm:ss 'GMT'"; //$NON-NLS-1$
	protected static final String RFC_850_PATTERN = "E, dd-MMM-yyyy HH:mm:ss 'GMT'"; //$NON-NLS-1$
	protected static final String ASCTIME_PATTERN = "EEE MMM dd HH:mm:ss yyyy"; //$NON-NLS-1$
	protected static final String ISO_8601_UTC_PATTERN = "yyyy-MM-dd'T'HH:mm:ss'Z'"; //$NON-NLS-1$
	protected static final String ISO_8601_PATTERN = "yyyy-MM-dd'T'HH:mm:ssz"; //$NON-NLS-1$
	protected static final String ISO_8601_UTC_MILLIS_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS"; //$NON-NLS-1$
	protected static final String ISO_8601_MILLIS_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSz"; //$NON-NLS-1$

	public DateTime() {
		this(System.currentTimeMillis());
		calendar.setTime(currentDate);
	}

	/**
	 * Starts this object from a java long format (milliseconds).
	 */
	public DateTime(long date) {
		setDateTime(date);
		dateFormat = new SimpleDateFormat();
		dateFormat.setCalendar(Calendar.getInstance(TimeZone.getTimeZone("UTC"), Locale.US)); //$NON-NLS-1$
	}

	public boolean after(DateTime other) {
		return getDateTime() > other.getDateTime();
	}

	public boolean before(DateTime other) {
		return getDateTime() < other.getDateTime();
	}

	public boolean equals(DateTime other) {
		return getDateTime() == other.getDateTime();
	}

	/**
	 * Milliseconds since 1 January 1970 0:00 UTC.
	 */
	public long getDateTime() {
		return dateTime;
	}

	public int getMilliseconds() {
		return (int) (getDateTime() % 1000);
	}

	/**
	 * Sets the date and time from a java long format (milliseconds).
	 */
	public void setDateTime(long dateTimeVal) {
		dateTime = dateTimeVal;
	}

	/**
	 * Do nothing if date format is not supported
	 */
	public void setDateTime(String date) {
		String[] patterns = {RFC_1123_PATTERN, ISO_8601_UTC_PATTERN, ISO_8601_UTC_MILLIS_PATTERN, ISO_8601_PATTERN, ISO_8601_MILLIS_PATTERN, RFC_850_PATTERN, ASCTIME_PATTERN};
		for (int i = 0; i < patterns.length; i++) {
			if (setDateTime(date, patterns[i]))
				break;
		}
	}
	
	public Date increaseDaysInDate(Date dateToIncrease, int days){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dateToIncrease);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		/*if(days==44){
			Date increasedDaysInDate = new Date(((calendar.get(Calendar.MONTH)+2)+"/"+(calendar.get(Calendar.DAY_OF_MONTH)+14)+"/"+calendar.get(Calendar.YEAR)).toString());
			return increasedDaysInDate;
		}else{
			Date increasedDaysInDate = new Date(((calendar.get(Calendar.MONTH)+1)+"/"+(calendar.get(Calendar.DAY_OF_MONTH)+days)+"/"+calendar.get(Calendar.YEAR)).toString());
			return increasedDaysInDate;
		}*/
		return calendar.getTime();
	}
	
	public Date increaseMonthsInDate(Date dateToIncrease, int months){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dateToIncrease);
		calendar.add(Calendar.MONTH, months);
		/*Date increasedMnthInDate = new Date(((calendar.get(Calendar.MONTH)+1+months)+"/"+(calendar.get(Calendar.DAY_OF_MONTH))+"/"+calendar.get(Calendar.YEAR)).toString());
		return increasedMnthInDate;*/
		return calendar.getTime();
	}
	
	public Date increaseDaysMonthsInDate(Date dateToIncrease, int days, int months){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dateToIncrease);
		calendar.add(Calendar.MONTH, months);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		/*Date increasedDaysMnthsInDate = new Date(((calendar.get(Calendar.MONTH)+1+months)+"/"+(calendar.get(Calendar.DAY_OF_MONTH)+days)+"/"+calendar.get(Calendar.YEAR)).toString());
		return increasedDaysMnthsInDate;*/
		return calendar.getTime();
	}
	
	public Date increaseYearsInDate(Date dateToIncrease, int years){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dateToIncrease);
		calendar.add(Calendar.YEAR, years);
		/*Date increasedYrInDate = new Date(((calendar.get(Calendar.MONTH)+1)+"/"+(calendar.get(Calendar.DAY_OF_MONTH))+"/"+(calendar.get(Calendar.YEAR)+years)).toString());
		return increasedYrInDate;*/
		return calendar.getTime();
	}
	
	public Date increaseDaysMonthsYearsInDate(Date dateToIncrease, int days, int months, int years){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dateToIncrease);
		calendar.add(Calendar.DAY_OF_MONTH, days);
		calendar.add(Calendar.MONTH, months);
		calendar.add(Calendar.YEAR, years);
		/*Date increasedDaysMonthsYearsInDate = new Date(((calendar.get(Calendar.MONTH)+1+months)+"/"+(calendar.get(Calendar.DAY_OF_MONTH)+days)+"/"+(calendar.get(Calendar.YEAR)+years)).toString());
		return increasedDaysMonthsYearsInDate;*/
		return calendar.getTime();
	}
	
	
	/**
	 * Do nothing if date format is not supported.
	 */
	protected boolean setDateTime(String date, String pattern) {
		boolean dateChanged = true;
		dateFormat.applyPattern(pattern);
		try {
			setDateTime(dateFormat.parse(date));
		} catch (ParseException e) {
			dateChanged = false;
		}
		return dateChanged;
	}

	public void setDateTime(Date date) {
		dateTime = date.getTime();
	}

	public static Date getDate() {
		dateTime = System.currentTimeMillis();
		return new Date(dateTime);
	}

	public String toISO8601() {
		if (getMilliseconds() == 0)
			return toString(ISO_8601_UTC_PATTERN);
		return toString(ISO_8601_UTC_MILLIS_PATTERN);
	}

	public String toRFC1123() {
		return toString(RFC_1123_PATTERN);
	}
	
	
	
	public static java.sql.Timestamp getCurrentTimestamp(String timezoneString) 
	{

		TimeZone tz = TimeZone.getTimeZone("Asia/Singapore");
		if(timezoneString.equals("singapore"))
		{
			tz = TimeZone.getTimeZone("Asia/Singapore");
		}

       	Calendar calendar = Calendar.getInstance(tz);
       	String year = "" + calendar.get(Calendar.YEAR);
       	String month = (((calendar.get(Calendar.MONTH) + 1) < 10) ?
                               	("0" + (calendar.get(Calendar.MONTH) + 1)) :
                               	("" + (calendar.get(Calendar.MONTH) + 1)));
       	String date = ((calendar.get(Calendar.DATE) < 10) ?
                               	("0" + calendar.get(Calendar.DATE)) :
                               	("" + calendar.get(Calendar.DATE)));
       	String hours = ((calendar.get(Calendar.HOUR_OF_DAY) < 10) ?
                               	("0" + calendar.get(Calendar.HOUR_OF_DAY)) :
                               	("" + calendar.get(Calendar.HOUR_OF_DAY)));
       	String minutes = ((calendar.get(Calendar.MINUTE) < 10) ?
                               	("0" + calendar.get(Calendar.MINUTE)) :
                               	("" + calendar.get(Calendar.MINUTE)));
       	String seconds = ((calendar.get(Calendar.SECOND) < 10) ?
                               	("0" + calendar.get(Calendar.SECOND)) :
                               	("" + calendar.get(Calendar.SECOND)));
       	String timestamp = year + "-" + month + "-" + date + " " + hours +
                          	":" + minutes + ":" + seconds + ".0";
       	return java.sql.Timestamp.valueOf(timestamp);
     }
	/**
	 * Returns on a RFC 1123 format.
	 */
	public String toString() {
		return toISO8601();
	}

	protected String toString(String pattern) {
		dateFormat.applyPattern(pattern);
		return dateFormat.format(getDate());
	}

	public static Calendar getCalendar() {
		return calendar;
	}

	public static void setCalendar(Calendar calendar) {
		DateTime.calendar = calendar;
	}

	public static Date getCurrentDate() {
		return currentDate;
	}

	public static void setCurrentDate(Date currentDate) {
		DateTime.currentDate = currentDate;
	}
}
