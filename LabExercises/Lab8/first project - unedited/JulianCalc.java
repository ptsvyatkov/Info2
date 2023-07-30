import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * controls user input for the birthday, selection of what you want to calculate 
 * calculates age in days (Julian day number or Julian Date)  using MyJulianDate
 * Calculates the day of birth
 * prints everthing out
 * 
 * user input and input checks not completed
 * select should be optimized so that it calls the right method (printage for instance)
 * calculateDaysWithTime still deals with the printing
 */
public class JulianCalc {
	
	private int systemDay, systemMonth, systemYear;
	MyJulianDate myJulianDate;
	
	
	public JulianCalc() {	
		myJulianDate = new MyJulianDate();
	
		getSystemDate();
	}
	
	
	
	/*
	 * gets the system date including day, month, year, hours, minutes, seconds
	 * different time zones and other more complex stuff have not been considered yet
	 */
	public void getSystemDate() {

	Calendar calendar = Calendar.getInstance();
	systemDay = calendar.get(Calendar.DAY_OF_MONTH);
	systemMonth = calendar.get(Calendar.MONTH)+1;
	systemYear = calendar.get(Calendar.YEAR);

	}
	
	 protected int dateToJulian(String date) {
	    	
	    	String[] parts = date.split("\\.");
	    	int day = Integer.parseInt(parts[0]); 
	    	int month = Integer.parseInt(parts[1]);
	    	int year = Integer.parseInt(parts[2]);
	      	int jdn = myJulianDate.calculateJulianNumber(day, month, year);
	    			
	    	return jdn;
	    	
		}
	
	
	
	/*
	 * Calculates the day of birth using the modulo operator. Day 0 is monday
	 */
	public String calculateDayofBirth (int jdn) {

		if (((jdn%7)) == 0 ) {
			return "Monday";
			//System.out.println("Monday");
		}
		if (((jdn%7)) == 1 ) {
			System.out.println("Tuesday");
			return "Tuesday";
		}
		if (((jdn%7)) == 2 ) {
			System.out.println("Wednesday");
			return "Wednesday";
		}
		if (((jdn%7)) == 3 ) {
			System.out.println("Thursday");
			return "Thursday";
		}
		if (((jdn%7)) == 4 ) {
			System.out.println("Friday");
			return "Friday";
		}
		if (((jdn%7)) == 5 ) {
			System.out.println("Saturday");
			return "Saturday";
		}
		if (((jdn%7)) == 6 ) {
			System.out.println("Sunday");
			return "Sunday";
		}
		return "error";
	}
	
	
	public String jdnToCalendar(int jdn) {
		int f = jdn + 1401 + (((4*jdn+274277)/146097)*3)/4+(-38);
		int e = 4*f+3;
		int g = (e%1461)/4;
		int h = 5*g+2;
		int day = (h%153)/5+1;
		int month = ((h/153+2)%12)+1;
		int year = (e/1461)-4716+(12+2-month)/12;
		System.out.println("Date: " + day + "." + month + "." + year);
		return "" + day + "." + month + "." + year;
	}	
}
