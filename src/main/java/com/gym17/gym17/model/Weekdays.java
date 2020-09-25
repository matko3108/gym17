package src.main.java.com.gym17.gym17.model;
// Generated Sep 19, 2020, 1:05:34 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Weekdays generated by hbm2java
 */
@Entity
@Table(name = "weekdays", catalog = "heroku_4ee2ecbe460bfa4")
public class Weekdays implements java.io.Serializable {

	private Integer id;
	private String name;
	private String shortname;

	public Weekdays() {
	}

	public Weekdays(String name, String shortname, Set<GroupWeekdays> groupWeekdayses,
			Set<PrivateCoachWeekdays> privateCoachWeekdayses) {
		this.name = name;
		this.shortname = shortname;
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

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "shortname", length = 5)
	public String getShortname() {
		return this.shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

}
