/*
 * subclass of MyJulianDate
 * deals with the calculation from julianDate to metric and the other way around
 * can also calculate from julian day number to date what was completely unnecessarily
 */
public class Metric extends MyJulianDate {
	
	public Metric() {
		
	}
	
	public double jdToMetricAge(double jd) {
		double metricAge = jd/1000;
		return metricAge;
	}

	public double metricAgeToJdn(double mAge) {
		double jdAge = mAge*1000;
		return jdAge;
	}
	
	public void jdnToCalendar(int jdn) {
		int f = jdn + 1401 + (((4*jdn+274277)/146097)*3)/4+(-38);
		int e = 4*f+3;
		int g = (e%1461)/4;
		int h = 5*g+2;
		int day = (h%153)/5+1;
		int month = ((h/153+2)%12)+1;
		int year = (e/1461)-4716+(12+2-month)/12;
		System.out.println("Date: " + day + "." + month + "." + year);
		
	}
}
