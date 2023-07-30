
public class MyJulianDateMain {
	
	public static void main(String[] args) {

		MyBirthday birthday = new MyBirthday();
		MetricAge metricAge = new MetricAge();
		
		//task 3 from Julian day age to Metric age for a fix paramter here
		System.out.println("Julian date age in Metric: " + metricAge.ageInMetric() + "\n");
		
		//task 3 from Metric Age to Julian day for a fix parameter here
		System.out.println("Metric Age in Julian Date: " + metricAge.metricAgeInJulianDateAge() + "\n");
		
		//task 2 for julian date with a fix birthday and printing in the calculating method
		birthday.calculateDaysWithTime();
		
		//task 2 just with julian day number but user input
		birthday.select();

//		birthday.getSystemDate();
//		birthday.input();
//		birthday.calculateDayofBirth();
//		birthday.calculateDays();
//		birthday.printAgeInDays();

		
		//		for (int i = 1998; i < 2020; i++) {
//		int sys = myJulianDate.calculateJulianNumber(9, 11, 2019);
//		int bd = myJulianDate.calculateJulianNumber(9, 11, i);
//		int res = sys-bd;
//		double res2 =  (double)res%365.25;
//		int res3 = res%365;
//		System.out.println(i + " " + res + " " + res2 + " "+ res3);
//	}

	}
}
