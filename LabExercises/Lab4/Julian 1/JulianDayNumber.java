import java.io.IOException;
import java.util.Scanner;

public class JulianDayNumber {

	public static void main(String[] args) {
		Scanner numberReader = new Scanner(System.in);
//		setDay();
		System.out.print("Enter the day: ");
		int day = numberReader.nextInt();
		
		System.out.print("Enter the month: ");
		int month = numberReader.nextInt();
		
		System.out.print("Enter the year: ");
		int year = numberReader.nextInt();
		
		int a = (14-month)/12;
		int y = year + 4800 -a;
		int m = month + 12*a-3;
		int julianD = day +(153*m + 2)/5 + 365*y + y/4 - y/100 + y/400 - 32045;
		
		System.out.println("The Julian Day number is: " + julianD);
	}
	


}
