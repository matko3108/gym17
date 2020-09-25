package src.main.java.com.gym17.gym17.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user_worker", catalog = "heroku_4ee2ecbe460bfa4")
public class UserWorkerList implements java.io.Serializable {

	private int id;
	@JsonIgnoreProperties("userWorker")
	private User user;
	@JsonIgnoreProperties("userWorkers")
	private WorkerType workerType;
	private String additionalData;
	@JsonIgnoreProperties("userWorker")
	private Set<UserWorkerWorkerRights> userWorkerWorkerRightses = new HashSet<UserWorkerWorkerRights>(0);


	public UserWorkerList() {
	}

	public UserWorkerList(User user) {
		this.user = user;
	}

	public UserWorkerList(User user, WorkerType workerType, String additionalData, Set<UserWorkerWorkerRights> userWorkerWorkerRightses) {
		this.user = user;
		this.workerType = workerType;
		this.additionalData = additionalData;
		this.userWorkerWorkerRightses = userWorkerWorkerRightses;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "user"))
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_worker_type")
	public WorkerType getWorkerType() {
		return this.workerType;
	}

	public void setWorkerType(WorkerType workerType) {
		this.workerType = workerType;
	}

	@Column(name = "additional_data")
	public String getAdditionalData() {
		return this.additionalData;
	}

	public void setAdditionalData(String additionalData) {
		this.additionalData = additionalData;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userWorker")
	public Set<UserWorkerWorkerRights> getUserWorkerWorkerRightses() {
		return this.userWorkerWorkerRightses;
	}

	public void setUserWorkerWorkerRightses(Set<UserWorkerWorkerRights> userWorkerWorkerRightses) {
		this.userWorkerWorkerRightses = userWorkerWorkerRightses;
	}

}
