/*
 * calculates the age in metric system using Metric
 * 
 */
public class MetricAge {
	double age;
	Metric metricDate;
	public MetricAge() {
		metricDate = new Metric();
	}
	
	/*
	 * Calculates julian date but with fix parameters directly written in the method. 
	 * interavtive input isnt implemented
	 */
	public double calculateDaysWithTime() {
		//calculates Julian Date Number of the System
		int jdnSystem = metricDate.calculateJulianNumber(10, 11, 2019); 
		//calculates Julian Date of the System
		double jdSystem = metricDate.calculateJulianDate(jdnSystem, 18, 24, 37); 
		//calculates Julian Date Number of Entered birthday date
		int jdnBirthday = metricDate.calculateJulianNumber(8, 11, 1987);
		//calculates Julian Date Number of Birthday Date with Time
		double jdBirthday = metricDate.calculateJulianDate(jdnBirthday, 16, 00, 0);
		//Calculates difference between System Number and Birthday Number
		double jdAge = jdSystem-jdBirthday; 
		return jdAge;
	}
	
	/*
	 * Metric Age for a birthday 8.11.1987 16:00
	 */
	public double ageInMetric() {
		double jd = calculateDaysWithTime();
		double mAge = metricDate.jdToMetricAge(jd);
		return mAge;
	}
	/*
	 *takes a metric age an calcualtes the age in julian date for Metric Age of 11.785 years
	 */
	public double metricAgeInJulianDateAge() {
		double jd = metricDate.metricAgeToJdn(11.785); 
		return jd;
	}
}
