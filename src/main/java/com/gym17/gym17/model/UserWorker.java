package src.main.java.com.gym17.gym17.model;
// Generated Sep 19, 2020, 3:20:31 PM by Hibernate Tools 4.3.5.Final

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * UserWorker generated by hbm2java
 */
@Entity
@Table(name = "user_worker", catalog = "heroku_4ee2ecbe460bfa4")
public class UserWorker implements java.io.Serializable {

	private int id;
	@JsonIgnoreProperties(value = {"userWorker", "activityLists", "userCustomer"})
	private User user;
	@JsonIgnoreProperties("userWorkers")
	private WorkerType workerType;
	private String additionalData;
	@JsonIgnoreProperties(value = {"userWorker","userCustomer"})
	private Set<PrivateCoach> privateCoaches = new HashSet<PrivateCoach>(0);
	@JsonIgnoreProperties("userWorker")
	private Set<UserWorkerWorkerRights> userWorkerWorkerRightses = new HashSet<UserWorkerWorkerRights>(0);
	@JsonIgnoreProperties(value = {"groupWorkers", "userWorker","groupCustomers"})
	private Set<GroupWorker> groupWorkers = new HashSet<GroupWorker>(0);

	public UserWorker() {
	}

	public UserWorker(User user) {
		this.user = user;
	}

	public UserWorker(User user, WorkerType workerType, String additionalData, Set<PrivateCoach> privateCoaches,
			Set<UserWorkerWorkerRights> userWorkerWorkerRightses, Set<GroupWorker> groupWorkers) {
		this.user = user;
		this.workerType = workerType;
		this.additionalData = additionalData;
		this.privateCoaches = privateCoaches;
		this.userWorkerWorkerRightses = userWorkerWorkerRightses;
		this.groupWorkers = groupWorkers;
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
	public Set<PrivateCoach> getPrivateCoaches() {
		return this.privateCoaches;
	}

	public void setPrivateCoaches(Set<PrivateCoach> privateCoaches) {
		this.privateCoaches = privateCoaches;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userWorker")
	public Set<UserWorkerWorkerRights> getUserWorkerWorkerRightses() {
		return this.userWorkerWorkerRightses;
	}

	public void setUserWorkerWorkerRightses(Set<UserWorkerWorkerRights> userWorkerWorkerRightses) {
		this.userWorkerWorkerRightses = userWorkerWorkerRightses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userWorker")
	public Set<GroupWorker> getGroupWorkers() {
		return this.groupWorkers;
	}

	public void setGroupWorkers(Set<GroupWorker> groupWorkers) {
		this.groupWorkers = groupWorkers;
	}

}
