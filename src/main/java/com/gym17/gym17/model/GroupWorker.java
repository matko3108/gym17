package src.main.java.com.gym17.gym17.model;
// Generated Sep 16, 2020, 7:54:25 PM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * GroupWorker generated by hbm2java
 */
@Entity
@Table(name = "group_worker", catalog = "heroku_4ee2ecbe460bfa4")
public class GroupWorker implements java.io.Serializable {

	private Integer id;
	private int fkGroup;
	private int fkWorker;

	public GroupWorker() {
	}

	public GroupWorker(int fkGroup, int fkWorker) {
		this.fkGroup = fkGroup;
		this.fkWorker = fkWorker;
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

	@Column(name = "fk_group", nullable = false)
	public int getFkGroup() {
		return this.fkGroup;
	}

	public void setFkGroup(int fkGroup) {
		this.fkGroup = fkGroup;
	}

	@Column(name = "fk_worker", nullable = false)
	public int getFkWorker() {
		return this.fkWorker;
	}

	public void setFkWorker(int fkWorker) {
		this.fkWorker = fkWorker;
	}

}
