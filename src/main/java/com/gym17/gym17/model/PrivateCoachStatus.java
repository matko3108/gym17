package src.main.java.com.gym17.gym17.model;
// Generated Apr 8, 2021, 1:55:16 PM by Hibernate Tools 5.2.12.Final

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

/**
 * PrivateCoachStatus generated by hbm2java
 */
@Entity
@Table(name = "private_coach_status", catalog = "heroku_4ee2ecbe460bfa4")
public class PrivateCoachStatus implements java.io.Serializable {

	private Integer id;
	private String name;
	private Set<PrivateCoachSchedule> privateCoachSchedules = new HashSet<PrivateCoachSchedule>(0);

	public PrivateCoachStatus() {
	}

	public PrivateCoachStatus(String name) {
		this.name = name;
	}

	public PrivateCoachStatus(String name, Set<PrivateCoachSchedule> privateCoachSchedules) {
		this.name = name;
		this.privateCoachSchedules = privateCoachSchedules;
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

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "privateCoachStatus")
	public Set<PrivateCoachSchedule> getPrivateCoachSchedules() {
		return this.privateCoachSchedules;
	}

	public void setPrivateCoachSchedules(Set<PrivateCoachSchedule> privateCoachSchedules) {
		this.privateCoachSchedules = privateCoachSchedules;
	}

}
