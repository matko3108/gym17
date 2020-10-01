package src.main.java.com.gym17.gym17.model;
// Generated Sep 19, 2020, 1:05:34 PM by Hibernate Tools 4.3.5.Final

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * GroupWeekdays generated by hbm2java
 */
@Entity
@Table(name = "group_weekdays", catalog = "heroku_4ee2ecbe460bfa4")
public class GroupWeekdays implements java.io.Serializable {

	private Integer id;
	@JsonIgnoreProperties("groupWeekdayses")
	private Group group;
	@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
	private Weekdays weekdays;
	private Integer duration;
	 @JsonFormat(pattern="HH:mm:ss")
	private Date hour;

	public GroupWeekdays() {
	}

	public GroupWeekdays(Group group, Weekdays weekdays, Integer duration, Date hour) {
		this.group = group;
		this.weekdays = weekdays;
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
	@JoinColumn(name = "fk_group")
	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_weekday")
	public Weekdays getWeekdays() {
		return this.weekdays;
	}

	public void setWeekdays(Weekdays weekdays) {
		this.weekdays = weekdays;
	}

	@Column(name = "duration")
	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "hour", length = 8)
	public Date getHour() {
		return this.hour;
	}

	public void setHour(Date hour) {
		this.hour = hour;
	}

}
