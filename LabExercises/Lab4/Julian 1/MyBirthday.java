import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
public class MyBirthday {
	
	private int systemDay, systemMonth, systemYear, birthDay, birthMonth, birthYear;
	private Scanner numberReader,stringReader;
	private String choice;
	MyJulianDate julianDate;
	
	public MyBirthday() {	
		julianDate = new MyJulianDate();
	}
	
	
	public void input() {
		numberReader = new Scanner(System.in);
		boolean continueInput = true;
		System.out.print("Please enter your birthday" + "\n");
		
		System.out.print("Please enter the day as Number: ");
		while(continueInput) {
		try {birthDay= numberReader.nextInt();
			continueInput = false;
		} catch (InputMismatchException e) {
			System.out.println("You didn't enter a Number. Please Try again.");
			numberReader.nextLine();
		  }
		}
		
		System.out.print("Please enter the month as a Number: ");
		while(continueInput) {
			try {birthMonth= numberReader.nextInt();
				continueInput = false;
			} catch (InputMismatchException e) {
				System.out.println("You didn't enter a Number. Please Try again.");
				numberReader.nextLine();
			  }
			}
		
		System.out.print("Please enter the year in four digits: ");
		while(continueInput) {
			try {birthYear= numberReader.nextInt();
				continueInput = false;
			} catch (InputMismatchException e) {
				System.out.println("You didn't enter a Number. Please Try again.");
				numberReader.nextLine();
			  }
			}
	}	

	
//	public void select() {
//		System.out.println("What do you want to calculate? Enter jdn or jd(jd not implemented yet)");
//		stringReader = new Scanner(System.in);
//		choice = stringReader.nextLine();
//		if (choice().equals("jdn")) {
//			calculateJulianNumber();
//		} else {
//			System.out.println("error");
//		}
//	}
//	
//	public String choice () {
//		return choice;
//	}
	
	
	public void getSystemDate() {

	Calendar calendar = Calendar.getInstance();
	systemDay = calendar.get(Calendar.DAY_OF_MONTH);
	systemMonth = calendar.get(Calendar.MONTH)+1;
	systemYear = calendar.get(Calendar.YEAR);
//    System.out.println("Day: " + systemDay + " Month: " + systemMonth + " Year:" + systemYear);
	}
	
	public int calculateBirthday() {
		getSystemDate();
		int systemJDN = julianDate.calculateJulianNumber(systemDay,systemMonth,systemYear);
//		System.out.println(systemJDN);
		int birthdayJDN = julianDate.calculateJulianNumber(birthDay, birthMonth, birthYear);
//		System.out.println(birthdayJDN);
		int ageInDays = systemJDN - birthdayJDN;
//		System.out.println("age in days: " + ageInDays);
		return ageInDays;
	}
	
	public void printAgeInDays() {
		if (calculateBirthday()<10957) {
			System.out.println("You are " + calculateBirthday() + " Days old. Thats ok.");
		} else {
			System.out.println("You are " + calculateBirthday() + " Days old. Oh boy. Thats already pretty old.");
		}
		
	}
}
