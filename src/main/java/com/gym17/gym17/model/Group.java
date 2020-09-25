package src.main.java.com.gym17.gym17.model;
// Generated Sep 19, 2020, 1:05:34 PM by Hibernate Tools 4.3.5.Final

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Group generated by hbm2java
 */
@Entity
@Table(name = "group", catalog = "heroku_4ee2ecbe460bfa4")
public class Group implements java.io.Serializable {

	private Integer id;
	private Boolean active;
	private Date created;
	private String description;
	private Integer maxCustomer;
	private String name;
	private Date start;
	private Integer valid;
	@JsonIgnoreProperties("group")
	private Set<GroupWeekdays> groupWeekdayses = new HashSet<GroupWeekdays>(0);
	@JsonIgnoreProperties("group")
	private Set<GroupCustomer> groupCustomers = new HashSet<GroupCustomer>(0);
	@JsonIgnoreProperties("group")
	private Set<GroupWorker> groupWorkers = new HashSet<GroupWorker>(0);

	public Group() {
	}

	public Group(String name) {
		this.name = name;
	}

	public Group(Boolean active, Date created, String description, Integer maxCustomer, String name, Date start,
			Integer valid, Set<GroupWeekdays> groupWeekdayses, Set<GroupCustomer> groupCustomers,
			Set<GroupWorker> groupWorkers) {
		this.active = active;
		this.created = created;
		this.description = description;
		this.maxCustomer = maxCustomer;
		this.name = name;
		this.start = start;
		this.valid = valid;
		this.groupWeekdayses = groupWeekdayses;
		this.groupCustomers = groupCustomers;
		this.groupWorkers = groupWorkers;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", length = 19)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "max_customer")
	public Integer getMaxCustomer() {
		return this.maxCustomer;
	}

	public void setMaxCustomer(Integer maxCustomer) {
		this.maxCustomer = maxCustomer;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start", length = 19)
	public Date getStart() {
		return this.start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	@Column(name = "valid")
	public Integer getValid() {
		return this.valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group",  cascade = CascadeType.ALL)
	public Set<GroupWeekdays> getGroupWeekdayses() {
		return this.groupWeekdayses;
	}

	public void setGroupWeekdayses(Set<GroupWeekdays> groupWeekdayses) {
		this.groupWeekdayses = groupWeekdayses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group", cascade = CascadeType.ALL)
	public Set<GroupCustomer> getGroupCustomers() {
		return this.groupCustomers;
	}

	public void setGroupCustomers(Set<GroupCustomer> groupCustomers) {
		this.groupCustomers = groupCustomers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "group", cascade = CascadeType.ALL)
	public Set<GroupWorker> getGroupWorkers() {
		return this.groupWorkers;
	}

	public void setGroupWorkers(Set<GroupWorker> groupWorkers) {
		this.groupWorkers = groupWorkers;
	}

}
