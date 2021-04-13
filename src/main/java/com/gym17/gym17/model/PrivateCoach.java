package src.main.java.com.gym17.gym17.model;
// Generated Sep 19, 2020, 3:20:31 PM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * PrivateCoach generated by hbm2java
 */
@Entity
@Table(name = "private_coach", catalog = "heroku_4ee2ecbe460bfa4")
public class PrivateCoach implements java.io.Serializable {

	private Integer id;
	@JsonIgnoreProperties(value = {"groupCustomers", "privateCoaches", "customerMembershipFees", "hibernateLazyInitializer"})
	private UserCustomer userCustomer;
	@JsonIgnoreProperties(value = {"groupWorkers", "privateCoaches", "userWorkerWorkerRightses", "hibernateLazyInitializer"})
	private UserWorker userWorker;
	private String description;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date end;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date start;
	@JsonIgnoreProperties("privateCoach")
	private Set<PrivateCoachWeekdays> privateCoachWeekdayses = new HashSet<PrivateCoachWeekdays>(0);

	public PrivateCoach() {
	}

	public PrivateCoach(UserCustomer userCustomer, UserWorker userWorker, Date start) {
		this.userCustomer = userCustomer;
		this.userWorker = userWorker;
		this.start = start;
	}
	
	public PrivateCoach(UserCustomer userCustomer, UserWorker userWorker, Date start, Date end) {
		this.userCustomer = userCustomer;
		this.userWorker = userWorker;
		this.start = start;
		this.end = end;
	}


	public PrivateCoach(UserCustomer userCustomer, UserWorker userWorker, String description, Date end, Date start,
			Set<PrivateCoachWeekdays> privateCoachWeekdayses) {
		this.userCustomer = userCustomer;
		this.userWorker = userWorker;
		this.description = description;
		this.end = end;
		this.start = start;
		this.privateCoachWeekdayses = privateCoachWeekdayses;
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
	@JoinColumn(name = "fk_customer", nullable = false)
	public UserCustomer getUserCustomer() {
		return this.userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}
	@ManyToOne(fetch = FetchType.EAGER)
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "privateCoach", cascade = CascadeType.ALL)
	public Set<PrivateCoachWeekdays> getPrivateCoachWeekdayses() {
		return this.privateCoachWeekdayses;
	}

	public void setPrivateCoachWeekdayses(Set<PrivateCoachWeekdays> privateCoachWeekdayses) {
		this.privateCoachWeekdayses = privateCoachWeekdayses;
	}

}
