package src.main.java.com.gym17.gym17.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class GroupWeekdaysNew {
	private Group group;
	private Weekdays weekdays;
	private Integer duration;
	 @JsonFormat(pattern="HH:mm:ss")
	private Date hour;
	 
	 
	 
	public Group getGroup() {
		return group;
	}



	public void setGroup(Group group) {
		this.group = group;
	}



	public Weekdays getWeekdays() {
		return weekdays;
	}



	public void setWeekdays(Weekdays weekdays) {
		this.weekdays = weekdays;
	}



	public Integer getDuration() {
		return duration;
	}



	public void setDuration(Integer duration) {
		this.duration = duration;
	}



	public Date getHour() {
		return hour;
	}



	public void setHour(Date hour) {
		this.hour = hour;
	}



	@Override
	public String toString() {
		return "GroupWeekdaysNew [group=" + group + ", weekdays=" + weekdays + ", duration=" + duration + ", hour="
				+ hour + "]";
	}
	 
	 
}
