package src.main.java.com.gym17.gym17.model;
// Generated Sep 18, 2020, 8:04:59 PM by Hibernate Tools 4.3.5.Final

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
 * PrivateCoach generated by hbm2java
 */
@Entity
@Table(name = "private_coach", catalog = "heroku_4ee2ecbe460bfa4")
public class PrivateCoach implements java.io.Serializable {

	private Integer id;
	private UserCustomer userCustomer;
	private UserWorker userWorker;
	private String description;
	private Date end;
	private Date start;

	public PrivateCoach() {
	}

	public PrivateCoach(UserCustomer userCustomer, UserWorker userWorker, Date start) {
		this.userCustomer = userCustomer;
		this.userWorker = userWorker;
		this.start = start;
	}

	public PrivateCoach(UserCustomer userCustomer, UserWorker userWorker, String description, Date end, Date start) {
		this.userCustomer = userCustomer;
		this.userWorker = userWorker;
		this.description = description;
		this.end = end;
		this.start = start;
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
	@JoinColumn(name = "fk_customer", nullable = false)
	public UserCustomer getUserCustomer() {
		return this.userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_worker", nullable = false)
	public UserWorker getUserWorker() {
		return this.userWorker;
	}

	public void setUserWorker(UserWorker userWorker) {
		this.userWorker = userWorker;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end", length = 19)
	public Date getEnd() {
		return this.end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start", nullable = false, length = 19)
	public Date getStart() {
		return this.start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

}
