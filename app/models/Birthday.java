package models;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Birthday {
	
	private String month;
	
	private String date;
	
	private String year;
	
	private Date birthday;

	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday() {
		String string_date = "January 2, 2010";
//		Date date = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(string_date);
		this.birthday = birthday;
	}
	
	public static List<String> getAllYear(){
		
		return null;
	}
	
	public static List<String> getAllMonth(){
		return null;
	}
	
	public static List<String> getAlldates(){
		return null;
	}
}

