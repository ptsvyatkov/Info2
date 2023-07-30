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
public class MyBirthday {
	
	private int systemDay, systemMonth, systemYear, systemHours, systemMinutes, 
				systemSeconds, birthDay, birthMonth, birthYear, birthHours, birthMinutes, birthSeconds;
	private Scanner numberReader,stringReader;
	private String choice;
	MyJulianDate julianDate;
	
	
	public MyBirthday() {	
		julianDate = new MyJulianDate();
	
		getSystemDate();
	}
	
	/*
	 * Input for the Day, Month and Year. Not all possible checks implemented yet
	 * Entered values are stored in the fields.
	 * Hours, Minutes and seconds for Julian Date doesnt work yet
	 */
	public void input() {
		numberReader = new Scanner(System.in);
		boolean continueInput1 = true;
		boolean continueInput2 = true;
		boolean continueInput3 = true;
		System.out.print("Please enter your birthday" + "\n");
		
		System.out.print("Please enter the day as Number: ");
		while(continueInput1) {
		try {birthDay= numberReader.nextInt();
			continueInput1 = false;
		} catch (InputMismatchException e) {
			System.out.println("You didn't enter a Number. Please Try again.");
			numberReader.nextLine();
		  }
		}
		
		System.out.print("Please enter the month as a Number: ");
		while(continueInput2) {
			try {birthMonth= numberReader.nextInt();
				continueInput2 = false;
			} catch (InputMismatchException e) {
				System.out.println("You didn't enter a Number. Please Try again.");
				numberReader.nextLine();
			  }
			}
		
		System.out.print("Please enter the year in four digits: ");
		while(continueInput3) {
			try {birthYear= numberReader.nextInt();
				continueInput3 = false;
			} catch (InputMismatchException e) {
				System.out.println("You didn't enter a Number. Please Try again.");
				numberReader.nextLine();
			  }
			}
	}	

	/*
	 * Takes a String as Input and then the methods are called.
	 * No Try and Catch implemented. Wrong input shuts down the program
	 * 
	 * age should deal somehow else with the method calls. something is redundant here
	 * 
	 */
	public void select() {
		System.out.println("What do you want to calculate? Enter day for Day of birth or age for your age in days");
		stringReader = new Scanner(System.in);
		choice = stringReader.nextLine();
		if (choice.equals("age")) {
			input();
		//	calculateDays();
			printAgeInDays();
			
		} else if (choice.equals("day")) {
			input();
			calculateDayofBirth();
		}
		else {
			System.out.println("error. Again loop not implemented yet");
		}
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
	systemHours = calendar.get(Calendar.HOUR_OF_DAY);
	systemMinutes = calendar.get(Calendar.MINUTE);
	systemSeconds = calendar.get(Calendar.SECOND);
	}
	
	/*
	 * Calculates the Age in days. Takes the system date and calculate the JDN and the Birthdate and calculates the JDN
	 * The Age in Days is the Difference of both
	 * 
	 */
	public int calculateDays() {
		int systemJDN = 0;
		int birthdayJDN = 0;
		if (julianDate.calculateJulianNumber(systemDay, systemMonth, systemYear) != -1) {
			systemJDN = julianDate.calculateJulianNumber(systemDay,systemMonth,systemYear);
		} else {
			System.out.println("Sorry, an error appeared");
		}
		
		if (julianDate.calculateJulianNumber(birthDay, birthMonth, birthYear) != -1) {
			birthdayJDN = julianDate.calculateJulianNumber(birthDay, birthMonth, birthYear);
			
		} else {
			System.out.println("Sorry, an error appeared");
		}
		int ageInDays = systemJDN - birthdayJDN;
		return ageInDays;
		}
	/*
	 * Calculates julian date but with fix parameters directly written in the method. 
	 * interavtive input isnt implemented
	 */
	public double calculateDaysWithTime() {
		//calculates Julian Date Number of the System
		int jdnSystem = julianDate.calculateJulianNumber(systemDay, systemMonth, systemYear); 
		//calculates Julian Date of the System
		double jdSystem = julianDate.calculateJulianDate(jdnSystem, systemHours, systemMinutes, systemSeconds); 
		//calculates Julian Date Number of Entered birthday date
		int jdnBirthday = julianDate.calculateJulianNumber(8, 11, 1987);
		//calculates Julian Date Number of Birthday Date with Time
		double jdBirthday = julianDate.calculateJulianDate(jdnBirthday, 16, 00, 0);
		//Calculates difference between System Number and Birthday Number
		double jdAge = jdSystem-jdBirthday; 
		System.out.println("Julian Date: " + jdAge);
		return jdAge;
	}
	
	
	/*
	 * Takes the result of the day calculation and prints the result
	 */
	public void printAgeInDays() {
		if (calculateDays()<10957) {
			System.out.println("You are " + calculateDays() + " Days old. Thats ok.");
		} else {
			System.out.println("You are " + calculateDays() + " Days old. Oh boy. Thats already pretty old.");
		}
		if (calculateDays()%100 == 0) {
			System.out.println("Special Message");
		}
		
		//cheat version
//		if (birthDay == systemDay && birthMonth == systemMonth) { //cheat birthday version
//			System.out.println("Happy Birthday");
//		}
		
		//condition doesnt work correctly
		if (calculateDays()%365.25==0 || calculateDays()%365==0) {
			System.out.println("Happy Birthday");
		}
	}
	
	/*
	 * Calculates the day of birth using the modulo operator. Day 0 is monday
	 */
	public void calculateDayofBirth () {
		int jdn = julianDate.calculateJulianNumber(birthDay, birthMonth, birthYear);
		if (((jdn%7)) == 0 ) {
			System.out.println("Monday");
		}
		if (((jdn%7)) == 1 ) {
			System.out.println("Tuesday");
		}
		if (((jdn%7)) == 2 ) {
			System.out.println("Wednesday");
		}
		if (((jdn%7)) == 3 ) {
			System.out.println("Thursday");
		}
		if (((jdn%7)) == 4 ) {
			System.out.println("Friday");
		}
		if (((jdn%7)) == 5 ) {
			System.out.println("Saturday");
		}
		if (((jdn%7)) == 6 ) {
			System.out.println("Sunday");
		}
	}
	
}
