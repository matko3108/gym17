package src.main.java.com.gym17.gym17.model;
// Generated Sep 16, 2020, 7:54:25 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ActivityList generated by hbm2java
 */
@Entity
@Table(name = "activity_list", catalog = "heroku_4ee2ecbe460bfa4")
public class ActivityList implements java.io.Serializable {

	private Integer id;
	private ActivityType activityType;
	private Boolean active;
	private Date createDate;
	private String description;
	private int fkUser;
	private String name;
	private Integer validityPeriod;

	public ActivityList() {
	}

	public ActivityList(ActivityType activityType, int fkUser, String name) {
		this.activityType = activityType;
		this.fkUser = fkUser;
		this.name = name;
	}

	public ActivityList(ActivityType activityType, Boolean active, Date createDate, String description, int fkUser,
			String name, Integer validityPeriod) {
		this.activityType = activityType;
		this.active = active;
		this.createDate = createDate;
		this.description = description;
		this.fkUser = fkUser;
		this.name = name;
		this.validityPeriod = validityPeriod;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_activity_type", nullable = false)
	public ActivityType getActivityType() {
		return this.activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	@Column(name = "active")
	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date", length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "fk_user", nullable = false)
	public int getFkUser() {
		return this.fkUser;
	}

	public void setFkUser(int fkUser) {
		this.fkUser = fkUser;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "validity_period")
	public Integer getValidityPeriod() {
		return this.validityPeriod;
	}

	public void setValidityPeriod(Integer validityPeriod) {
		this.validityPeriod = validityPeriod;
	}

}
