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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * ActivityType generated by hbm2java
 */
@Entity
@Table(name = "activity_type", catalog = "heroku_4ee2ecbe460bfa4")
public class ActivityType implements java.io.Serializable {

	private Integer id;
	private Boolean active;
	private String description;
	private String name;
	@JsonIgnoreProperties("activityType")
	private Set<ActivityList> activityLists = new HashSet<ActivityList>(0);

	public ActivityType() {
	}

	public ActivityType(String name) {
		this.name = name;
	}

	public ActivityType(Boolean active, String description, String name, Set<ActivityList> activityLists) {
		this.active = active;
		this.description = description;
		this.name = name;
		this.activityLists = activityLists;
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

	@Column(name = "active")
	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "activityType")
	public Set<ActivityList> getActivityLists() {
		return this.activityLists;
	}

	public void setActivityLists(Set<ActivityList> activityLists) {
		this.activityLists = activityLists;
	}

}
