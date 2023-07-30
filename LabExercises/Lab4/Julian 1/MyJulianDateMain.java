
public class MyJulianDateMain {
	
	public static void main(String[] args) {
		MyJulianDate myJulianDate = new MyJulianDate();
		MyBirthday birthday = new MyBirthday();
		
//		birthday.getSystemDate();
		birthday.input();
		birthday.calculateBirthday();
		birthday.printAgeInDays();


	}
}
