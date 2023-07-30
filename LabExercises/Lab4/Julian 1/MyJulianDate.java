

public class MyJulianDate implements JulianDate{
	
	private int day, month, year, julianDayNumber, hour, minute, seconds;
	

	
	public MyJulianDate() {
		
	}
	

	//takes an int and stores in the field day
	public void setDay(int day) {
		this.day = day;
	}
	
	//returns the field of day
	public int getDay() {
		return day;
	}
	
	//takes an int and stores in the field month
	public void setMonth(int month) {
		this.month = month;
	}
	
	public int getMonth() {
		return month;
	}
	
	//takes an int and stores in the field year
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}
	
	
	
	public boolean checkYear(int year) {
		if (year > -4714 && year < 3269) {
			return true;
		} else {
			System.out.println("The entered year doesn't fit to the range of the Julian Calendar.");
			return false;
		}
	}
	
	public boolean checkMonth(int month) {
		if (month>0 && month<13) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkDay(int day, int month) {
		if (month%2==0 && day>0 && day < 32) {
			return true;
		} else if (month%2 !=0 && day >0 && day<31) {
			return true;
		} else {
			return false;
		}
	}
	
	public int calculateJulianNumber(int day, int month, int year) {
		
		julianDayNumber = (1461 * (year + 4800 + (month - 14)/12))/4 +
							(367 * (month - 2 - 12 * ((month - 14)/12)))/12 - 
							(3 * ((year + 4900 + (month - 14)/12)/100))/4 + day - 32075;
		return julianDayNumber;
	}
	
	public String printJulianDayNumber() {
		String outputString = "The JDN is: " + julianDayNumber;
		return outputString;
	}
	
	public String printJulianDate() {
		return "Not implemented yet.";
	}
}
