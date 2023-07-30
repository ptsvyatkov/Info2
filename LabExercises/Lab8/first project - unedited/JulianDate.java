
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
		
	public int calculateJulianNumber(int day, int month, int year);
	
	public void printJulianDayNumber(int jdn);
	

}
