package src.main.java.com.gym17.gym17.model;

import java.util.Date;

public class PrivateCoachWeekday {
	private int privateCoach;
	private int weekdays;
	private int duradion;
	private String hour;
	public int getPrivateCoach() {
		return privateCoach;
	}
	public void setPrivateCoach(int privateCoach) {
		this.privateCoach = privateCoach;
	}
	public int getWeekdays() {
		return weekdays;
	}
	public void setWeekdays(int weekdays) {
		this.weekdays = weekdays;
	}
	public int getDuradion() {
		return duradion;
	}
	public void setDuradion(int duradion) {
		this.duradion = duradion;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	@Override
	public String toString() {
		return "PrivateCoachWeekday [privateCoach=" + privateCoach + ", weekdays=" + weekdays + ", duradion=" + duradion
				+ ", hour=" + hour + "]";
	}
	
	

}
