package src.main.java.com.gym17.gym17.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ActivityListData {
	private String activityType;
	private String user_id;
	private Boolean active;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	private String description;
	private String name;
	private Integer validityPeriod;
	public String getActivityType() {
		return activityType;
	}
	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getValidityPeriod() {
		return validityPeriod;
	}
	public void setValidityPeriod(Integer validityPeriod) {
		this.validityPeriod = validityPeriod;
	}
	@Override
	public String toString() {
		return "ActivityListData [activityType=" + activityType + ", user_id=" + user_id + ", active=" + active
				+ ", createDate=" + createDate + ", description=" + description + ", name=" + name + ", validityPeriod="
				+ validityPeriod + "]";
	}
	
	
}
