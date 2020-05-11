package lession8_Exception;
/**
 * The Months enum represents seasons, months and numbers of days in every month
 * @author ARTUR
 * @since JDK 13.0.2
*/

public enum Month {
	JANUARY(Season.WINTER, 31), 
	FEBRUARY(Season.WINTER, 28), 
	MARCH(Season.SPRING, 31),
    APRIL(Season.SPRING, 30), 
    MAY(Season.SPRING, 31), 
    JUNE(Season.SUMMER, 30),
    JULY(Season.SUMMER, 31), 
    AUGUST(Season.SUMMER, 31), 
    SEPTEMBER(Season.FALL, 30),
    OCTOBER(Season.FALL, 31), 
    NOVEMBER(Season.FALL, 30), 
    DECEMBER(Season.WINTER, 31);

	private Season season;
	private int days;
	
	//constructor
	private Month(Season season, int days) {
		this.season = season;
		this.days = days;
	}
	
	//return season
	public Season getSeason() {
		return season;
	}
	//set season
	public void setSeason(Season season) {
		this.season = season;
	}
	// return day
	public int getDays() {
		return days;
	}
	// set day
	public void setDays(int days) {
		this.days = days;
	}
	
}
