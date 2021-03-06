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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * WorkerRights generated by hbm2java
 */
@Entity
@Table(name = "worker_rights", catalog = "heroku_4ee2ecbe460bfa4")
public class WorkerRights implements java.io.Serializable {

	private Integer id;
	@JsonIgnore
	private WorkerRightsType workerRightsType;
	private String description;
	private String name;
	//private Set<UserWorkerWorkerRights> userWorkerWorkerRightses = new HashSet<UserWorkerWorkerRights>(0);

	public WorkerRights() {
	}

	public WorkerRights(String name) {
		this.name = name;
	}

	public WorkerRights(WorkerRightsType workerRightsType, String description, String name,
			Set<UserWorkerWorkerRights> userWorkerWorkerRightses) {
		this.workerRightsType = workerRightsType;
		this.description = description;
		this.name = name;
		//this.userWorkerWorkerRightses = userWorkerWorkerRightses;
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_rights_type")
	public WorkerRightsType getWorkerRightsType() {
		return this.workerRightsType;
	}

	public void setWorkerRightsType(WorkerRightsType workerRightsType) {
		this.workerRightsType = workerRightsType;
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

	/*
	 * @OneToMany(fetch = FetchType.LAZY, mappedBy = "workerRights") public
	 * Set<UserWorkerWorkerRights> getUserWorkerWorkerRightses() { return
	 * this.userWorkerWorkerRightses; }
	 * 
	 * public void setUserWorkerWorkerRightses(Set<UserWorkerWorkerRights>
	 * userWorkerWorkerRightses) { this.userWorkerWorkerRightses =
	 * userWorkerWorkerRightses; }
	 */

}
