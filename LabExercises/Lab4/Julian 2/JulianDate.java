
public interface JulianDate {
	
	
	public void setDay(int i);
	
	public int getDay();
	
	public void setMonth(int i);
	
	public int getMonth();
	
	public void setYear(int i);
	
	public int getYear();
	
	public boolean checkYear(int year);
	
	public boolean checkMonth(int month);
	
	public boolean checkDay(int day, int month);
	
//	public void setHours(int i);
//	
//	public int getHours();
//	
//	public void setMinutes(int i);
//	
//	public int getMinutes();
//	
//	public void setSeconds(int i);
//	
//	public int getSeconds();
	
	public int calculateJulianNumber(int day, int month, int year);
	
	public double calculateJulianDate(int jdn, int hours, int minutes, int seconds);
	
	public void printJulianDayNumber(int jdn);
	
	public void printJulianDate(int jd);
	

}
