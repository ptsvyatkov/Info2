import java.awt.Checkbox;

public class TestMyJulianDate implements JulianDate{
	public static void main(String[] args) {
		MyJulianDate testJulianDate = new MyJulianDate();
		
		//test setDay and getDay
		System.out.println("Set Day to 20");
		testJulianDate.setDay(20);
		
		if (testJulianDate.getDay() == 20) {
			System.out.println("The entered number is equal to the return value. Thats fine");
		} else {
			System.out.println("Mismatch between entered number and return Value. Have a look at setDay and getDay.");
		}

		//test setMonth and getMonth
		System.out.println("Set Month to 11");
		testJulianDate.setMonth(11);
		
		if (testJulianDate.getMonth() == 11) {
			System.out.println("The entered number is equal to the return value. Thats fine");
		} else {
			System.out.println("Mismatch between entered number and return Value. Have a look at setMonth and getMonth.");
		}

		//test setYear and getYear
			System.out.println("Set Year to 2019");
			testJulianDate.setMonth(2019);
				
			if (testJulianDate.getMonth() == 2019) {
				System.out.println("The entered number is equal to the return value. Thats fine");
			} else {
				System.out.println("Mismatch between entered number and return Value. Have a look at setYear and getYear.");
			}		
			
		//test the checkYear Method with a regular year
		System.out.println("Test checkYear with 2019");
		
		if (testJulianDate.checkYear(2019)) {
			System.out.println("Regular year 2019 passed the test");
		} else {
			System.out.println("Regular year 2019 didnt pass the test. Something went wrong. Have a look at checkYear.");
		}
	
		//test the checkYear for upper Limit
		System.out.println("Test checkYear for upper Limit with 3269");

		if (testJulianDate.checkYear(3269)) {
			System.out.println("It shouldn return true. Have a look at checkYear");
		} else {
			System.out.println("Return false is totaly what I expected here.");
		}
		
		//test the checkYear for lower Limit
		System.out.println("Test checkYear for lower Limit with -4714");

		if (testJulianDate.checkYear(3269)) {
			System.out.println("It shouldn return true. Have a look at checkYear");
		} else {
			System.out.println("Return false is totaly what I expected here.");
		}
		
		//test the checkMonth with regular Number
		System.out.println("Test with regular month 12");

		if (testJulianDate.checkMonth(12)) {
			System.out.println("Return true is fine. 12 passed the test");
		} else {
			System.out.println("Returned false for a valid number. Have a look at checkMonth.");
		}
		
		//test checkMonth with upper Limit
		System.out.println("Test with unvalid month 13");

		if (testJulianDate.checkMonth(13)) {
			System.out.println("It shouldn return true. Check checkMonth.");
		} else {
			System.out.println("False is great");
		}
		
		//test checkMonth with lower Limit
		System.out.println("Test with unvalid month 0");

		if (testJulianDate.checkMonth(0)) {
			System.out.println("It shouldn return true. Check checkMonth.");
		} else {
			System.out.println("False is great");
		}
		
		//test the day. Thats exciting now
		//Looping through the year
		int[] year = new int[13];
		for (int i = 1; i < 13; i++) {
			for (int j = 1; j < 32; j++) {
				if (testJulianDate.checkDay(j, i)) {
					year[i]++;
					
				}
			} System.out.println("Month " + i + ": " + year[i] + " Days");
		}
		
		//test calculateJulianNumber for a valid date
		System.out.println("Test calculateJulianNumber with a valid date");
		if (testJulianDate.calculateJulianNumber(17,7,1987) != -1) {
			System.out.println("The entered value was correct");
		} else {
			System.out.println("Returned -1 but it shouldnt. Check calculateJulianNumber");
		}
		
		//test calculateJulianNumber for an unvalid date
		System.out.println("test calculate Number with an unvalid Date");
		if (testJulianDate.calculateJulianNumber(31, 2, 1987) != -1) {
			System.out.println("Shouldnt return a number ");
		} else {
			System.out.println("Returned -1. Thats fine");
		}
		
		//print the Julian Day Number
		System.out.println("Test Print for 1");
		testJulianDate.printJulianDayNumber(1);
	
		
		//print julian date
		System.out.println("Test Print for 1");
		testJulianDate.printJulianDate(1);
		
			

	}
}
