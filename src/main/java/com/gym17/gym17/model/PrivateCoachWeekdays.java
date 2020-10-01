package src.main.java.com.gym17.gym17.model;
// Generated Sep 19, 2020, 3:20:31 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;

import javax.persistence.CascadeType;
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
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * PrivateCoachWeekdays generated by hbm2java
 */
@Entity
@Table(name = "private_coach_weekdays", catalog = "heroku_4ee2ecbe460bfa4")
public class PrivateCoachWeekdays implements java.io.Serializable {

	private Integer id;
	@JsonIgnoreProperties(value={"privateCoachWeekdayses","hibernateLazyInitializer"})
	private PrivateCoach privateCoach;
	@JsonIgnoreProperties(value={"hibernateLazyInitializer"})
	private Weekdays weekdays;
	private Integer duradion;
	 @JsonFormat(pattern="HH:mm:ss")
	private Date hour;

	public PrivateCoachWeekdays() {
	}

	public PrivateCoachWeekdays(PrivateCoach privateCoach, Weekdays weekdays, Integer duradion, Date hour) {
		this.privateCoach = privateCoach;
		this.weekdays = weekdays;
		this.duradion = duradion;
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
	@JoinColumn(name = "fk_private_coach")
	public PrivateCoach getPrivateCoach() {
		return this.privateCoach;
	}

	public void setPrivateCoach(PrivateCoach privateCoach) {
		this.privateCoach = privateCoach;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_weekday")
	public Weekdays getWeekdays() {
		return this.weekdays;
	}

	public void setWeekdays(Weekdays weekdays) {
		this.weekdays = weekdays;
	}

	@Column(name = "duradion")
	public Integer getDuradion() {
		return this.duradion;
	}

	public void setDuradion(Integer duradion) {
		this.duradion = duradion;
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
