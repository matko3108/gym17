package src.main.java.com.gym17.gym17.model;
// Generated Sep 19, 2020, 1:05:34 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * GroupWorker generated by hbm2java
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)

@Table(name = "group_worker", catalog = "heroku_4ee2ecbe460bfa4")
public class GroupWorker implements java.io.Serializable {

	private Integer id;
	@JsonIgnoreProperties(value = {"groupWorkers", "hibernateLazyInitializer"})
	private Group group;
	@JsonIgnoreProperties(value = {"groupWorkers", "privateCoaches", "userWorkerWorkerRightses", "hibernateLazyInitializer"})
	private UserWorker userWorker;

	public GroupWorker() {
	}

	public GroupWorker(Group group, UserWorker userWorker) {
		this.group = group;
		this.userWorker = userWorker;
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
	@JoinColumn(name = "fk_group", nullable = false)
	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_worker", nullable = false)
	public UserWorker getUserWorker() {
		return this.userWorker;
	}

	public void setUserWorker(UserWorker userWorker) {
		this.userWorker = userWorker;
	}

}
