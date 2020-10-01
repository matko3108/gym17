package src.main.java.com.gym17.gym17.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UserMembershipData {
	private String user_id;
	private String membership_id;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date start_date;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date end_date;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getMembership_id() {
		return membership_id;
	}
	public void setMembership_id(String membership_id) {
		this.membership_id = membership_id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	@Override
	public String toString() {
		return "UserMembershipData [user_id=" + user_id + ", membership_id=" + membership_id + ", start_date="
				+ start_date + ", end_date=" + end_date + "]";
	}

	

	
}
