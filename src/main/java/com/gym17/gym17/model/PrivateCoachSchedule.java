package src.main.java.com.gym17.gym17.model;
// Generated Apr 8, 2021, 1:25:08 PM by Hibernate Tools 5.2.12.Final

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
 * PrivateCoachSchedule generated by hbm2java
 */
@Entity
@Table(name = "private_coach_schedule", catalog = "heroku_4ee2ecbe460bfa4")
public class PrivateCoachSchedule implements java.io.Serializable {

	private Integer id;
	private UserCustomer userCustomer;
	private UserWorker userWorker;
	private Weekdays weekdays;
	private String description;
	private Date start;
	private Date end;
	private Integer fkStatus;
	private Integer duration;
	private Integer hour;

	public PrivateCoachSchedule() {
	}

	public PrivateCoachSchedule(UserCustomer userCustomer, UserWorker userWorker, Weekdays weekdays, String description,
			Date start, Date end, Integer fkStatus, Integer duration, Integer hour) {
		this.userCustomer = userCustomer;
		this.userWorker = userWorker;
		this.weekdays = weekdays;
		this.description = description;
		this.start = start;
		this.end = end;
		this.fkStatus = fkStatus;
		this.duration = duration;
		this.hour = hour;
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
	@JoinColumn(name = "fk_customer")
	public UserCustomer getUserCustomer() {
		return this.userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_worker")
	public UserWorker getUserWorker() {
		return this.userWorker;
	}

	public void setUserWorker(UserWorker userWorker) {
		this.userWorker = userWorker;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_weekday")
	public Weekdays getWeekdays() {
		return this.weekdays;
	}

	public void setWeekdays(Weekdays weekdays) {
		this.weekdays = weekdays;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start", length = 19)
	public Date getStart() {
		return this.start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end", length = 19)
	public Date getEnd() {
		return this.end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	@Column(name = "fk_status")
	public Integer getFkStatus() {
		return this.fkStatus;
	}

	public void setFkStatus(Integer fkStatus) {
		this.fkStatus = fkStatus;
	}

	@Column(name = "duration")
	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Column(name = "hour")
	public Integer getHour() {
		return this.hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

}
