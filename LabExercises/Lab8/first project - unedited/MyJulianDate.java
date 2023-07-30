
/*
 * All the methods which are needed to calculate Julian Date or Julian day number
 * 
 */
public class MyJulianDate implements JulianDate{
	
	private int day, month, year, julianDayNumber/*, hour, minute, seconds*/;
	private double julianDate;

	
	public MyJulianDate() {
		System.out.println(calculateJulianNumber(11, 12, 2019));
		
	}
	public MyJulianDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
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
	//returns the field of month
	public int getMonth() {
		return month;
	}
	
	//takes an int and stores in the field year
	public void setYear(int year) {
		this.year = year;
	}
	//returns the field of year
	public int getYear() {
		return year;
	}
	
	
	/*
	 * checks, if the entered year is valid
	 */
	public boolean checkYear(int year) {
		if (year > -4714 && year < 3269) {
			return true;
		} else {
			System.out.println("The entered year doesn't fit to the range of the Julian Calendar.");
			return false;
		}
	}
	
	/*
	 * checks if the entered month is valid
	 * 
	 */
	public boolean checkMonth(int month) {
		if (month>0 && month<13) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * checks if the entered day is valid
	 * February still has 30 days
	 * leap years not included yet
	 */
	public boolean checkDay(int day, int month) {
		//checking if the even month smaller then 8 have 30 days
		if (month<8 && month%2==0 && day>0 && day < 31) { 
			return true;
		} 
		//checking if the uneven month smaller then 8 have 31 days
		else if (month<8 && month%2 !=0 && day >0 && day<32) {
			return true;
		} 
		//check if even month bigger then 7 have 31 days
		else if (month > 7 && month%2==0 && day>0 && day<32) {
			return true;
		} 
		//check if uneven month bigger then 7 have 30 days
		else if (month > 7 && month%2!=0 && day>0 && day<31) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * calculates the Julian Number if all the entered values are correct
	 * no try again loop implemented
	 */
	public int calculateJulianNumber(int day, int month, int year) {
		
		if (checkDay(day, month) && checkMonth(month) && checkYear(year)) {
			julianDayNumber = (1461 * (year + 4800 + (month - 14)/12))/4 +
					(367 * (month - 2 - 12 * ((month - 14)/12)))/12 - 
					(3 * ((year + 4900 + (month - 14)/12)/100))/4 + day - 32075;
			return julianDayNumber;
		} else {
			return -1;
		}
	}
	
	
	
	/*
	 * prints the Julian Number
	 * 
	 */
	public void printJulianDayNumber(int jdn) {
		String outputString = "The JDN is: " + jdn;
		System.out.println(outputString);
	}
	
	
}
