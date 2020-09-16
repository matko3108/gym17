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
 * PrivateCoachWeekdays generated by hbm2java
 */
@Entity
@Table(name = "private_coach_weekdays", catalog = "heroku_4ee2ecbe460bfa4")
public class PrivateCoachWeekdays implements java.io.Serializable {

	private Integer id;
	private Weekdays weekdays;
	private Integer duradion;
	private Integer fkPrivateCoach;
	private Date hour;

	public PrivateCoachWeekdays() {
	}

	public PrivateCoachWeekdays(Weekdays weekdays, Integer duradion, Integer fkPrivateCoach, Date hour) {
		this.weekdays = weekdays;
		this.duradion = duradion;
		this.fkPrivateCoach = fkPrivateCoach;
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

	@Column(name = "fk_private_coach")
	public Integer getFkPrivateCoach() {
		return this.fkPrivateCoach;
	}

	public void setFkPrivateCoach(Integer fkPrivateCoach) {
		this.fkPrivateCoach = fkPrivateCoach;
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
